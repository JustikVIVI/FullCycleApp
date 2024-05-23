package com.learning.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void simpleTest() {
		int a = 2 + 2;

		assertEquals(4, a);
	}

	@Test
	void failTest() {
		int a = 2 + 1;

		assertEquals(3, a);
	}

}
