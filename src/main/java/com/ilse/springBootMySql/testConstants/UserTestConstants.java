package com.ilse.springBootMySql.testConstants;

import com.ilse.springBootMySql.domain.User;

public class UserTestConstants {

    private UserTestConstants() {}

    public static final String USER = "USER";

    public static User user() {
        return new User("name","email");
    }
}
