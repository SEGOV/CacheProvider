//package com.application.cache.lru;
//
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Objects;
//
//public class CacheLruProvider {
//    private int capacity;
//    private LinkedHashMap<Integer,Integer> lruCacheMap;
//
//    public CacheLruProvider(int capacity) {
//        this.capacity = capacity;
//        this.lruCacheMap = new LinkedHashMap<>();
//    }
//
//    public int get(int key) {
//        Integer lruCacheMapValue = this.lruCacheMap.get(key);
//        if (Objects.isNull(lruCacheMapValue)) {
//            lruCacheMapValue = -1;
//        } else {
//            this.set(key, lruCacheMapValue);
//        }
//        return lruCacheMapValue;
//    }
//
//    public void set(int key, int value) {
//        if (this.lruCacheMap.containsKey(key)) {
//            this.lruCacheMap.remove(key);
//        } else if (this.lruCacheMap.size() == this.capacity) {
//            Iterator<Integer> lruCacheMapIterator = this.lruCacheMap.keySet().iterator();
//            lruCacheMapIterator.next();
//            lruCacheMapIterator.remove();
//        }
//        lruCacheMap.put(key, value);
//    }
//}
