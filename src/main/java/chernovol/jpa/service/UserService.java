package chernovol.jpa.service;

import chernovol.jpa.dao.UserDao;
import chernovol.jpa.dmo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional(readOnly = true)
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<User> userList() {
        return userDao.allUsers();
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }
}
