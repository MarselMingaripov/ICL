package icl.service;

import icl.DAO.AccountDao;
import icl.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionService transactionService;

    @Override
    public User findByUsername(String name) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }
}
