package chernovol.jpa.dao;

import chernovol.jpa.dmo.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class UserDao {//CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        if (!Objects.isNull(user)) {
            entityManager.persist(user);
        }
    }

    public void delete(User user) {
        if (!Objects.isNull(user)) {
            entityManager.remove(user);
        }
    }

    public User getById(int id) {
        if (id != 0) {
            return entityManager.find(User.class, id);
        } else {
            return null;
        }
    }

    //update credit card; unlink
    //

    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("FROM User u").getResultList();
    }
}
