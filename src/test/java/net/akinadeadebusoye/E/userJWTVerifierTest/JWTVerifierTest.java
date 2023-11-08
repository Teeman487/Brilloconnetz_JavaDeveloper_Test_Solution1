package net.akinadeadebusoye.E.userJWTVerifierTest;

import net.akinadeadebusoye.C.userJWT.JWTGenerator;
import net.akinadeadebusoye.D.userJWTVerifier.JWTVerifier;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// Write a JUnit Test case for D to check to test a valid and invalid token.
public class JWTVerifierTest {

    @Test
    @Order(1)
    public void testValidJWT() {
        // Generate a valid JWT
        String validToken = JWTGenerator.generateJWT();

        // Verify the valid JWT
        String verificationResult = JWTVerifier.verifyJWT(validToken);

        // Assert that the verification result should be "verification pass"
        assertEquals("verification pass", verificationResult);
        System.out.println(verificationResult);
    }

    @Test
    @Order(2)
    public void testInvalidJWT() {
        // Generate an invalid JWT (e.g., tampered or expired token)
        String invalidToken = "invalid_token_here";

        // Verify the invalid JWT
        String verificationResult = JWTVerifier.verifyJWT(invalidToken);

        // Assert that the verification result should be "verification fails"
        assertEquals("verification fails", verificationResult);
        System.out.println(verificationResult);
    }
}
