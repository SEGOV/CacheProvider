package com.application.cache;

public class LFUCacheProvider {
    private static LFUCacheProvider instance;

    public static synchronized LFUCacheProvider getInstance() {
        if (instance == null) {
            instance = new LFUCacheProvider();
        }
        return instance;
    }
}
