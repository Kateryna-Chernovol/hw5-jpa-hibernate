package chernovol.jpa.dao;

import chernovol.jpa.dmo.CreditCard;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CreditCardDao {//CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(CreditCard creditCard) {
        entityManager.persist(creditCard);
    }

    public CreditCard getById(Long id) {
        return entityManager.find(CreditCard.class, id);
    }

    public void update(CreditCard creditCard) {
        entityManager.merge(creditCard);
    }

    public void delete(CreditCard creditCard) {
        entityManager.remove(creditCard);
    }
}
