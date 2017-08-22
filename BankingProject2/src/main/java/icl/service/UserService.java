package icl.service;


import icl.models.User;

public interface UserService {
    User findByUsername(String name);

    User createUser(User user);

    User saveUser(User user);
}
