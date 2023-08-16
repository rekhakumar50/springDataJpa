package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
