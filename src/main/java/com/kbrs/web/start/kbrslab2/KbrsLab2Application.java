package com.kbrs.web.start.kbrslab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class KbrsLab2Application {

    @Bean
    public PasswordEncoder passwordEncoder(){
        //
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(KbrsLab2Application.class, args);
    }

}
