package com.application.main;

import com.application.hibernate.dao.TransactionDao;
import com.application.hibernate.entity.TransactionEntity;

public class AppMain {
    public static void main(String[] args) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setNumber(3);

        TransactionDao.getInstance().saveTransaction(transactionEntity);

        TransactionEntity contact = TransactionDao.getInstance().getTransactionById(1);
        System.out.println("==========================" + contact.getNumber());
    }
}
