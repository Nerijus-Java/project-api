package lt.codeacademy.project.api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lt.codeacademy.project.api.entity.Role;
import lt.codeacademy.project.api.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final long tokenValidationTimeInMil;
    private final byte[] tokenKey;

    public JwtService(@Value("#{${security.jwt.validationTime-min} * 60000}") long tokenValidationTimeInMil,
                      @Value("${security.jwt.token-key}") byte[] tokenKey) {
        this.tokenValidationTimeInMil = tokenValidationTimeInMil;
        this.tokenKey = tokenKey;
    }

    public String createToken(User principal) {

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuer("project-api")
                .setAudience("project-ui")
                .setSubject(principal.getUsername())
                .setExpiration(new Date(new Date().getTime() + tokenValidationTimeInMil))
                .setIssuedAt(new Date())
                .claim("roles", principal.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet()))
                .signWith(Keys.hmacShaKeyFor(tokenKey), SignatureAlgorithm.HS512)
                .compact();
    }
}
