package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

class BooksControllerTest {
	MockMvc mockMvc;
	
	@Test
	public void testEdit() throws Exception {
		
		mockMvc.perform(get("/cdbooksmng/admin/booksChange").param("bookid", "1"))
		.andExpect(status().isOk())
		.andExpect(view().name("book_info_change.html"))
		.andDo(log());
}

//	@Test
//	void testGetonename() {
//		fail("‚Ü‚¾ŽÀ‘•‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ");
//	}
//
//	@Test
//	void testSearchDisplay() {
//		fail("‚Ü‚¾ŽÀ‘•‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ");
//	}
//
//
//
//	@Test
//	void testDoedit() {
//		fail("‚Ü‚¾ŽÀ‘•‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ");
//	}
	

}
