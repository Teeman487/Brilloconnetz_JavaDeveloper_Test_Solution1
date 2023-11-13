package net.akinadeadebusoye.A.userInputValidation;

import java.util.Scanner;
public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// Java application can read input from the console using classes like Scanner or by
        // reading from Standard input stream(System.in). This allows users to providdetext based input to java program

        // Collects User inputs
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Date of Birth (yyyy-MM-dd): ");
        String dob = scanner.nextLine();

        // Validates all User input and display results
        boolean validationPassed = UserValidation.validateUsers(username, email, password, dob);

        if (validationPassed) {
            System.out.println("True: All validations passed.");
        }
        else {
            System.out.println("Validations failed. Please follow the instruction below:");

            if (!UserValidation.isUsernameValid(username)) {
                System.out.println("Username: not empty and should be at least 4 characters.");
            }

            if (!UserValidation.isEmailValid(email)) {
                System.out.println("Email: not empty and should be a valid email address.");
            }

            if (!UserValidation.isPasswordValid(password)) {
                System.out.println("Password: not empty, should be a strong password " +
                        "(at least 8 characters, 1 uppercase, 1 special character, 1 number).");
            }

            if (!UserValidation.isDateOfBirthValid(dob)) {
                System.out.println("Date of Birth: not empty and should be 16 years or greater.");
            }
        }
    }
}
