package project.app.service.UserService;

import project.app.model.post.post;
import project.app.model.user.User;

import java.util.List;

public interface UserService {
    List<User> users_list();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User createUser(String name,String pass);
    boolean validation(User user);
    User getById(int id);
    User getByName(String name);
    boolean isNameFree(String name);

}
