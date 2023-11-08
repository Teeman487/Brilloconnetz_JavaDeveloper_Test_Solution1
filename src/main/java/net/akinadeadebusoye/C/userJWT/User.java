package net.akinadeadebusoye.C.userJWT;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static net.akinadeadebusoye.C.userJWT.JWTGenerator.generateJWT;
import static net.akinadeadebusoye.C.userJWT.UserValidator.*;

public class User {

    public static void main(String[] args) {
        // Create CompletableFuture tasks for each validation(Val)
       CompletableFuture<Boolean> usernameVal = CompletableFuture.supplyAsync(() -> isUsernameValid("Toheeb123"));
       CompletableFuture<Boolean> emailVal = CompletableFuture.supplyAsync(() -> isEmailValid("akinadetoheeb@gmail.com"));
       CompletableFuture<Boolean> passwordVal = CompletableFuture.supplyAsync(() -> isPasswordValid("P@ssw0rd"));
       CompletableFuture<Boolean> dobVal = CompletableFuture.supplyAsync(() -> isDateOfBirthValid("1995-09-24"));

        // Wait for all tasks to complete and get their results
        CompletableFuture<Void> allOf = CompletableFuture.allOf(usernameVal, emailVal, passwordVal, dobVal);
//method
//   to generate a signed JWT and return it.
        try
        {
          // Wait for all tasks to complete
            allOf.get();

            // Check if any of the validations failed
            if (usernameVal.join() && emailVal.join() && passwordVal.join()
                    && dobVal.join()) {
                String jwt = generateJWT();
                System.out.println("JWT generation successful.");
                System.out.println("Generated JWT: " + jwt);
            }
            else {
                System.out.println("Validations failed. JWT not generated.");
            }
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
    }
}
/*public class VerifyJWT {
    public static void main(String[] args) {
        String jwt = generateJWT();
        System.out.println("Generated JWT: " + jwt);

        String verificationResult = verifyJWT(jwt);
        System.out.println("Verification Result: " + verificationResult);
    }

}*/
