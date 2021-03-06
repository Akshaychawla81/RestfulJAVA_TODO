package com.example.rest.webservices.Restwebservices;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SpringsecurityBasicAuth extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()	
			.authorizeRequests()	
			.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
					.anyRequest().authenticated()
					.and()
				
				//.formLogin().and()
				.httpBasic();
		
		 http.headers().frameOptions().disable();
	}
	
	 
	// @formatter:
}


