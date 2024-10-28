package com.example.demo.Security;

import com.example.demo.models.Role;
import com.example.demo.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/home/projects/**").hasAuthority("1")
                        .requestMatchers("/home/timesheets/**").hasAnyAuthority("2")
                        .requestMatchers("/**").hasAnyAuthority("3")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}


