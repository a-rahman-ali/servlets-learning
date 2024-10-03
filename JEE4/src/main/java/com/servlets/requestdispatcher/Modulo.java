package com.servlets.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Modulo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));

		try {
			out.println("Remainder of " + num1 + ", " + num2 + " is : " + ((float) (num1) % num2));
		} catch (ArithmeticException e) {
			out.println("Denominator can't be zero");
		}
//		req.setAttribute("remainder", (num1 % num2));

//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("results");
//		requestDispatcher.forward(req, resp);
//		requestDispatcher.include(req, resp);
	}

}
