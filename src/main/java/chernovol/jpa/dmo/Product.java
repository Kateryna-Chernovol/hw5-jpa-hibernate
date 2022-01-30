package chernovol.jpa.dmo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    private int price;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "product_name"),
            inverseJoinColumns = @JoinColumn(name = "product_name", referencedColumnName = "id")
    )
    List<Cart> carts;

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product " +
                "id: " + id +
                ", name '" + name + '\'' +
                ", price = " + price +
                ' ';
    }
}
