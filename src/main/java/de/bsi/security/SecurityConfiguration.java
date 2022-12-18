package de.bsi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.requestMatchers("/admin").hasRole("ADMIN")
			.anyRequest().permitAll()
		.and().formLogin()
		.and().logout().logoutSuccessUrl("/index");
		return http.build();
	}
	
	@Bean
	UserDetailsService users(@Autowired PasswordEncoder pwEnc) {
	    UserDetails user = User.builder()
	        .username("user")
	        .password(pwEnc.encode("top"))
	        .roles("USER")
	        .build();
	    UserDetails admin = User.builder()
	        .username("admin")
	        .password(pwEnc.encode("secret"))
	        .roles("USER", "ADMIN")
	        .build();
	    return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}