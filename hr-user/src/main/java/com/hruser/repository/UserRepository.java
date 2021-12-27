package com.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hruser.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
