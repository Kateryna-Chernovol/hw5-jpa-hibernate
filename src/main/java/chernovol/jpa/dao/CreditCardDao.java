package chernovol.jpa.dao;

import chernovol.jpa.dmo.CreditCard;
import chernovol.jpa.dmo.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class CreditCardDao {//CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(CreditCard creditCard) {
        if (!Objects.isNull(creditCard)) {
            entityManager.persist(creditCard);
        }
    }

    public CreditCard getById(Long id) {
        return entityManager.find(CreditCard.class, id);
    }

//    public CreditCard findById(int id) {
//        if (id != 0) {
//            return entityManager.find(CreditCard.class, id);
//        } else {
//            return null;
//        }
//    }

    public void update(Long number, CreditCard creditCard) { //merge
        creditCard.setNumber(number);
        save(creditCard);
    }

    public void replenish(int amount, CreditCard creditCard) {
        creditCard.setBalance(creditCard.getBalance() + amount);
        entityManager.persist(creditCard);
    }

    public void delete(CreditCard creditCard) {
        if (!Objects.isNull(creditCard)) {
            entityManager.remove(creditCard);
        }
    }

    @SuppressWarnings("unchecked")
    public List<CreditCard> showAllCards() {
        return entityManager.createQuery("FROM CreditCard c").getResultList();
    }


}
