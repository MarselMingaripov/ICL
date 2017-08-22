package icl.DAO;


import icl.models.Recipient;

import java.util.List;

public interface RecipientDao {

    List<Recipient> findAll(String name);

    Recipient findByAccountNumber(int recipientAccountNumber);

    void deleteByAccountNumber(int recipientAccountNumber);

    Recipient save(Recipient recipient);
}
