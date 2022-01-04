package com.ksa.project;

import com.ksa.project.repository.BookRepository;
import com.ksa.project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {
	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {

	}

}
