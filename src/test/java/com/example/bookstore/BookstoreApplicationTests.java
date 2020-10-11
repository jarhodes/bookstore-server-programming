package com.example.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
