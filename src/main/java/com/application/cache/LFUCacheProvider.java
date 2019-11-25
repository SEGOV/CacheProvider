package com.application.cache;

import com.application.hibernate.entity.BaseEntity;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCacheProvider implements CacheProvider{
    private static LFUCacheProvider instance;
    private HashMap<Integer, BaseEntity> lfuCache = new HashMap<>(); // Cache K and V
    private HashMap<Integer, Integer> lfuCacheKeysCountersMap = new HashMap<>(); // K and counters
    private HashMap<Integer, LinkedHashSet<Integer>> counterItemsListMap = new HashMap<>(); // Counter and item list
    private int capacity;
    private int min = -1;

    public static synchronized LFUCacheProvider getInstance(int capacity) {
        if (instance == null) {
            instance = new LFUCacheProvider(capacity);
        }
        return instance;
    }

    public LFUCacheProvider(int capacity) {
        this.capacity = capacity;
        counterItemsListMap.put(1, new LinkedHashSet<>());
    }

    public BaseEntity getFromCache(int key) {
        if (!lfuCache.containsKey(key)) {
            return null;
        }
        int count = lfuCacheKeysCountersMap.get(key);
        lfuCacheKeysCountersMap.put(key, count + 1);
        counterItemsListMap.get(count).remove(key);
        if (count == min && counterItemsListMap.get(count).size() == 0) {
            min++;
        }
        if (!counterItemsListMap.containsKey(count + 1)) {
            counterItemsListMap.put(count + 1, new LinkedHashSet<>());
        }
        counterItemsListMap.get(count + 1).add(key);
        return lfuCache.get(key);
    }

    public void saveInCache(BaseEntity entity) {
        int key = entity.getId();
        if (capacity <= 0) {
            return;
        }
        if (lfuCache.containsKey(key)) {
            lfuCache.put(key, entity);
            getFromCache(key);
            return;
        }
        if (lfuCache.size() >= capacity) {
            int evictionNumber = counterItemsListMap.get(min).iterator().next();
            counterItemsListMap.get(min).remove(evictionNumber);
            lfuCache.remove(evictionNumber);
            lfuCacheKeysCountersMap.remove(evictionNumber);
        }
        lfuCache.put(key, entity);
        lfuCacheKeysCountersMap.put(key, 1);
        min = 1;
        counterItemsListMap.get(1).add(key);
    }
}
