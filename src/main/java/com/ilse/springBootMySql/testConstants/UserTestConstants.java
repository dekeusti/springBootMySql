package com.ilse.springBootMySql.testConstants;

import com.ilse.springBootMySql.domain.user.User;

public class UserTestConstants {

    private UserTestConstants() {}

    public static final String USER = "USER";

    public static User user() {
        return new User("naam","email");
    }

    public static User userWithId() {
        return new User(1,"naam","email");
    }
}
