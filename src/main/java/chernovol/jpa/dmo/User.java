package chernovol.jpa.dmo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "shopping_history",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> shoppingHistory;

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
