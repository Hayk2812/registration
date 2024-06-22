package org.platform.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordEncoder {
    public static String encode(String password){
        return Base64.getUrlEncoder().encodeToString(password.getBytes());

    }
}
