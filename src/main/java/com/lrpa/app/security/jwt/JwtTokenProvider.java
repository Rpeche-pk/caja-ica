package com.lrpa.app.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Payload;
import com.lrpa.app.exception.GenericException;
import com.lrpa.app.exception.JwtException;
import com.lrpa.app.persistance.entity.UserEntity;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author ROMULO
 * @package com.nocountry.cashier.configuration.jwt
 * @license Lrpa, zephyr cygnus
 * @since 13/10/2023
 */
@Service
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private String expiration;
    public static final String TOKEN_TYPE = "JWT";

    /**
     * Ciclo de vida del bean: se ejecuta ni bien se construya el bean , codifica nuestra clave para la firma de mi token
     */
    @PostConstruct
    public void encodeSecretKey() {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        log.info("Secret Key Generated: {}", secretKey);
    }

    /**
     * Dicha funcion genera el token con sus respectivos claims
     *
     * @param user UserEntity
     * @return String token
     */
    public String generateToken(UserEntity user) {

        Instant expirationToken = Instant.now().plusMillis(Long.parseLong(expiration));
        try {
            return JWT.create()
                    .withHeader(Map.of("type", TOKEN_TYPE))
                    .withIssuedAt(Instant.now())
                    .withExpiresAt(expirationToken)
                    .withIssuer("caja-ica")
                    .withClaim("name", user.getName())
                    .withClaim("role", user.getRole().name())
                    .withSubject(user.getUsername())
                    .sign(getSignatureKey());
        } catch (JWTCreationException exception) {
            log.warn("Invalid Creation Token");
            throw new GenericException("Invalid Creation Token");
        }
    }

    /**
     * Dicha funcion permite evaluar mediante que algoritmo se hizo, y comparando el issuer
     *
     * @param token String
     * @return boolean
     */
    public boolean verifyToken(String token) {
        if (Objects.isNull(token)) throw new JwtException("El token esta vació",HttpStatus.BAD_REQUEST);
        if (isExpirationToken(token)) return false;
        JWT.require(getSignatureKey())
                .withIssuer("caja-ica")
                .build()
                .verify(token);
        return true;
    }

    private boolean isExpirationToken(String token) {
        Instant extractExpiration = extractExpiration(token);
        return extractExpiration.isBefore(Instant.now());
    }

    private Instant extractExpiration(String token) {
        return extractAllClaims(token, Payload::getExpiresAtAsInstant);
    }

    /**
     * Toma el token se extrae los claims que lo conforman y se pasa un key para traer informacion especifica del token
     *
     * @param token String
     * @param key   sub|id|email|phone|role
     * @return String
     */
    public String getClaimForToken(String token, String key) {
        Map<String, Claim> claims = extractAllClaims(token, Payload::getClaims);
        return switch (key.toLowerCase()) {
            case "sub" -> claims.get("sub").asString();
            case "name" -> claims.get("name").asString();
            case "role" -> claims.get("role").asString();
            case "dni" -> claims.get("dni").asString();
            default -> "No existe dicho claim";
        };
    }

    /**
     * @param token           String
     * @param claimsTFunction Function
     * @param <T>             Generico
     * @return Generic
     */
    private <T> T extractAllClaims(String token, Function<DecodedJWT, T> claimsTFunction) {
        try {
            DecodedJWT decode = JWT.decode(token);
            return claimsTFunction.apply(decode);
        } catch (Exception ex) {
            throw new GenericException(ex.getLocalizedMessage());
        }
    }

    /**
     * @return Algoritmo para la firma del token, el token se conforma en 3 partes
     */
    private Algorithm getSignatureKey() {
        return Algorithm.HMAC256(secretKey);
    }

}
