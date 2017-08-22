package icl.DAO;

import icl.models.Account;

public interface AccountDao {

    Account findByAccountNumber(Integer accountNumber);

    Account save(Account account);

    Integer getMaxAccountNumber();
}
