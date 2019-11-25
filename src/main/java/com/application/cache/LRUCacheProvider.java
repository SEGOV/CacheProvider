package com.application.cache;

import com.application.hibernate.entity.BaseEntity;
import com.mysql.cj.util.LRUCache;

import static com.application.utils.Constants.Cache.LRU_CACHE_CAPACITY;

public class LRUCacheProvider implements CacheProvider{
    private static LRUCacheProvider instance;
    private LRUCache<Integer, BaseEntity> lruCache = new LRUCache<>(LRU_CACHE_CAPACITY);

    public static synchronized LRUCacheProvider getInstance() {
        if (instance == null) {
            instance = new LRUCacheProvider();
        }
        return instance;
    }

    public BaseEntity getFromCache(int id) {
        return lruCache.get(id);
    }

    public void saveInCache(BaseEntity entity) {
        lruCache.put(entity.getId(), entity);
    }
}
