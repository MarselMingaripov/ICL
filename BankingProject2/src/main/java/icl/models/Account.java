package icl.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private Integer accountNumber;
    private BigDecimal Balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> TransactionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal Balance) {
        this.Balance = Balance;
    }

    public List<Transaction> getTransactionList() {
        return TransactionList;
    }

    public void setTransactionList(List<Transaction> TransactionList) {
        this.TransactionList = TransactionList;
    }


}
