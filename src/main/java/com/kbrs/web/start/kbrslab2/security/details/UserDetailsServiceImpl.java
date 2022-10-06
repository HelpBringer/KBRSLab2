package com.kbrs.web.start.kbrslab2.security.details;

import com.kbrs.web.start.kbrslab2.models.User;
import com.kbrs.web.start.kbrslab2.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
       User user = usersRepository.findByEmail(email);
       if(user != null){
           return new UserDetailsImpl(user);
       }
       else {
           throw new UsernameNotFoundException("User not found");
       }
    }
}
