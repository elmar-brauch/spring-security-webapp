package de.bsi.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
	
	@GetMapping("/api/admin")
	public String accessOnlyForRoleAdmin() {
		return "User is authenticated & authorized by role ADMIN";
	}
	
	@GetMapping("/api/user")
	public String accessOnlyForAuthenticatedUsers() {
		return "User is authenticated";
	}
	
	@GetMapping("/api/anyone")
	public String accessForAnyone() {
		return "User can be anonymous";
	}

}
