package com.application.main;

import com.application.hibernate.dao.TransactionDao;
import com.application.hibernate.entity.TransactionEntity;

public class AppMain {
    public static void main(String[] args) {
        TransactionDao transactionDao = new TransactionDao();

        TransactionEntity te1 = (TransactionEntity)transactionDao.getTransactionById(13);
        TransactionEntity te2 = (TransactionEntity)transactionDao.getTransactionById(14);
        TransactionEntity te3 = (TransactionEntity)transactionDao.getTransactionById(15);

        TransactionEntity te4 = (TransactionEntity)transactionDao.getTransactionById(15);




//        TransactionEntity te1 = (TransactionEntity)transactionDao.getTransactionById(13);
//        TransactionEntity te2 = (TransactionEntity)transactionDao.getTransactionById(14);
//        TransactionEntity te3 = (TransactionEntity)transactionDao.getTransactionById(15);
//
//        TransactionEntity te4 = (TransactionEntity)transactionDao.getTransactionById(14);
//        TransactionEntity te5 = (TransactionEntity)transactionDao.getTransactionById(15);
//        TransactionEntity te6 = (TransactionEntity)transactionDao.getTransactionById(16);
    }
}
