package net.akinadeadebusoye.D.userJWTVerifier;

import io.jsonwebtoken.Claims;
import net.akinadeadebusoye.C.userJWT.JWTGenerator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static net.akinadeadebusoye.C.userJWT.JWTGenerator.generateJWT;
import static net.akinadeadebusoye.C.userJWT.UserValidator.*;
import static net.akinadeadebusoye.C.userJWT.UserValidator.isDateOfBirthValid;
import static net.akinadeadebusoye.D.userJWTVerifier.JWTVerifier.verifyJWT;

public class User {
    public static void main(String[] args) {
        // Create CompletableFuture tasks for each validation(Val)
        CompletableFuture<Boolean> usernameVal = CompletableFuture.supplyAsync(() -> isUsernameValid("Toheeb123"));
        CompletableFuture<Boolean> emailVal = CompletableFuture.supplyAsync(() -> isEmailValid("akinadetoheeb@gmail.com"));
        CompletableFuture<Boolean> passwordVal = CompletableFuture.supplyAsync(() -> isPasswordValid("P@ssw0rd"));
        CompletableFuture<Boolean> dobVal = CompletableFuture.supplyAsync(() -> isDateOfBirthValid("1995-09-24"));

        // Wait for all tasks to complete and get their results
        CompletableFuture<Void> allTask = CompletableFuture.allOf(usernameVal, emailVal, passwordVal, dobVal);

        //   to generate a signed JWT and return it.
        try
        {
            // Wait for all tasks(validation) to complete
            allTask.get();

            // Check if any of the validations failed
            if (usernameVal.join() && emailVal.join() && passwordVal.join()
                    && dobVal.join()) {
                String jwt = JWTGenerator.generateJWT();
                System.out.println("Generated JWT: " + jwt);

                String verificationResult = verifyJWT(jwt); // Verify Generated JWT
                System.out.println(verificationResult);  // return "Verification pass";
            }
            else {
                System.out.println("Verification fails.");
            }
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
    }
}




//