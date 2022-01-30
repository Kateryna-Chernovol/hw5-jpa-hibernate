package chernovol.jpa.dmo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category", unique = true, nullable = false)
    private String categoryName;

    @OneToMany
    List<Product> products = new ArrayList<>();

    public Category() {
    }

//    public Category(String category) {
//        this.categoryName = category;
//    }

    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{ " +
                "id = " + id +
                ", category name '" + categoryName + '\'' +
                ", products = " + products +
                '}';
    }
}
