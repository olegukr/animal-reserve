package org.factoriaf5.animal_reserve.config;

import org.factoriaf5.animal_reserve.security.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Value("${api-endpoint}")
    String endpoint;

    private final JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfiguration(JpaUserDetailsService userDetailsService) {
            this.jpaUserDetailsService = userDetailsService;
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .cors(withDefaults())
    //         .csrf(csrf -> csrf.disable())
    //         .formLogin(form -> form.disable())
    //         .logout(out -> out
    //             .logoutUrl(endpoint + "/logout")
    //             .invalidateHttpSession(true)
    //             .deleteCookies("JSESSIONID"))
    //         .authorizeHttpRequests(auth -> auth
    //             .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
    //             .permitAll()
    //             .requestMatchers(endpoint + "/login").hasAnyRole("USER", "ADMIN")
    //             .requestMatchers(endpoint).permitAll()
    //             .requestMatchers(endpoint + "/animals/public/**").permitAll() // ✅ Allow public access
    //              .requestMatchers(endpoint + "/animals/admin/**").hasRole("ADMIN") // Admin-only routes
    //              .anyRequest().authenticated() // All other routes require authentication
    //         )
    //         .userDetailsService(jpaUserDetailsService)
    //         .httpBasic(withDefaults())
    //         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

    //         http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

    //     return http.build();
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .logout(out -> out
                .logoutUrl(endpoint + "/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID"))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
                .permitAll()
                .requestMatchers(endpoint + "/login").hasAnyRole("USER", "ADMIN")
                .requestMatchers(endpoint + "/animals/public/**").permitAll() // Allow public access
                .requestMatchers(endpoint + "/animals/admin/**").hasRole("ADMIN") // Admin-only routes
                .anyRequest().authenticated() // All other routes require authentication
            )
            .userDetailsService(jpaUserDetailsService)
            .httpBasic(withDefaults())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

            http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));
    
        return http.build();
    }


    // @Bean
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    //     return authConfig.getAuthenticationManager();
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
