// Concurrent Validation using Completable Future
package net.akinadeadebusoye.B.userCompletableFutureValidation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static net.akinadeadebusoye.B.userCompletableFutureValidation.UserValidator.*;

public class UserInputValidator {
    public static void main(String[] args) {
        // Create CompletableFuture tasks for each validation
        CompletableFuture<Boolean> usernameValidation = CompletableFuture.supplyAsync(() -> isUsernameValid("Toheeb123"));
        CompletableFuture<Boolean> emailValidation = CompletableFuture.supplyAsync(() -> isEmailValid("akinadetoheeb@gmail.com"));
        CompletableFuture<Boolean> passwordValidation = CompletableFuture.supplyAsync(() -> isPasswordValid("P@ssw0rd"));
        CompletableFuture<Boolean> dobValidation = CompletableFuture.supplyAsync(() -> isDateOfBirthValid("1995-09-24"));

        //supporting dependent functions and actions that trigger upon its completion
        // Wait for all tasks to complete and get their results
        CompletableFuture<Void> allTask = CompletableFuture.allOf(usernameValidation, emailValidation, passwordValidation, dobValidation);

        try {
            allTask.get(); // Wait for all tasks to complete

            // Check if any of the validations failed
            if (usernameValidation.join() && emailValidation.join() && passwordValidation.join() && dobValidation.join()) {
                System.out.println(" True: All validations passed.");
            } else {
                System.out.println("Validations failed. Please follow the instructions below:");
                if (!usernameValidation.join()) {
                    System.out.println("Username: not empty and should be at least 4 characters.");
                }
                if (!emailValidation.join()) {
                    System.out.println("Email: not empty and should be a valid email address.");
                }
                if (!passwordValidation.join()) {
                    System.out.println("Password: not empty, should be a strong password (at least 8 characters, 1 uppercase, 1 special character, 1 number).");
                }
                if (!dobValidation.join()) {
                    System.out.println("Date of Birth: not empty and should be 16 years or greater.");
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
