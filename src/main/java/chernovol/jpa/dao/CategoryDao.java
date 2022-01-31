package chernovol.jpa.dao;

import chernovol.jpa.dmo.Category;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category getById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove(category);
    }

    public List<Category> allCategoriesList() {
        return entityManager.createQuery("SELECT c FROM Category c").getResultList();
    }
}
