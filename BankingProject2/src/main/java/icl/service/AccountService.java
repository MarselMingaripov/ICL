package icl.service;


import icl.models.Account;

public interface AccountService {
    Account createAccount();

    void deposit(double amount);

    void withdraw(double amount);

}
