package com.application.hibernate.dao;

import com.application.hibernate.entity.TransactionEntity;
import com.application.hibernate.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionDao {
    private static final TransactionDao INSTANCE = new TransactionDao();
    private Transaction transaction;

    public static TransactionDao getInstance() {
        return INSTANCE;
    }

    public void saveTransaction(TransactionEntity transactionEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(transactionEntity);
        transaction.commit();
        session.close();
    }

    public TransactionEntity getTransactionById(Integer transactionId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        TransactionEntity transactionEntity = session.get(TransactionEntity.class, transactionId);
        transaction.commit();
        session.close();
        return transactionEntity;
    }
}
