package com.example.rest.webservices.restfulwebservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservices.restfulwebservices.user.domain.User;

public interface UserJpaRepository extends JpaRepository<User, Integer>{

}
