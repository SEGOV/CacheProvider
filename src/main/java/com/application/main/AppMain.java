package com.application.main;

import com.application.hibernate.dao.TransactionDao;
import com.application.hibernate.entity.TransactionEntity;

public class AppMain {
    public static void main(String[] args) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setNumber(3);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.saveTransaction(transactionEntity);

        TransactionEntity te1 = transactionDao.getTransactionById(13);
        TransactionEntity te2 = transactionDao.getTransactionById(14);
        TransactionEntity te3 = transactionDao.getTransactionById(15);

        TransactionEntity te4 = transactionDao.getTransactionById(15);
    }
}
