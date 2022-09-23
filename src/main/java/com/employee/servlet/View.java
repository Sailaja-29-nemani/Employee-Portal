package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Dao.RegisterDao;
import com.employee.beans.EmpRegistration;

@WebServlet("/ViewEmp")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegisterDao dao = new RegisterDao();
		List<EmpRegistration> list = dao.getUsers();
		
		PrintWriter out = resp.getWriter();
		out.println("<table cellspacing='0' width=+'35px' border='1px'>");
		out.println("<tr>");
		out.println("<th> Employee Id </th>");
		out.println("<th> Employee Name </th>");
		out.println("<th> Employee Email </th>");
		out.println("</tr>");
		for (EmpRegistration user : list) {
			out.println("<tr>");
			out.println("<td>" + user.getEmpId() + "</td>");
			out.println("<td>" + user.getEmpName() + "</td>");
			out.println("<td>" + user.getEmpEmail() + "</td>");
			out.println("<td> <a href = 'Delete?empId=" + user.getEmpId() + "'> &#10060" + "</td>");
			out.println("<td> <a href = 'Update?'> &#9998 </a> </td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

}
