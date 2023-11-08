package net.akinadeadebusoye.C.userJWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

public class JWTGenerator {
    // Define a secret key for JWT signing

     static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

     public static Key secretKey()
     {
         return secretKey;
     }

    // Generate a signed JWT upon successful validation
    public static String generateJWT()
    {
        // Define the JWT claims
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600000); // Token expires in 1 hour

        return Jwts.builder()
                .setIssuedAt(now) // current Date
                .setExpiration(expirationDate) // expiring time
                .signWith(secretKey)
                .compact();
    }

    public static void main(String[] args) {
        System.out.println(secretKey); // javax.crypto.spec.SecretKeySpec@fa77d074
    }
}
