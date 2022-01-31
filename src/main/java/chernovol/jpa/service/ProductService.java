package chernovol.jpa.service;

import chernovol.jpa.dao.ProductDao;
import chernovol.jpa.dmo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void add(Product product) {
        productDao.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Transactional
    public Product getById(long id) {
        return productDao.getById(id);
    }

    @Transactional
    public void update(Product product) {
        productDao.update(product);
    }

    @Transactional
    public void delete(Product product) {
        productDao.delete(product);
    }
}
