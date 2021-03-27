package com.example.n23.dao;

import com.example.n23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
