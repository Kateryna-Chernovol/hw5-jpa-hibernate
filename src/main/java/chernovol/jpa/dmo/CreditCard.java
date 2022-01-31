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

    public CreditCard() {
    }

    public CreditCard(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
