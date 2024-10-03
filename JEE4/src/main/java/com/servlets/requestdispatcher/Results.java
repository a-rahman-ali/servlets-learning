package com.servlets.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Results extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));

		Integer sum = (Integer) req.getAttribute("sum");
		Integer difference = (Integer) req.getAttribute("difference");
		Integer product = (Integer) req.getAttribute("product");
		Float quotient = (Float) req.getAttribute("quotient");
		Float remainder = (Float) req.getAttribute("remainder");

		out.println("Sum of " + num1 + ", " + num2 + " is : " + sum);
		out.println("Difference of " + num1 + ", " + num2 + " is : " + difference);
		out.println("Product of " + num1 + ", " + num2 + " is : " + product);
		out.println("Quotient of " + num1 + ", " + num2 + " is : " + quotient);
		out.println("Remainder of " + num1 + ", " + num2 + " is : " + remainder);

	}

}
