package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.mapper.BookMngMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BooksControllerTest {
	@InjectMocks
	BooksController target;
	
	@Mock //mock化したいクラスに付与する
	BookMngMapper bookMngMapper;
	
	
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

	@Test
	public void testDoEdit() throws Exception{
		mockMvc.perform(post("/cdbooksmng/admin/doBooksChange").param("bookid", "1")
		.param("title", "ない").param("author", "な").param("versionNumber", "1")
		.param("isbn", "あ").param("booksCount", "3").param("stock", "6")
		.param("count", "1").param("plusOrMinus", "-1"))
		.andExpect(redirectedUrl("/cdbooksmng/admin/bookSearch"))
//		.andExpect(status().isOk())→リダイレクトの場合、status()は使えない
//		.andExpect(view().name("book_info_change.html")
		.andDo(log());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
