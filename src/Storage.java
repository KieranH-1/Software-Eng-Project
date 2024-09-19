
public interface Storage{
	public void storage(StoreData data)
	{
		// store data
		StorageAddResponse storeData = data.storeData(new DataStorageRequest());
		
		StorageLoadResponse loadData = data.loadData(storeData.getDataKey());
	}

	ReadOutputResponse readFrom();
	ReadOutputResponse writeTo();

}

