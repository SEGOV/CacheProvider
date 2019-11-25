package com.application.cache;

import com.application.hibernate.entity.BaseEntity;
import com.mysql.cj.util.LRUCache;

public class LRUCacheProvider implements CacheProvider{
    private static LRUCacheProvider instance;
    private LRUCache<Integer, BaseEntity> lruCache;
    private int capacity;

    public static synchronized LRUCacheProvider getInstance(int capacity) {
        if (instance == null) {
            instance = new LRUCacheProvider(capacity);
        }
        return instance;
    }

    public LRUCacheProvider(int capacity) {
        this.capacity = capacity;
        lruCache = new LRUCache<>(this.capacity);
    }

    public BaseEntity getFromCache(int id) {
        return lruCache.get(id);
    }

    public void saveInCache(BaseEntity entity) {
        lruCache.put(entity.getId(), entity);
    }
}
