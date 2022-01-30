package chernovol.jpa.dmo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;

    @OneToOne
    CreditCard creditCard;

    public User() {
    }

    public User(String nickname, CreditCard creditCard) {
        this.nickname = nickname;
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "User " + "id " + id +
                ", nickname '" + nickname + "\', " +
                "creditCard " + creditCard;
    }

}
