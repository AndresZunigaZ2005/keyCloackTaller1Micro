package co.edu.uniquindio.micro.keycloacktaller1micro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()  // libre
                        .anyRequest().authenticated()              // todo lo demás requiere token
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt()); // valida JWT emitido por Keycloak

        return http.build();
    }
}
