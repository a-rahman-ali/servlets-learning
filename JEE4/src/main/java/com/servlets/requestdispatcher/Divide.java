package com.servlets.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Divide extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));

		try {
			out.println("Quotient of " + num1 + ", " + num2 + " is : " + (num1 / (float) num2));
		} catch (ArithmeticException e) {
			out.println("Denominator can't be zero");
		}

//		req.setAttribute("quotient", (num1 / num2));

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("modulo");
//		requestDispatcher.forward(req, resp);
		requestDispatcher.include(req, resp);

	}

}
