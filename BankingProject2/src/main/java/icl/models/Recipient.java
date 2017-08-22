package icl.models;

import javax.persistence.*;

@Entity
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(unique = true)
    private Integer recipientAccountNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRecipientAccountNumber() {
        return recipientAccountNumber;
    }

    public void setRecipientAccountNumber(Integer recipientAccountNumber) {
        this.recipientAccountNumber = recipientAccountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
