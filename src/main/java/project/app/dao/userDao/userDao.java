package project.app.dao.userDao;

import org.springframework.beans.factory.annotation.Autowired;
import project.app.model.post.post;
import project.app.model.user.User;

import java.util.List;

public  interface userDao {
    List<User> users_list();
    void add(User user);
    void delete(User user);
    void edit(User user);
    boolean validation(String name,String pass);
    User getById(int id);
    User getByName(String name);
     boolean IsNameFree(String name);
}
