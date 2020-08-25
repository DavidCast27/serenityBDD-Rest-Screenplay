package com.davidcast27.exceptions;

public class UserAssertionErros extends AssertionError {

    public static final String NUMBER_USERS_RETURNED_DIFERENTS = "number of users expected is different from those returned";
    public static final String USER_DETAIL_NOT_CORRECT = "user details  information is not correct";
    public static final String STATUS_CODE_NOT_CORRECT = "Status code  is not correct";
    public static final String USER_NOT_SAVED = "User not saved correctly";



    public UserAssertionErros(String message) {
        super(message);
    }

    public UserAssertionErros(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }

}
