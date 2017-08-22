package icl.DAO;

import icl.models.Account;
import icl.models.Transaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Transaction transaction) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(transaction);
        session.close();

    }

    @Override
    public List<Transaction> findAll(Integer accountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Account.class);
        criteria.add(Restrictions.eq("accountNumber", accountNumber));
        Account account = (Account) criteria.uniqueResult();
        List<Transaction> transactionList = account.getTransactionList();
        session.getTransaction().commit();
        return transactionList;
    }

    @Override
    public List<Transaction> findAllOrderByAmount() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Transaction.class);
        List<Transaction> transactionList = criteria.addOrder(Order.asc("amount")).list();
        session.getTransaction().commit();
        return transactionList;
    }
}
