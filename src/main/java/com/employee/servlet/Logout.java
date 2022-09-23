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

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDao dao = new RegisterDao();
		
		HttpSession session = request.getSession(false);
		int uid = (int) session.getAttribute("uid");
		
		if (dao.logout(uid)) {
			RequestDispatcher req = request.getRequestDispatcher("logout.jsp");
			req.forward(request, response);
		}
		
		else {
			PrintWriter writer = response.getWriter();	
			writer.println("<h2> Error logging out. </h2>");
		}
	}

}
