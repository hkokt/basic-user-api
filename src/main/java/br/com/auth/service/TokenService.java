package br.com.auth.service;

import br.com.auth.domain.service.ITokenService;
import br.com.auth.domain.entity.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService implements ITokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private final String issuer = "user-controller";

    @Override
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    @Override
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT
                    .require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e) {
            return "";
        }

    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00"));
    }

}
