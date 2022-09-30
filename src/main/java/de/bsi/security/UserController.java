package de.bsi.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@GetMapping("/**")
	public ModelAndView defaultPage(@AuthenticationPrincipal OidcUser principal) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("user", principal);
		return mav;
	}
	
}