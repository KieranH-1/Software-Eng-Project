
public interface StoreData {
	StorageAddResponse storeData(DataStorageRequest request);
	StorageLoadResponse loadData(DataStorageKey key);
}
