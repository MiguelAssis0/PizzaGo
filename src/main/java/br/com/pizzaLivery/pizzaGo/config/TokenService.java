package br.com.pizzaLivery.pizzaGo.config;

import br.com.pizzaLivery.pizzaGo.user.Users;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private static final String SECRET_KEY = "sua-chave-secreta-aqui";
    private static final String ISSUER = "PizzaGo";

    public String generateToken(Users user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            LocalDateTime expirationDate = LocalDateTime.now().plusHours(2);

            String token = JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getUsername())
                    .withExpiresAt(expirationDate.toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);

            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao criar token", e);
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {
            throw new RuntimeException("Token inválido ou expirado: " + e.getMessage(), e);
        }
    }
}
