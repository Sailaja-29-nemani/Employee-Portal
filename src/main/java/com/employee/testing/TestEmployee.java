package com.employee.testing;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employee.connect.*;
import com.employee.Dao.*;
public class TestEmployee
{
	public boolean isConnected() throws SQLException {
		Connection con = JDBCConnection.getconnect();
		return con != null;
}
public int isUser()
{
		
		RegisterDao dao = new RegisterDao();
		String empId = "705035";
		String empName = "Sailaja";
		boolean isValidUser = dao.isUser(empId, empName);
		if (isValidUser) 
			return 1;
		return 0;
		
	}
}
