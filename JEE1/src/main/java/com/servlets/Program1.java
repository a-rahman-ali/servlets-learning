package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Program1 extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = req.getParameter("username");
//		PrintWriter out = resp.getWriter();
//		
//		out.println("Welcome " + name);
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		PrintWriter out = resp.getWriter();
		
		out.println("Inside doGet method");
		out.println("Welcome " + name);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		PrintWriter out = resp.getWriter();
		
		out.println("Inside doPost method");
		out.println("Welcome " + name);
	}
	
}
