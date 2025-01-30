package org.factoriaf5.animal_reserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/h2-console/**").permitAll()  // Allow H2 Console
                    .requestMatchers("/admin/**").hasRole("ADMIN") // Protect admin routes
                    .anyRequest().authenticated()  // Require login for other routes
            )
            .formLogin(login -> login
                .loginPage("/login")  // Use default login
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        // Enable H2 Console access
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin123")
            .roles("ADMIN")
            .build();

        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("user123")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
