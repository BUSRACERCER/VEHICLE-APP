package com.works.configs;

import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfigVehicle extends WebSecurityConfigurerAdapter {

    final PasswordEncoder passwordEncoder;
    final CustomerService customerService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((customerService)).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http
               . httpBasic()
                       .and()
               .authorizeHttpRequests()
                       .antMatchers("/vehicle/list").hasAnyRole("companyAdmin","standart")
                       .antMatchers("/vehicle/save").hasRole("companyAdmin")
                       .antMatchers("/vehicle/delete").hasRole("companyAdmin")
                       .antMatchers("/vehicle/update").hasRole("companyAdmin")
                       .and()
        .csrf().disable().formLogin().disable();

    }

}
