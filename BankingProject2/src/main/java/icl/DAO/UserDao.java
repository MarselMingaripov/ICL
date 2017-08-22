package icl.DAO;


import icl.models.User;

public interface UserDao {
    User findByName(String name);

    User save(User user);
}
