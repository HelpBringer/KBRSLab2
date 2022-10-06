package com.kbrs.web.start.kbrslab2.controllers;

import com.kbrs.web.start.kbrslab2.models.User;
import com.kbrs.web.start.kbrslab2.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final UsersRepository usersRepository;

    public SignUpController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp_page";
    }

    @PostMapping("/signUp")
    public String signUpUSer(User user){
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "redirect:/signUp";
    }
}
