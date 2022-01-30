package chernovol.jpa.service;

import chernovol.jpa.dao.CreditCardDao;
import chernovol.jpa.dmo.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreditCardService {
    @Autowired
    CreditCardDao creditCardDao;

    @Transactional
    public void add(CreditCard creditCard) {
        creditCardDao.save(creditCard);
    }

    @Transactional
    public void remove(CreditCard creditCard) {
        creditCardDao.delete(creditCard);
    }

    @Transactional(readOnly = true)
    public CreditCard getById(Long id) {
        return creditCardDao.getById(id);
    }
}
