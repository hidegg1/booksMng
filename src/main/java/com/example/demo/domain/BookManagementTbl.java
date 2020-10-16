package com.example.demo.domain;

import lombok.Data;

/**
 * `book_management_tbl` entity
 * 
 * @author azuki
 *
 */
@Data
public class BookManagementTbl {

	/** ID */
	private Integer id;
	
	/** TITEL */
	private String title;
	
	/** AUTHOR */
	private String author;
	
	/** VERSIONNUMBER */
	private String versionnumber;
	
	/** ISBN */
	private String isbn;
	
	/** BOOKSCOUNT */
	private Integer bookscount;
	
	/** NOTE */
	private String note;
	
}
