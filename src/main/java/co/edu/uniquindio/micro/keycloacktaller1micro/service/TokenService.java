package co.edu.uniquindio.micro.keycloacktaller1micro.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String getEmail(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        return jwt.getClaim("email"); // o cualquier otro claim
    }
}
