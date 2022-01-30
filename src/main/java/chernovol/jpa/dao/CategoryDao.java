package chernovol.jpa.dao;

import chernovol.jpa.dmo.Category;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class CategoryDao { //CRUD

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category) {
        if (!Objects.isNull(category)) {
            entityManager.persist(category);
        }
    }

    public Category findById(int id) {
        if (id != 0) {
            return entityManager.find(Category.class, id);
        } else {
            return null;
        }
    }

    //update merge
    public void update(Category category) {
        entityManager.merge(category);
        entityManager.flush();
        entityManager.clear();
    }

    public void delete(Category category) {
        if (!Objects.isNull(category)) {
            entityManager.remove(category);
        }
    }

    public List<Category> categoriesList() {
        return entityManager.createQuery("FROM Category c").getResultList();
    }
}
