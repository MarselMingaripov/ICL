package icl.service;


import icl.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findTransactionList(String name);

    void saveDepositTransaction(Transaction transaction);

    void saveWithdrawTransaction(Transaction transaction);

}
