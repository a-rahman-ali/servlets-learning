package com.servlets.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		out.println(req.getParameter("num1") + ", " + req.getParameter("num2"));

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("add");
		requestDispatcher.forward(req, resp);

	}
}
