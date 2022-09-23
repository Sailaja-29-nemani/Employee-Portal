package com.employee.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UnitTesting1
{
	@Test
	void test() throws SQLException
	{
		TestEmployee t1 = new TestEmployee();
		assertEquals(true, t1.isConnected());
	}

}
