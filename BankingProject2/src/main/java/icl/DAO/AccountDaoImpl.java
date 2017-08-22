package icl.DAO;

import icl.models.Account;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Account findByAccountNumber(Integer accountNumber) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Account.class);
        criteria.add(Restrictions.eq("accountNumber", accountNumber));
        Account account = (Account) criteria.uniqueResult();
        session.close();
        return account;
    }

    @Override
    public Account save(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(account);
        session.getTransaction().commit();
        return account;
    }

    @Override
    public Integer getMaxAccountNumber() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select max(accountNumber) from Account");
        Integer max = (Integer) query.list().get(0);
        session.close();
        return max;
    }
}
