package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterEmployee extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("department");
		int salary = Integer.parseInt(req.getParameter("salary"));

		Employee e = new Employee(id, name, email, department, salary);

		EmployeeBO bo = new EmployeeBO();
		int i = bo.save(e);

		PrintWriter out = resp.getWriter();

		if (i == 1) {
			out.println("Employee registered successfully");
		} else {
			out.println("Error in registering employee");
		}
	}
}
