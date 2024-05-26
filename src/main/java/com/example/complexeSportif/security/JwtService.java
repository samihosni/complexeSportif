package com.example.complexeSportif.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "POIAMI7OBJFDT8268805TUC02J4FE2FC8TKQ6Q4QD08Z1CYRQU5AASJYKVFZJVQ6RVZP531TXIPWJ5VMEY5YYOLDLIKE0MS9GH8L8RJY7TK1TT118RYMA7VMSRRMDKSR7XLC9IR2H9R3TSAX23JLBVIYGS563U9B4ZGV9CJTSMDEW4E7TKXF11KSEILBQ86JR0XHI1A3MBHT2JYR8KL0Y7Z57VGBPRHF3OR1W3DUO9ZQPCVDKOV4BC5HALM8ETJY";
    // Interpreter le username du token
    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
       final Claims claims =extractAllClaims(token);
       return claimsResolver.apply(claims);
    }
    // generate token from userdetails (username)
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    // generation du token

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails

    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // method to valdiate token
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username= extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    //checking if token is expired or not
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    // extract expiration date from the token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
