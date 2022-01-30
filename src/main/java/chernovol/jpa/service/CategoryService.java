package chernovol.jpa.service;

import chernovol.jpa.dao.CategoryDao;
import chernovol.jpa.dmo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Transactional
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Transactional
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Transactional
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Transactional(readOnly = true)
    public List<Category> categoriesList() {
        return categoryDao.categoriesList();
    }
}
