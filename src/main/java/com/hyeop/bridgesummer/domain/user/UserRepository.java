package com.hyeop.bridgesummer.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     public Optional<User> findById(String id);
     public Optional<User> findByNickname(String nickname);
     public Optional<User> findByEmail(String email);
}
