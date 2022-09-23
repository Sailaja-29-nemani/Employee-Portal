package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.Dao.RegisterDao;
import com.employee.beans.EmpRegistration;

@WebServlet("/login")
public class login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empEmail = request.getParameter("empEmail");
		EmpRegistration emp = new EmpRegistration(empId, empName, empEmail);

		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();

		RegisterDao dao = new RegisterDao();
		if (dao.isUser(empId, empName)) {
			session.setAttribute("empName", empName);

			int uid = dao.login(emp);

			session.setAttribute("uid", uid);

			RequestDispatcher req = request.getRequestDispatcher("home.jsp");
			req.include(request, response);
		} else {
			writer.println("Invalid Credentials");

		}
	}

}
