package com.evilcorp.Spring_Security.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PassEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        //место где должна происходить шифровка пароля
        return String.valueOf(rawPassword);
    }

    //Сравнение введённого пароля на странице и пароля в "базе данных"
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
