package br.com.pizzaLivery.pizzaGo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encryptPassword(String password){
        return encoder.encode(password);
    }
}
