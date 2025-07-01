package com.olayinka.Validation;

import com.olayinka.Model.Users;

public class UserValidation {

    private static final int FIRSTNAME_MIN_LENGTH = 2;
    private static final int LASTNAME_MIN_LENGTH = 2;


    public static Users validateUser(Users user) {

        if (user.getFirstname() == null || user.getFirstname().length() < FIRSTNAME_MIN_LENGTH) {
            throw new IllegalArgumentException("firstname cannot be null or less than 2 in length");
        }
        String firstname = user.getFirstname();
        firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1).toLowerCase();
        user.setFirstname(firstname);

        if (user.getLastname() == null || user.getLastname().length() < LASTNAME_MIN_LENGTH) {
            throw new IllegalArgumentException("User name cannot be null or less than 2 in length");
        }
        String lastname = user.getFirstname();
        lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1).toLowerCase();
        user.setFirstname(firstname);

        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        String email = user.getEmail().toLowerCase();
        user.setEmail(email);

        return user;
    }
}