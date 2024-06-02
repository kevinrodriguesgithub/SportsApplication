//package com.kevin.esd.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class LoginConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManagerBuilder auth, BCryptPasswordEncoder passwordEncoder) throws Exception {
//        // Configure AuthenticationManagerBuilder directly in filterChain method
//        auth.inMemoryAuthentication()
//            .withUser("admin")
//            .password(passwordEncoder.encode("adminpass"))
//            .authorities("ROLE_ADMIN");
//
//        http
//            .authorizeRequests(authz -> authz
//                .requestMatchers("/sportsApp/match/new", "/sportsApp/deleteMatch/*").hasRole("ADMIN")
//                .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/login")
//                .permitAll()
//            )
//            .logout(logout -> logout.permitAll());
//
//        return http.build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
