package net.akinadeadebusoye.C.userJWT;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    // Username Validation (not empty, min 4 characters)
    public static boolean isUsernameValid(String username) {
        return !username.isEmpty() && username.length() >= 4;
    }

    // Validate the email address (not empty, valid email address)
    public static boolean isEmailValid(String email) {
        if (email.isEmpty()) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //  Password (Strong) Validation
    public static boolean isPasswordValid(String password) {
        if (password.isEmpty()) return false;
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#\\$%^&*])(?=.*[0-9]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Date of Birth validation (not empty, should be 16 years or greater)
    public static boolean isDateOfBirthValid(String dobStr) {
        if (dobStr.isEmpty()) return false;
        try {
            LocalDate dob = LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate sixteenYearsAgo = LocalDate.now().minusYears(16);
            return dob.isBefore(sixteenYearsAgo);
        } catch (Exception e) {
            return false;
        }
    }
}
