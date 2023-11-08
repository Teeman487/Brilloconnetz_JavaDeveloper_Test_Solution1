package net.akinadeadebusoye.B.userCompletableFutureValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    // Username Validation (not empty, min 4 characters)
    public static boolean isUsernameValid(String username)
    {
        return !username.isEmpty() && username.length() >= 4;
    }

    // Validate the email address (not empty, valid email address)
    public static boolean isEmailValid(String email)
    {
        if (email.isEmpty()) return false;
        else {
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);  // 'email' follows a validated email pattern
            return matcher.matches();
        }
    }

    // Password (Strong) Validation
    public static boolean isPasswordValid(String password)
    {
        if (password.isEmpty()) return false;
            // Strong password regex: at least 8 characters, 1 uppercase, 1 special character, 1 number
        else {
            String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#\\$%^&*])(?=.*[0-9]).{8,}$";
            Pattern pattern = Pattern.compile(passwordRegex);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }
    }

    // Date of Birth validation (not empty, should be 16 years or greater)
    public static boolean isDateOfBirthValid(String dob)
    {
        if (dob.isEmpty()) return false;
        else {
            // Date of Birth Exception for the wrong Input
            try {
                // User dateOfBirth follows pattern "yyyy-MM-dd"
                LocalDate userDob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // Y2023-16(Years ago) = Y2007 ; Y2007 is 16 years ago
                LocalDate sixteenYearsAgo = LocalDate.now().minusYears(16);

                //  Checks if the User's dateOfBirth is at least 16 years of age?
                return userDob.isBefore(sixteenYearsAgo);
            } catch (Exception e) {
                return false;
            }
        }
    }
}
