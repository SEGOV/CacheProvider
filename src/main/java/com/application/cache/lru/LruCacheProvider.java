package com.application.cache.lru;

public class LruCacheProvider {
    public void provideCache() {
        LRUCache<Integer, Integer> cache = LRUCache.newInstance(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.put(3, 3);

        System.out.println(cache);
    }
}
