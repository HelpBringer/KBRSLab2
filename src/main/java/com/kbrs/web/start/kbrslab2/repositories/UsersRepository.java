package com.kbrs.web.start.kbrslab2.repositories;
import com.kbrs.web.start.kbrslab2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Long>
{
    User findByEmail(String email);
}
