package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;


	public  List<UserEntity> userAll() {
		List<UserEntity> userEntity = orderRepository.userAll();
		return userEntity;

	}

}
