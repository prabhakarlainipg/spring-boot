package com.example.learning.repository;

import com.example.learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA:
//1. Scans for repository interfaces.
//2. Recognizes UserRepository because it extends JpaRepository.
//3. Creates a proxy implementing that interface.
//4. Registers it as a Spring bean, ready for constructor injection.
public interface UserRepository extends JpaRepository<User, Long> {
}
