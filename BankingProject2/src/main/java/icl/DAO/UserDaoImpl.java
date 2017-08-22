package icl.DAO;

import icl.models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));
        User user = (User) criteria.uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }
}
