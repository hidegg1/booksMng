package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.BookManagementTbl;

@Mapper
public interface BookManagementTblRepository {
	
	@Select("SELECT * FROM book_management_tbl")
    public List<BookManagementTbl> findAll();

}
