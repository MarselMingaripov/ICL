package icl.DAO;

import icl.models.Transaction;

import java.util.List;

public interface TransactionDao {

    void save(Transaction transaction);

    List<Transaction> findAll(Integer accountNumber);

    List<Transaction> findAllOrderByAmount();
}
