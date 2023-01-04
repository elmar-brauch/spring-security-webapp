package de.bsi.security;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {
	
	// TODO 1. Create SecurityFilterChain Bean from HttpSecurity.
	// TODO 2. Give access to anyone
	// TODO 3. Give access to /admin URL only to logged in users
	// TODO 4. Add logout
	// TODO 5. UserDetailsService for more users
	
	
	
	
	
	
	
	
	
	
//	@Bean
//	UserDetailsService users(@Autowired PasswordEncoder pwEnc) {
//	    UserDetails user = User.builder()
//	        .username("user")
//	        .password(pwEnc.encode("top"))
//	        .roles("USER")
//	        .build();
//	    UserDetails admin = User.builder()
//	        .username("admin")
//	        .password(pwEnc.encode("secret"))
//	        .roles("USER", "ADMIN")
//	        .build();
//	    return new InMemoryUserDetailsManager(user, admin);
//	}
//	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
}