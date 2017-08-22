package icl.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id", nullable = false, updatable = false)
    private Long userId;
    private String name;
    private String surName;

    @OneToOne
    private Account account;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Recipient> recipientList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User() {
    }

    public User(String name, String surName, Account account, List<Recipient> recipientList) {
        this.name = name;
        this.surName = surName;
        this.account = account;
        this.recipientList = recipientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Recipient> getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(List<Recipient> recipientList) {
        this.recipientList = recipientList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + name + '\'' +
                ", userSurName='" + surName + '\'' +
                ", recipientList=" + recipientList +
                '}';
    }
}
