package com.temzu.masterservice.service;

import com.temzu.masterservice.model.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.util.Date;
import javax.crypto.SecretKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TokenServiceTest extends ServiceTestBase {

  @BeforeEach
  void setUp() {
    super.setUp();
  }

  @Test
  void generateTokenWithExpirationTime() {
    Instant start = Instant.now();
    Instant expirationTime = start.plusSeconds(360_000);
    Date expirationDate = Date.from(expirationTime);
    Account user = getTestAccount();

    String encode = Encoders.BASE64.encode("4e89hf30489h398gh394h978g8*&G*&G#R*((F*y789fy874f349fy98yv97gv97834g8734tg8347tg".getBytes());
    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(encode));
    String token =
        Jwts.builder()
            .claim("uid", user.getUid())
            .claim("role", user.getRoles())
            .signWith(secretKey, SIG.HS512)
            .expiration(expirationDate)
            .compact();

    Jws<Claims> claimsJws = Jwts.parser()
        .verifyWith(secretKey)
        .build()
        .parseSignedClaims(token);

  }
}