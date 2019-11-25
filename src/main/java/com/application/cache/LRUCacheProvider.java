package com.application.cache;

import com.application.hibernate.entity.TransactionEntity;
import com.mysql.cj.util.LRUCache;

import static com.application.utils.Constants.Cache.LRU_CACHE_CAPACITY;

public class LRUCacheProvider {
    private static LRUCacheProvider instance;
    private LRUCache<Integer, TransactionEntity> lruCache = new LRUCache<>(LRU_CACHE_CAPACITY);

    public static synchronized LRUCacheProvider getInstance() {
        if (instance == null) {
            instance = new LRUCacheProvider();
        }
        return instance;
    }

    public TransactionEntity getFromCache(Integer transactionId) {
        return lruCache.get(transactionId);
    }

    public void saveInCache(TransactionEntity transactionEntity) {
        lruCache.put(transactionEntity.getId(), transactionEntity);
    }
}
