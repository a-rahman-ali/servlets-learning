package com.servlets.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Subtract extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));

		out.println("Difference of " + num1 + ", " + num2 + " is : " + (num1 - num2));

//		req.setAttribute("difference", (num1 - num2));

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("multiply");
//		requestDispatcher.forward(req, resp);
		requestDispatcher.include(req, resp);

	}

}
