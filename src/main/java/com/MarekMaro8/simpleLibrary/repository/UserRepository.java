package com.MarekMaro8.simpleLibrary.repository;
import com.MarekMaro8.simpleLibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}



