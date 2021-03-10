package com.kuaipao.user.config;

import org.springframework.security.crypto.password.PasswordEncoder;


public class MyEncoder implements PasswordEncoder {
    private static final PasswordEncoder INSTANCE = new MyEncoder();

    private MyEncoder() {
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }
}
