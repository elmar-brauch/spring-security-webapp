package de.bsi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/index").permitAll()
				.antMatchers("/**").hasRole("USER").and().formLogin()
				.and().logout().logoutSuccessUrl("/index");
	}
	
	@Bean
	public UserDetailsService users(@Autowired PasswordEncoder pwEnc) {
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
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}