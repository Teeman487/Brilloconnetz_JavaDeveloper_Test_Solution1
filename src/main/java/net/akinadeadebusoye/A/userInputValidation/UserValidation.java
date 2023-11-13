package net.akinadeadebusoye.A.userInputValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    // Username Validation (not empty, min 4 characters)
    public static boolean isUsernameValid(String username)
    {
        return !username.isEmpty() && (username.length() >= 4);
    }

    // Validate the email address (not empty, valid email address)
    public static boolean isEmailValid(String email)
    {
        if (email.isEmpty()) return false;
        else
        {
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Regex is a set of rules or patterns that we use to check if a given text looks like a valid email address.
            Pattern pattern = Pattern.compile(emailRegex); // Pattern & Matcher classes are part of the 'java.util.regex' package and are used for working with regular expression
            // Pattern class is used to compile the regular expression pattern for email validation, and the Matcher class is used to match the input email address against the pattern
            Matcher matcher = pattern.matcher(email);  // 'email' follows a validated email pattern
            return matcher.matches();  // returning the input email address against the regular expression pattern for email validation
        }
    }

    // Password(Strong) validation
    public static boolean isPasswordValid(String password) {
        if (password.isEmpty()) return false;
            // Strong password regex: at least 8 characters, 1 uppercase, 1 special character, 1 number
        else
        {
            String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#\\$%^&*])(?=.*[0-9]).{8,}$";
            Pattern pattern = Pattern.compile(passwordRegex);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches(); // returning the input password address against the regular expression pattern for password validation
        }
    }

    // Date of Birth validation (not empty, should be 16 years or greater)
    public static boolean isDateOfBirthValid(String dob) {
        if (dob.isEmpty()) return false;
        else {

            // Date of Birth Exception for the wrong Input
            try {
                // User dateOfBirth follows pattern "yyyy-MM-dd"
                LocalDate userDob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // Year_2023 - 16(Years ago) = Y2007 ; Y2007 is 16 years ago
                LocalDate sixteenYearsAgo = LocalDate.now().minusYears(16);

                //  Checks if the User's dateOfBirth is at least 16 years of age?
                return userDob.isBefore(sixteenYearsAgo); // is b4 2008
            } catch (Exception e) {
                return false;
            }
        }
    }

    // Validate all User inputs
    // If all these conditions are meant, refer to 'validationPassed' in UserInput Class
    public static boolean validateUsers(String username, String email, String password, String dob)
    {
        return isUsernameValid(username) && isEmailValid(email) && isPasswordValid(password) && isDateOfBirthValid(dob);
    }
}
