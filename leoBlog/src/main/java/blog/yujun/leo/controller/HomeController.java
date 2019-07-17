package blog.yujun.leo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping(value="/services")
	public String services() {
		return "services";
	}
	
	@GetMapping(value="/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping(value="/blog")
	public String blog() {
		return "blog";
	}

}
