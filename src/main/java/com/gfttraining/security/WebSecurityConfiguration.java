package com.gfttraining.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {		

		
		http
			.authorizeHttpRequests((request)-> request. antMatchers(HttpMethod.GET).permitAll()
														.antMatchers(HttpMethod.POST, "/**").hasRole("USER")
														.antMatchers(HttpMethod.PUT, "/**").hasRole("USER")
														.antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN"))
														//.anyRequest().authenticated())
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf().disable()
            .httpBasic(Customizer.withDefaults());										
		
		return http.build();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		UserDetails regularUser = User.withDefaultPasswordEncoder()
				.username("user")
				.password("user")
				.roles("USER")
				.build();
		
		UserDetails adminUser = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(regularUser,adminUser);
		
	}	

}
