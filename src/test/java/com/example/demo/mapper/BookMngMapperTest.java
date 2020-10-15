package com.example.demo.mapper;

import java.io.File;
import java.sql.Connection;

import javax.transaction.Transactional;

import org.dbunit.Assertion;
import org.dbunit.DefaultDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.config.BookMngMapperTestConfig;
import com.example.demo.form.BooksForm;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(BookMngMapperTestConfig.class)
@Transactional
public class BookMngMapperTest {
	@Autowired
	BookMngMapper bookMngMapper;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private BooksForm booksForm;
	private static IDatabaseTester databaseTester;
	
	@Before
	public void setupForm() throws Exception {
		
	Connection conn = jdbcTemplate.getDataSource().getConnection();
	IDatabaseConnection dbconn = new DatabaseConnection(conn, "books");
	DatabaseConfig config = dbconn.getConfig();
	config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
	IDataSet dataset = new FlatXmlDataSetBuilder().build(new File("src/data/beforeData.xml"));
	DatabaseOperation.CLEAN_INSERT.execute(dbconn, dataset);
	databaseTester = new DefaultDatabaseTester(dbconn);
	}
	@After
	  public void tearDown() throws Exception {
	    databaseTester.setTearDownOperation(DatabaseOperation.NONE);
	    databaseTester.onTearDown();
	  }
	@Test
	  public void updateTest() {


	    try {
	    	IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/data/updateAfter.xml"));
	        ITable expectedTable = expectedDataSet.getTable("book_management_tbl");
	       
//	        BooksForm booksForm = new BooksForm();
	        booksForm.setTitle("Go");
	        booksForm.setAuthor("マイケル");
//	        updateAfter.xmlと値(Bookscount(80))が合わなくても関係ない？
	        booksForm.setBookscount(80);
	        bookMngMapper.update(booksForm);
	        
	        IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
	        ITable actualTable = databaseDataSet.getTable("book_management_tbl");
//	        expected: 期待値,actual: 実際の値
//	        Assertionはtrueを前提としてテストしている
	        Assertion.assertEquals(expectedTable, actualTable);
	    }catch (Exception e) {
	    	System.out.println(e);
	    	
	    }
	
	}
	
}
