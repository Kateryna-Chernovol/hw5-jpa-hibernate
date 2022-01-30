package chernovol.jpa.dmo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", referencedColumnName = "product_name")
//    private List<Product> productList;

    @OneToOne
    User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "product_name"),
            inverseJoinColumns = @JoinColumn(name = "product_name", referencedColumnName = "id")
    )
    List<Product> products;

    public Cart() {
    }

    public Cart(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
