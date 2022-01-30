package chernovol.jpa.dao;

import chernovol.jpa.dmo.Cart;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class CartDao { //CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Cart cart) {
        if (!Objects.isNull(cart)) {
            entityManager.persist(cart);
        }
    }

    public Cart getById(int id) {
        if (id != 0) {
            return entityManager.find(Cart.class, id);
        } else {
            return null;
        }
    }

    // update

    public void delete(Cart cart) {
        if (!Objects.isNull(cart)) {
            entityManager.remove(cart);
        }
    }

    public List<Cart> getAll() {
        return entityManager.createQuery("SELECT c FROM Cart c").getResultList();
    }

}
