package com.tommybalestreri.hellospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/users/addNew").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("user")
////                        .password("password")
////                        .roles("USER")
////                        .build();
//            List<UserDetails> users = new ArrayList<>();
//            {
//                users.add(User.withDefaultPasswordEncoder().
////                        users.add(User.NoOpPasswordEncoder.getInstance()
////                        users.add(User.passwordEncoder().
//                username("tommy").
//
//                password("password").
//
//                roles("USER").
//
//                build());
//            }
//        return new InMemoryUserDetailsManager(users);
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }
}