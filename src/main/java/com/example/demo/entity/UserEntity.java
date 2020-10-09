package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookManagementTbl")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//ƒJƒ‰ƒ€–¼‚à“Á‚É‘å•¶Žš‚Ì‹æ•Ê‚È‚µ
	private String title;

	private String author;
	
	private String versionnumber;
	
	private String isbn;
	
	private int bookscount;
	
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getVersionnumber() {
		return versionnumber;
	}

	public void setVersionnumber(String versionnumber) {
		this.versionnumber = versionnumber;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getBookscount() {
		return bookscount;
	}

	public void setBookscount(int bookscount) {
		this.bookscount = bookscount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
	