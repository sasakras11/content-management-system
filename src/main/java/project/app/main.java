package project.app;

import project.app.model.user.User;
import project.app.service.UserService.UserService;
import project.app.service.UserService.UserServiceImpl;

public class main {


    public static void main(String[] args) {

         UserService userService = new UserServiceImpl();
         User user = new User();
         user.setName("alex");
         user.setPass("Olexander01");
         userService.add(user);


    }
}