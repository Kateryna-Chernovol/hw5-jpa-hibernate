package chernovol.jpa.dao;

import chernovol.jpa.dmo.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ProductDao {//CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Product product) {
        entityManager.persist(product);
        flushAndClear();
    }

    public Product getById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void update(Product product) {
        entityManager.merge(product);
        flushAndClear();
    }

    public void delete(long id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        flushAndClear();
    }

//    public Product getProduct(long id) {
//        return entityManager.find(Product.class, id);
//    }


    public List<Product> getAll() {
        return entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
