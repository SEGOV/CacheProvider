package com.application.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int size;

    private LRUCache(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    public static <K, V> LRUCache<K, V> newInstance(int size) {
        return new LRUCache<>(size);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }
}
