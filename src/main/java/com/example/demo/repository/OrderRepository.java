package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpaInterface.UserInterface;

@Repository
public class OrderRepository {
	@Autowired
	UserInterface userInterface;

//	public UserEntity getOneName(int id) {
//		UserEntity userEntity = userInterface.getOne(id);
//		System.out.println("いけたか"+id);
//		return userEntity;
//
//	}
//	public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//
//
//	}

	public List<UserEntity> userAll() {
		List<UserEntity> userEntity = userInterface.findAll();
		return userEntity;
	}






}
