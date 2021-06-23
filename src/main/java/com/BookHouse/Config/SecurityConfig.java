package com.BookHouse.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().disable().cors().and().authorizeRequests().antMatchers("user/add").permitAll();
        http.csrf().disable().httpBasic().disable().cors().and().authorizeRequests().antMatchers("book/add").permitAll();
        http.csrf().disable().httpBasic().disable().cors().and().authorizeRequests().antMatchers("genre/add").permitAll();
    }
}
