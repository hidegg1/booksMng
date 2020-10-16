package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.BookManagementTbl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BookManagementTblRepository.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
public class BookManagementTblRepositoryTest {
	
	BookManagementTblRepository repository;

    @Test
    @Sql(statements = "INSERT INTO book_management_tbl (id, title, author, versionnumber, isbn, bookscount, note) VALUES (1, 'Java', '中村',  '第二版',  '444', '4', '9')")
    public void testFindAll() {
        // execute
        List<BookManagementTbl> bookManagement = repository.findAll();

        // assert
        assertThat(bookManagement)
                .hasSize(1)
                .extracting(BookManagementTbl::getTitle, BookManagementTbl::getAuthor, BookManagementTbl::getVersionnumber)
                .containsExactly(tuple("Java", "中村", "第二"));
    }

}
