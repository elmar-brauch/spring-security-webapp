package de.bsi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration {
	
	@Value("${sam.logout_url}")
	private String logoutUrl;
	@Value("${sam.login_process_path}")
	private String loginProcessPath;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/secured").authenticated()
				.anyRequest().permitAll()
			.and().logout()
				// In this demo HTTP GET instead of POST is used for logout, 
				// so the logoutRequestMatcher is required to detect logout requests.
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessHandler((req, resp, auth) -> new DefaultRedirectStrategy().sendRedirect(req, resp, logoutUrl))
			.and().oauth2Login(c -> {
				c.loginProcessingUrl(loginProcessPath);
				c.loginPage("/oauth2/authorization/sam");
			});
		return http.build();
	}
	
}