package net.akinadeadebusoye.D.userJWTVerifier;

import net.akinadeadebusoye.C.userJWT.JWTGenerator;

import static net.akinadeadebusoye.D.userJWTVerifier.JWTVerifier.verifyJWT;

public class VerifyJWT {
    public static void main(String[] args) {

        //Generated JWT from Package C.userJWT.JWTGenerator.generateJWT
        String jwt = JWTGenerator.generateJWT();
        System.out.println("Generated JWT: " + jwt);

        String verificationResult = verifyJWT(jwt); // Verify Generated JWT
        System.out.println("Verification Result: " + verificationResult);
    }

}
