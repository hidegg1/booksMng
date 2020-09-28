package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.BooksForm;
import com.example.demo.mapper.BookMngMapper;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;

@Controller
public class BooksController {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderService orderService;
	@Autowired
    BookMngMapper bookMngMapper;
//	書籍検索画面
	 @RequestMapping(value="/cdbooksmng/adimin/bookSearch")
public ModelAndView getonename() {
		ModelAndView mv =new ModelAndView();
		List<UserEntity> userEntity = bookMngMapper.slectAll();
		System.out.println();
		mv.addObject("userEntity",userEntity);
		mv.setViewName("test.html");
		return mv;
	}
	@RequestMapping(value="/user/bookSearch")
	ModelAndView searchDisplay() {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("bookSearch.html");
		return mv;
	}
//	書籍変更画面遷移
	 @RequestMapping(value="/cdbooksmng/admin/booksChange")
	 public ModelAndView edit(@RequestParam("bookid")int id){
//		int id = bookid;
		System.out.println(id);
		ModelAndView mv =new ModelAndView();
		mv.addObject("userEntity", bookMngMapper.findOne(id));
		mv.setViewName("book_info_change.html");
		return mv;
	}
//	①書籍更新実行
	@RequestMapping("/cdbooksmng/admin/doBooksChange")
//	@ResponseBody 
	 public String doEdit(BooksForm booksForm,int stock,int count,int plusOrMinus) {
		booksForm.setBooksCount(stock + count * plusOrMinus);
//		System.out.println("ok");
//		System.out.println(booksForm.getTitle());
		bookMngMapper.update(booksForm);
	    return "redirect:/cdbooksmng/adimin/bookSearch";
		
	}
	
	
}
