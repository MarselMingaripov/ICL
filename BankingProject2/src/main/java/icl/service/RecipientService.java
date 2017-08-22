package icl.service;


import icl.models.Account;
import icl.models.Recipient;

import java.util.List;

public interface RecipientService {

    List<Recipient> findRecipientList(String name);

    Recipient saveRecipient(Recipient recipient);

    Recipient findRecipientByAccountNumber(int recipientAccountNumber);

    void deleteRecipientByAccountNumber(int recipientAccountNumber);

    void toSomeoneElseTransfer(Recipient recipient, String amount, Account account);
}
