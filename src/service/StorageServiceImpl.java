package service;


import dao.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Pager;
import pojo.Storage;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {


    @Autowired
    private StorageMapper storageMapper;
    @Override
    public int addStorage(Storage storage) {
        return storageMapper.addStorage(storage);
    }

    @Override
    public int getStorageCount() {
        return storageMapper.getStorageCount();
    }

    @Override
    public String getLastCode() {
        return storageMapper.getLastCode();
    }

    @Override
    public int isExistCommodityName(String name) {
        return storageMapper.isExistCommodityName(name);
    }

    @Override
    public List<Storage> getStorage(Pager pager) {
        return storageMapper.getStorage(pager);
    }
}
