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
                      m.addObject("user",new User());
                      m.setViewName("registration_login/register");


                      return m;

    }

    @RequestMapping(value = "/registration",method =  RequestMethod.POST)              //creating new user and adding to database
                                                                                //
            public ModelAndView Registration(@ModelAttribute User user){


        ModelAndView m = new ModelAndView("list");
        if(userService.isNameFree(user.getName())){
            userService.add(user);
     m.addObject("user", userService.getByName(user.getName()));                                         //adding object name,by which i will checking
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
                                                                                           //user login
                                                                                        //if name+pass right
        ModelAndView mv = new ModelAndView();
        if(userService.validation(name,pass)){
            mv.setViewName("list");
            mv.addObject("user", userService.getByName(name));

            mv.addObject("list", postService.postList());
        }
        else {
            mv.setViewName("registration_login/confirm");                               //else return login page
            return mv;
        }

 return  mv;
    }
    @RequestMapping(value = "/settings/{user.id}",method = RequestMethod.GET)
      public ModelAndView EditPage(@PathVariable("user.id") int  id){

          ModelAndView mv = new ModelAndView();                                        //catching settings request and giving settings page
          mv.setViewName("settings");
mv.addObject("user", userService.getById(id));

return mv;
    }


    @RequestMapping(value = "/settings",method = RequestMethod.POST)        //editing user
    public ModelAndView Edit(@ModelAttribute User user) {               //if name is free,editing name and pass in database and return list.jsp
        ModelAndView m = new ModelAndView();                                 //else return same page and allow him to make another name
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
    @RequestMapping(value = "/addPost/{id}")                   //catching requests and returning postAdd page
    public ModelAndView addPost(@PathVariable("id")int id){

    ModelAndView mv = new ModelAndView();
    mv.setViewName("addPost");
    mv.addObject("user",userService.getById(id));
    return mv;
    }

    @RequestMapping(value = "/addPost",method = RequestMethod.POST)              //confirm post and return list.jsp
    public ModelAndView addPost(@ModelAttribute post post,@RequestParam int id_user ){
    ModelAndView mv = new ModelAndView();


    post.setUser(userService.getById(id_user));
        postService.addPost(post);

      mv.addObject("user",post.getUser());
      mv.addObject("list",postService.postList());
        mv.setViewName("list");
        return mv;

    }

    @RequestMapping(value = "/editPost/{id}")
    public ModelAndView editPost(@PathVariable int id){
    ModelAndView mv = new ModelAndView();
    mv.addObject("post",postService.getById(id));
    mv.addObject("user",postService.getById(id).getUser());
    mv.setViewName("editPost");
    return mv;
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute post post,@PathVariable int id){
        ModelAndView mv = new ModelAndView();
        post.setUser(userService.getById(id));
        postService.editPost(post);
        mv.addObject("user",post.getUser());
        mv.addObject("list",postService.postList());
        mv.setViewName("list");
        return mv;
    }
    @RequestMapping(value = "/deletePost/{id}")
    public ModelAndView deletePost(@PathVariable int id){
    ModelAndView mv = new ModelAndView();
        mv.setViewName("list");
    mv.addObject("user",postService.getById(id).getUser());
        postService.deletePost(postService.getById(id));
        mv.addObject("list",postService.postList());


        return mv;

    }



}
