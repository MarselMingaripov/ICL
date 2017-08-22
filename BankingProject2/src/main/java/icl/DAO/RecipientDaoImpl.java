package icl.DAO;

import icl.models.Recipient;
import icl.models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipientDaoImpl implements RecipientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Recipient> findAll(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));
        User user = (User) criteria.uniqueResult();
        List<Recipient> recipientList = user.getRecipientList();
        session.getTransaction().commit();
        return recipientList;
    }

    @Override
    public Recipient findByAccountNumber(int recipientAccountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Recipient.class);
        criteria.add(Restrictions.eq("recipientAccountNumber", recipientAccountNumber));
        Recipient recipient = (Recipient) criteria.uniqueResult();
        session.getTransaction().commit();
        return recipient;
    }

    @Override
    public void deleteByAccountNumber(int recipientAccountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Recipient.class);
        criteria.add(Restrictions.eq("recipientAccountNumber", recipientAccountNumber));
        Recipient recipient = (Recipient) criteria.uniqueResult();
        session.delete(recipient);
        session.getTransaction().commit();
    }

    @Override
    public Recipient save(Recipient recipient) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(recipient);
        session.getTransaction().commit();
        return recipient;
    }
}
