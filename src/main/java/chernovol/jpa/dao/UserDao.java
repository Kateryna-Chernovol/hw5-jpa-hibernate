package chernovol.jpa.dao;

import chernovol.jpa.dmo.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDao {//CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public List<User> allUsers() {
        return entityManager.createQuery("FROM User u").getResultList();
    }
}
