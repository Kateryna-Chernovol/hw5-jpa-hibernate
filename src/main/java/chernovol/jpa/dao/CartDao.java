package chernovol.jpa.dao;

import chernovol.jpa.dmo.Cart;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CartDao { //CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Cart cart) {
        entityManager.persist(cart);
    }

    public Cart getById(Long id) {
        return entityManager.find(Cart.class, id);
    }

    public void update(Cart cart) {
        entityManager.merge(cart);
    }

    public void delete(Cart cart) {
        entityManager.remove(cart);
    }

    public List<Cart> getAll() {
        return entityManager.createQuery("SELECT c FROM Cart c").getResultList();
    }

}
