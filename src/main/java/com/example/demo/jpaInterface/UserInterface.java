package com.example.demo.jpaInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;


public interface UserInterface extends JpaRepository<UserEntity,Integer> {

}
