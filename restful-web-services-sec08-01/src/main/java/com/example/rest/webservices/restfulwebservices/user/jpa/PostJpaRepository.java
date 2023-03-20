package com.example.rest.webservices.restfulwebservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservices.restfulwebservices.user.domain.Post;

public interface PostJpaRepository extends JpaRepository<Post, Integer>{

}
