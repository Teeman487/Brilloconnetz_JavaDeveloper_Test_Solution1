package net.akinadeadebusoye.D.userJWTVerifier;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import net.akinadeadebusoye.C.userJWT.JWTGenerator;

import static net.akinadeadebusoye.C.userJWT.JWTGenerator.secretKey;
public class JWTVerifier{

    // Verify a signed JWT
    public static String verifyJWT(String token) {
        try {
            Claims claims = Jwts.parser()
             // generateJWT fetched from Package C.userJWT.JWTGenerator.generateJWT
                    .setSigningKey(JWTGenerator.secretKey()) // secretKey generated from
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Add additional verification logic here if needed

            return "verification pass";
        } catch (Exception e) {
            return "verification fails";
        }
    }
}
