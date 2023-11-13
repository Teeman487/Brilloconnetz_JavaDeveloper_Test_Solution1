package net.akinadeadebusoye.E.userJWTVerifierTest;

import net.akinadeadebusoye.C.userJWT.JWTGenerator;
import net.akinadeadebusoye.D.userJWTVerifier.JWTVerifier;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static net.akinadeadebusoye.C.userJWT.JWTGenerator.generateJWT;
import static net.akinadeadebusoye.D.userJWTVerifier.JWTVerifier.verifyJWT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Write a JUnit Test case for D to check to test a valid and invalid token.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JWTVerifierTest {

    //JUnit Test case for D to check to test a valid
    @Test
    @Order(1)
    public void testValidJWT() {
        try {
            // Generate a valid JWT
            String validToken = JWTGenerator.generateJWT();
            // Verify the valid JWT
            String verificationResult = JWTVerifier.verifyJWT(validToken);

            // Assert that the verification result should be "verification pass"
            assertEquals("Verification pass", verificationResult);
        } catch (Exception e) {
            // Fail the test if an exception occurs during JWT generation or verification
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void testInvalidJWT() {
        // Generate an invalid JWT (e.g., tampered or expired token)
        String invalidToken = "invalid_token_here";

        // Verify the invalid JWT
        String verificationResult = verifyJWT(invalidToken);

        // Assert that the verification result should be "verification fails"
        assertEquals("Verification fails: Invalid JWT", verificationResult);
    }
}
