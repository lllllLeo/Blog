//package blog.yujun.leo.controller;
//
//import blog.yujun.leo.dto.UserDTO;
//import blog.yujun.leo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class MainController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("yujun")
//    public @ResponseBody
//    UserDTO yujun() throws Exception {
//        return userService.getUserInfo();
//    }
//
//    @GetMapping("/")
//    public String index(Model model){
//        UserDTO user = new UserDTO();
//        user.setAge(27);
//        user.setName("유준");
//        model.addAttribute(user);
//        return "index";
//    }
//    @GetMapping("/about")
//    public String about(){
//        return "about";
//    }
//    @GetMapping("/post")
//    public String post(){
//        return "post";
//    }
//    @GetMapping("/contact")
//    public String contact(){
//        return "contact";
//    }
//
//
//}
