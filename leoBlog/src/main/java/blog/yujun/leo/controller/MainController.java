package blog.yujun.leo.controller;

import blog.yujun.leo.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model){
        User user = new User();
        user.setAge(27);
        user.setName("유준");
        model.addAttribute(user);
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/post")
    public String post(){
        return "post";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }


}
