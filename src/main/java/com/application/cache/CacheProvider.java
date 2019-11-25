package com.application.cache;

import com.application.hibernate.entity.BaseEntity;

public interface CacheProvider {
    BaseEntity getFromCache(int transactionId);
    void saveInCache(BaseEntity transactionEntity);
}
