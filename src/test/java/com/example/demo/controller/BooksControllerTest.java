package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/testApplicationContext.xml")
class BooksControllerTest {
	@Autowired
	BooksController target;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }
	
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
