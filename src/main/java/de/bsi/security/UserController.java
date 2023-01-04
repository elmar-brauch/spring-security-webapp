package de.bsi.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	// TODO 1. Add user as model to page: @AuthenticationPrincipal UserDetails user
	@GetMapping("/**")
	public ModelAndView defaultPage() {
		ModelAndView nextPage = new ModelAndView("index");
		// nextPage.addObject("user", user);
		return nextPage;
	}
	
	// TODO 2. Add admin as model to page
	
	
	
	
	
	
//	@GetMapping("/admin")
//	public ModelAndView rolePage(@AuthenticationPrincipal UserDetails user) {
//		ModelAndView nextPage = new ModelAndView("admin");
//		nextPage.addObject("user", user);
//		return nextPage;
//	}
}