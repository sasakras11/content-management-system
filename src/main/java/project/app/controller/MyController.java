package project.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import project.app.model.post.post;
import project.app.model.user.User;
import project.app.service.postService.*;
import project.app.service.UserService.*;

@Controller
public class MyController {

    private UserService userService = new UserServiceImpl();
    private postService postService = new postServiceImpl();

@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
@Autowired
    public void setPostService(project.app.service.postService.postService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView start() {
        return new ModelAndView("registration_login/start");
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
          public ModelAndView  loginPage(){
return new ModelAndView("registration_login/confirm");
          }


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView  registerPage(){

                      ModelAndView m = new ModelAndView();
                      m.setViewName("registration_login/register");


                      return m;

    }

    @RequestMapping(value = "/registration",method =  RequestMethod.POST)              //ТУТ МИ СТВОРЮЄМО НОВОГО ЮЗЕРА І ДОБАВЛЯЄМО ЙОГО В БД +
                                                                                // ВИВОДИМО НА СТОРІНКУ ПОСТИ
            public ModelAndView Registration(@RequestParam String name,@RequestParam String pass){


        ModelAndView m = new ModelAndView("list");
        if(userService.isNameFree(name)){
     userService.add(userService.createUser(name,pass));
     m.addObject("user", userService.getByName(name));                                         //adding object name,by which i will checking
                                                                                    // and editing user and allow him to edit his posts
     m.addObject("list", postService.postList());
     return m;}
        else{
            m.setViewName("registration_login/register");
            m.addObject("isNameFree","false");
            return m;
        }
    }

    @RequestMapping(value = "/confirm",method =  RequestMethod.GET)
   public ModelAndView Logging(@RequestParam String name,@RequestParam String pass){
                                                                                           //ТУТ МИ ЛОГІНИМО ЮЗЕРА І
                                                                                        //ВИВОДИМО НА СТОРІНКУ ПОСТИ
        ModelAndView mv = new ModelAndView();
        if(userService.validation(userService.createUser(name,pass))){
            mv.setViewName("list");
        }
        else {
            mv.setViewName("registration_login/confirm");
            return mv;
        }
        mv.addObject("user", userService.getByName(name));                        //adding object name,by which i will checking
                                                                             // and editing user and allow him to edit his posts
        mv.addObject("list", postService.postList());
 return  mv;
    }
    @RequestMapping(value = "/settings/{user.id}",method = RequestMethod.GET)
      public ModelAndView EditPage(@PathVariable("user.id") int  id){

          ModelAndView mv = new ModelAndView();
          mv.setViewName("settings");
mv.addObject("user", userService.getById(id));

return mv;
    }


    @RequestMapping(value = "/settings",method = RequestMethod.POST)        //here we edit user trying by transfer hom like object,was tr
    public ModelAndView Edit(@ModelAttribute User user) {               //by name pass and id but now by object
        ModelAndView m = new ModelAndView();
        if (userService.isNameFree(user.getName())) {
            userService.edit(user);
            m.addObject("list", postService.postList());
            m.addObject("user", user);
            m.setViewName("list");

        } else {
            m.addObject("isNameFree","false");
            m.addObject("user", userService.getById(user.getId()));
            m.setViewName("settings");
        }

        return m;
    }
    @RequestMapping(value = "/addPost/{id}")
    public ModelAndView addPost(@PathVariable("id")int id){

    ModelAndView mv = new ModelAndView();
    mv.setViewName("addPost");
    mv.addObject("user",userService.getById(id));
    return mv;
    }

    @RequestMapping(value = "/addPost",method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute post post,@RequestParam int id_user ){
    ModelAndView mv = new ModelAndView();


    post.setUser(userService.getById(id_user));
        postService.addPost(post);

      mv.addObject("user",post.getUser());
      mv.addObject("list",postService.postList());
        mv.setViewName("list");
        return mv;

    }


}
