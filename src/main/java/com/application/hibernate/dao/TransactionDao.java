package com.application.hibernate.dao;

import com.application.cache.CacheProvider;
import com.application.hibernate.entity.BaseEntity;
import com.application.hibernate.entity.TransactionEntity;
import com.application.hibernate.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Objects;

public class TransactionDao {
    private Transaction transaction;
    private CacheProvider cacheProvider;

    public TransactionDao(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }

    public BaseEntity getTransactionById(Integer transactionId) {
        BaseEntity entityFromCache = cacheProvider.getFromCache(transactionId);
        if(Objects.nonNull(entityFromCache)) {
            return entityFromCache;
        }

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        TransactionEntity transactionEntity = session.get(TransactionEntity.class, transactionId);
        transaction.commit();
        session.close();
        cacheProvider.saveInCache(transactionEntity);
        return transactionEntity;
    }

    public void saveTransaction(TransactionEntity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }
}
