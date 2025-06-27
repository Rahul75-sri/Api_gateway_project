package com.Rahul.user.service.UserService1.utils;

import java.util.regex.Pattern;

public class UUIDValidator {
    private static final Pattern UUID_PATTERN =
            Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    public static boolean isValidUUID(String str) {
        return str != null && UUID_PATTERN.matcher(str).matches();
    }
}