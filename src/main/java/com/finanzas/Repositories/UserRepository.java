package com.finanzas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
