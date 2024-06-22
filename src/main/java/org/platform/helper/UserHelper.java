package org.platform.helper;

import org.platform.exception.userExceptions.UserValidationException;
import org.platform.model.User;

/**
 * Class contain validation fields for home-page and trow UserValidationException;
 */
public class UserHelper {
    public static final String USER_NAME_REGEX = "[A-Z][a-z]+";
    public static final String USER_SURNAME_REGEX = "[A-Z][a-z]+";
    public static final String USER_EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static void validateFields(User user) {
        if (user.getName() != null && !user.getName().matches(USER_NAME_REGEX)) {
              throw new UserValidationException("Invalid user name");
        }
        if (user.getSurname() != null && !user.getSurname().matches(USER_SURNAME_REGEX)) {
            throw new UserValidationException("Invalid user surname");

        }
        if (!isValidYear(user.getYear())){
            throw new UserValidationException("Invalid user Year");

        }
        if (user.getEmail() != null && !user.getEmail().matches(USER_EMAIL_REGEX)) {
            throw new UserValidationException("Invalid user email");
        }
        if (user.getPassword() != null && !isValidPassword(user.getPassword())){
            throw new UserValidationException("Password must contain at least 1 upercase and 2 digits");

        }
    }

    /**
     * In this metod contain isValidYear method what return true when user year been in 1920 - 2020
     * and return false when that parameter not correspond;
     * @param year
     * @return
     */
    private static boolean isValidYear(int year){
        if (year > 1920 && year < 2020){
            return true;
        }
        return false;
    }

    /**
     *
     * @param password
     * @return
     */
    public static boolean isValidPassword(String password){
        if (password.length() < 8){
            return false;
        }
        int countOfDigit = 0;
        int countOfUppercase = 0;
        for (int i = 0; i <password.length() ; i++) {
            char element = password.charAt(i);
            if (Character.isDigit(element)){
                countOfDigit ++;
            } else if (Character.isUpperCase(element)) {
                countOfUppercase ++;
            }

        }
        return countOfDigit > 1 && countOfUppercase > 0;
    }
}
