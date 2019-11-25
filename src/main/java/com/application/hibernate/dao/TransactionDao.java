package com.application.hibernate.dao;

import com.application.cache.LRUCacheProvider;
import com.application.hibernate.entity.TransactionEntity;
import com.application.hibernate.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Objects;

public class TransactionDao {
    private Transaction transaction;

    public TransactionEntity getTransactionById(Integer transactionId) {
        TransactionEntity transactionEntityFromCache = LRUCacheProvider.getInstance().getFromCache(transactionId);
        if(Objects.nonNull(transactionEntityFromCache)) {
            return transactionEntityFromCache;
        }

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        TransactionEntity transactionEntity = session.get(TransactionEntity.class, transactionId);
        transaction.commit();
        session.close();
        LRUCacheProvider.getInstance().saveInCache(transactionEntity);
        return transactionEntity;
    }

    public void saveTransaction(TransactionEntity transactionEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(transactionEntity);
        transaction.commit();
        session.close();
    }
}
