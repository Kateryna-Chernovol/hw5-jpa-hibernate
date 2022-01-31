package chernovol.jpa.service;

import chernovol.jpa.dao.CartDao;
import chernovol.jpa.dmo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CartService {

    @Autowired
    private CartDao cartDao;

    @Transactional
    public void create(Cart cart) {
        cartDao.save(cart);
    }

    @Transactional(readOnly = true)
    public List<Cart> getAll() {
        return cartDao.getAll();
    }

    @Transactional
    public void update(Cart cart) {
        cartDao.update(cart);
    }

    @Transactional
    public void delete(Cart cart) {
        cartDao.delete(cart);
    }
}
