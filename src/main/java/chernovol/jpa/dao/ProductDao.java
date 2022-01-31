package chernovol.jpa.dao;

import chernovol.jpa.dmo.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Product product) {
        entityManager.persist(product);
    }

    public Product getById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void update(Product product) {
        entityManager.merge(product);
    }

    public void delete(Product product) {
        entityManager.remove(product);
    }

    public List<Product> getAll() {
        return entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }
}
