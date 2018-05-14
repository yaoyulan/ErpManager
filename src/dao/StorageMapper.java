package dao;

import pojo.Pager;
import pojo.Storage;

import java.util.List;

public interface StorageMapper {

    public int addStorage(Storage storage);

    public List<Storage> getStorage(Pager pager);

    public int getStorageCount();

    public String getLastCode();

    public int isExistCommodityName(String name);
}
