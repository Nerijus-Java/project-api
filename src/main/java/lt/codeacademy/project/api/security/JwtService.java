package lt.codeacademy.project.api.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lt.codeacademy.project.api.entity.Role;
import lt.codeacademy.project.api.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
                .setHeaderParam("typ", "JWT")
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

    public Authentication parseToken(String jwt) {
        Claims parsedJwtBody;

        try {
            parsedJwtBody = Jwts.parserBuilder()
                    .setSigningKey(tokenKey)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            return null;
        }

        String username = parsedJwtBody.getSubject();

        List<GrantedAuthority> roles = ((List<String>) parsedJwtBody.get("roles")).stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(username, null, roles);

    }
}
