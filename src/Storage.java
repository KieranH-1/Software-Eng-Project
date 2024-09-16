
public abstract class Storage{
	public void storage(StoreData data)
	{
		// store data
		StorageAddResponse storeData = data.storeData(new DataStorageRequest());
		
		StorageLoadResponse loadData = data.loadData(storeData.getDataKey());
	}

	abstract ReadOutputResponse readFrom();

}
