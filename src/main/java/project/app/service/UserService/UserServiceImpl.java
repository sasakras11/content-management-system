package project.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import project.app.dao.userDao.userDao;
import project.app.dao.userDao.UserDaoImpl;
import project.app.model.post.post;
import project.app.model.user.User;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private userDao userDao = new UserDaoImpl();
@Autowired
    public void setUserDao(userDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public List<User> users_list() {
        return userDao.users_list();
    }

    @Override
    @Transactional
    public void add(User user) {
           userDao.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
      userDao.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
            userDao.edit(user);
    }


    @Override
    @Transactional
    public boolean validation(String name,String pass) {
        return userDao.validation(name,pass);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }


    @Override
    @Transactional
    public boolean isNameFree(String name) {
        return userDao.IsNameFree(name);
    }
}
