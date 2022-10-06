package com.kbrs.web.start.kbrslab2.controllers;

import com.kbrs.web.start.kbrslab2.models.User;
import com.kbrs.web.start.kbrslab2.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> users = usersRepository.findAll();
        model.addAttribute("users",users);
        return "users_page";
    }
}
