package de.bsi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// TODO 1. Give access to anyone
		// TODO 2. Give access to /admin URL only to logged in users
		// TODO 3. Add logout
		return http.build();
	}
	
	// TODO 4. UserDetailsService for more users
	
	
	
	
	
	
	
	
	
	
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