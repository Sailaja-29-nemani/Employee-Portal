package com.employee.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTesting2 {

	@Test
	void test()
	{
		TestEmployee t2 = new TestEmployee();
		assertEquals(1, t2.isUser());
	}

}
