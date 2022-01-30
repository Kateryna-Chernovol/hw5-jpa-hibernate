package chernovol.jpa.dmo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long number;
    private int balance;

    public CreditCard() {
    }

    public CreditCard(Long number, int balance) {
        this.number = number;
        this.balance = balance;
    }

//    public CreditCard(int balance) {
//        this.balance = balance;
//    }


    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number=" + number +
                ", balance=" + balance +
                '}';
    }
}
