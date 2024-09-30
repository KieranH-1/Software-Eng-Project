

public class ComputeEngineImpl implements ComputeEngine {

	@Override
	public String compute(int value) {
		
		String valueString = "" + value;
		String valueAsWord = "";
		final int length = valueString.length();
		
		char currentChar = valueString.charAt(0);
		char nextChar = '/';
		
		for (int i = 0; i < length; i++) {
			currentChar = valueString.charAt(i);
			if (i == 0 && length == 3) {
				if (currentChar == '0') {
					valueAsWord += ""; }
				if (currentChar == '1') { 
					valueAsWord += "one-hundred"; }
				if (currentChar == '2') {
					valueAsWord += "two-hundred"; }
				if (currentChar == '3') {
					valueAsWord += "three-hundred"; }
				if (currentChar == '4') {
					valueAsWord += "four-hundred"; }
				if (currentChar == '5') {
					valueAsWord += "five-hundred"; }
				if (currentChar == '6') {
					valueAsWord += "six-hundred"; }
				if (currentChar == '7') {
					valueAsWord += "seven-hundred"; }
				if (currentChar == '8') {
					valueAsWord += "eight-hundred"; }
				if (currentChar == '9') {
					valueAsWord += "nine-hundred"; }
				valueAsWord += " ";
			}
			if ((i == 0 && length == 2) || (i == 1 && length == 3)) {
				if (currentChar == '0') {
					valueAsWord += "";
				}
				if (currentChar == '1') {
					
					nextChar = valueString.charAt(i + 1);
					
					if(nextChar == '0') {
						valueAsWord += "ten"; }
					if(nextChar == '1') {
						valueAsWord += "eleven"; }
					if(nextChar == '2') {
						valueAsWord += "twelve"; }
					if(nextChar == '3') {
						valueAsWord += "thirteen"; }
					if(nextChar == '4') {
						valueAsWord += "fourteen"; }
					if(nextChar == '5') {
						valueAsWord += "fifteen"; }
					if(nextChar == '6') {
						valueAsWord += "sixteen"; }
					if(nextChar == '7') {
						valueAsWord += "seventeen"; }
					if(nextChar == '8') {
						valueAsWord += "eighteen"; }
					if(nextChar == '9') {
						valueAsWord += "nineteen"; }
					
					i = length;
				}		
				if (currentChar == '2') {
					valueAsWord += "twenty"; }
				if (currentChar == '3') {
					valueAsWord += "thirty"; }
				if (currentChar == '4') {
					valueAsWord += "fourty"; }
				if (currentChar == '5') {
					valueAsWord += "fifty"; }
				if (currentChar == '6') {
					valueAsWord += "sixty"; }
				if (currentChar == '7') {
					valueAsWord += "seventy"; }
				if (currentChar == '8') {
					valueAsWord += "eighty"; }
				if (currentChar == '9') {
					valueAsWord += "ninety"; }

				valueAsWord += " ";
			}
			if ((length == 1) || (i == 1 && length == 2) || (i == 2 && length == 3)) {
				if (currentChar == '0') {
					valueAsWord += "zero"; }
				if (currentChar == '1') {
					valueAsWord += "one"; }
				if (currentChar == '2') {
					valueAsWord += "two"; }
				if (currentChar == '3') {
					valueAsWord += "three"; }
				if (currentChar == '4') {
					valueAsWord += "four"; }
				if (currentChar == '5') {
					valueAsWord += "five"; }
				if (currentChar == '6') {
					valueAsWord += "six"; }
				if (currentChar == '7') {
					valueAsWord += "seven"; }
				if (currentChar == '8') {
					valueAsWord += "eight"; }
				if (currentChar == '9') {
					valueAsWord += "nine"; }
			}
		}	
		return valueAsWord;
	}
}