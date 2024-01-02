package com.temzu.masterservice.service.impl;

import com.temzu.masterservice.config.CustomUserDetails;
import com.temzu.masterservice.service.RedisService;
import com.temzu.masterservice.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
@PropertySource("classpath:secret.properties")
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

  private static final String ACCOUNT_UID_CLAIM = "uid";
  private static final String ACCOUNT_ROLE_CLAIM = "role";

  private final RedisService<String> redisService;

  @Value("${jwt.secret}")
  private String JWT_SECRET;

  @Override
  public String generateTokenWithExpirationTime(CustomUserDetails user, Integer ttl) {
    Instant start = Instant.now();
    Instant expirationTime = start.plusSeconds(ttl);
    Date expirationDate = Date.from(expirationTime);

    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET));
    String token =
        Jwts.builder()
            .claim(ACCOUNT_UID_CLAIM, user.getUid())
            .claim(ACCOUNT_ROLE_CLAIM, user.getRoles())
            .signWith(secretKey, SIG.HS512)
            .expiration(expirationDate)
            .compact();

    Jws<Claims> claimsJws = Jwts.parser()
        .verifyWith(secretKey)
        .build()
        .parseSignedClaims(token);

    redisService.setWithExpirationTime(
        "token_".concat(user.getUsername()),
        token,
        Duration.between(start, expirationTime)
    );
    return token;
  }
}
