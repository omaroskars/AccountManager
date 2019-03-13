package com.account.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class ManagerApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.csrf().disable();
	// }
}
