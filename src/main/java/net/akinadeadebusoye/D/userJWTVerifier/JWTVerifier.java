package net.akinadeadebusoye.D.userJWTVerifier;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SecurityException;
import net.akinadeadebusoye.C.userJWT.JWTGenerator;


public class JWTVerifier {
    // Verify a signed JWT
    public static String verifyJWT(String token) {
        try {
            Claims claims = Jwts.parser()
                    // generateJWT fetched from Package C.userJWT.JWTGenerator.generateJWT
                    .setSigningKey(JWTGenerator.secretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return "Verification pass";
            // Add additional verification logic here if needed

        } catch (ExpiredJwtException e) {
            // JWT has expired
            return "Verification fails: JWT expired";

        } catch (MalformedJwtException | SignatureException e) {
            // JWT is malformed or signature verification failed
            return "Verification fails: Invalid JWT";

        } catch (Exception e) {
            // Other exceptions
            return "Verification fails: " + e.getMessage();
        }
    }
}

