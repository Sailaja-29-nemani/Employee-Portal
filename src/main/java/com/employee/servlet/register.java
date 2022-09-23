package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Dao.RegisterDao;
import com.employee.beans.EmpRegistration;

@WebServlet("/register")
public class register extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RegisterDao dao=new RegisterDao();
		String empId=request.getParameter("empId");
		String empName=request.getParameter("empName");
		String empEmail=request.getParameter("empEmail");
		
		EmpRegistration emp =new EmpRegistration(empId,empName,empEmail);
		PrintWriter print=response.getWriter();
		if(dao.insert(emp))
		{
			print.println("<h1 style='color:blue'> <centre> Registration Successful</centre></h1>");
			RequestDispatcher req=request.getRequestDispatcher("index.jsp");
			req.include(request,response);
			
		}
		else
		{
			print.println("<h1 style='color:reg'> <centre> Couldn't complete Registration</centre></h1>");
			
		}
	}

}
