package de.bsi.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserApiController {
	
	@GetMapping("/admin")
	public String accessOnlyForRoleAdmin(@AuthenticationPrincipal Jwt user) {
		return "User is authenticated with checked authority.";
	}
	
	@GetMapping("/user")
	public String accessOnlyForAuthenticatedUsers(@AuthenticationPrincipal Jwt user) {
		return "User is authenticated as: " + user.getClaimAsString("preferred_username");
	}
	
	@GetMapping("/anyone")
	public String accessForAnyone() {
		return "User can be anonymous";
	}

}
