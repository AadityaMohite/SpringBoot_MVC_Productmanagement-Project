package com.Aadi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import com.Aadi.Service.CustomerDetails;


@Configuration
public class Config {

	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public CustomerDetails customerDetails;
	
	@Bean
	public DaoAuthenticationProvider authenticateuser() {
		
		    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customerDetails);
		    
		    provider.setPasswordEncoder(encoder());
		    
		    return provider;
		
	}
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable());
		
		
		http.httpBasic(Customizer.withDefaults());
		
		
		
		http.authorizeHttpRequests(auth->{
			
			auth.requestMatchers("/auth/saveuser").permitAll()
		    .anyRequest().authenticated();
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
	return http.build();
		
	
		
		
		
		
		
	}
	
	
	
	
	
}
