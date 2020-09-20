package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.BooksForm;

@Mapper
public interface BookMngMapper {
	public List<UserEntity> slectAll();
//	@Param→複数の値がある場合、必要かも
	public void update(@Param("booksForm")BooksForm booksForm);
	
	public UserEntity findOne(int id);

//	  Item findOne(int id);

//	  void save(BookMng );
//
//	  void update(Item auth);
//
//	  void delete(Long id);


}
