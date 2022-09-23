package com.employee.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.employee.beans.EmpRegistration;
import com.employee.connect.JDBCConnection;

public class RegisterDao {
	public boolean insert(EmpRegistration emp) {
		String query = "insert into employeereg values(?,?,?)";
		PreparedStatement st;
		try {
			st = JDBCConnection.getconnect().prepareStatement(query);
			st.setString(1, emp.getEmpId());
			st.setString(2, emp.getEmpName());
			st.setString(3, emp.getEmpEmail());
			return st.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<EmpRegistration> getUsers() {
		String sql = "select * from employeereg";
		List<EmpRegistration> listUser = new ArrayList<>();
		try {
			PreparedStatement st = JDBCConnection.getconnect().prepareStatement(sql);
			ResultSet res = st.executeQuery();
			EmpRegistration user = null;
			while (res.next()) {
				user = new EmpRegistration();
				user.setEmpId(res.getString(1));
				user.setEmpName(res.getString(2));
				user.setEmpEmail(res.getString(3));
				listUser.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public String getTime() {
		String timeQuery = "select curtime()";
		ResultSet time_res;
		String time = null;
		try {
			PreparedStatement time_st = JDBCConnection.getconnect().prepareStatement(timeQuery);
			time_res = time_st.executeQuery();
			while(time_res.next()) {
				time = time_res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return time;
	}
	
	public String getDate() {
		String dateQuery = "select curdate()";
		ResultSet date_res;
		String date = null;
		try {
			PreparedStatement time_st = JDBCConnection.getconnect().prepareStatement(dateQuery);
			date_res = time_st.executeQuery();
			while(date_res.next()) {
				date = date_res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return date;
	}

	public int login(EmpRegistration emp) {
		String date = getDate();
		String loginTime = getTime();
		String sql = "insert into employeelogin(empId, empName, login_date, login_time) values(?, ?, ?, ?)";
		String uidquery="select uid from employeelogin where login_time=?";
		
		int uid=0;
		
		try {
			
			PreparedStatement st = JDBCConnection.getconnect().prepareStatement(sql);
			st.setString(1, emp.getEmpId());
			st.setString(2, emp.getEmpName());
			st.setString(3, date);
			st.setString(4, loginTime);
			st.executeUpdate();
			
			PreparedStatement st1 = JDBCConnection.getconnect().prepareStatement(uidquery);
			st1.setString(1, loginTime);
			ResultSet res = st1.executeQuery();
			while(res.next()) {
				uid = res.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uid;
	}
	public boolean logout(int uid)
	{
		String sql = "update employeelogin set logout_time = ? where uid = ?";
		
		try {
			
			String logoutTime = getTime();
			PreparedStatement st = JDBCConnection.getconnect().prepareStatement(sql);
			st.setString(1, logoutTime);
			st.setInt(2, uid);
			return st.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isUser(String empId, String empName) {
		String query = "select * from employeereg where empId = ?";
		int count = 0;
		String name = null;
		try {
			PreparedStatement st = JDBCConnection.getconnect().prepareStatement(query);
			st.setString(1, empId);
			ResultSet res = st.executeQuery();
			while(res.next()) {
				count++;
				name = res.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (count==1) && (name.equals(empName));
		
	}
	
}
