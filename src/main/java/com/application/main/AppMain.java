package com.application.main;

public class AppMain {
    public static void main(String[] args) {

        /**          Generate TransactionEntities more then 18 for correct tests like this              **/

        /*          for(int i = 0; i < 18; i++) {                                                        */
        /*               TransactionEntity entity = new TransactionEntity();                             */
        /*                entity.setNumber(i);                                                           */
        /*                new TransactionDao().saveTransaction(entity);                                  */
        /*          }                                                                                    */

        /**                 After that we can get Entity uses two cache strategy:                       **/

        /**                        - with Least Recently Used strategy -                                **/

        /*      TransactionDao transactionDao = new TransactionDao(LRUCacheProvider.getInstance(2));          // TODO: With capacity = 2 (for example)                   */
        /*      TransactionEntity transaction = (TransactionEntity) transactionDao.getTransactionById(2);     // TODO: With Transaction id = 2 (for example)             */

        /**                        - with Least Frequently Used strategy -                              **/

        /*      TransactionDao transactionDao = new TransactionDao(LFUCacheProvider.getInstance(3));          // TODO: With capacity = 3 (for example)                   */
        /*      TransactionEntity transaction = (TransactionEntity) transactionDao.getTransactionById(3);     // TODO: With Transaction id = 3 (for example)             */
    }
}
