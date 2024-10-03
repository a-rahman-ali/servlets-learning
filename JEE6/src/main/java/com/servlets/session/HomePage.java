package com.servlets.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePage extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String username = req.getParameter("username");

		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");

		PrintWriter out = resp.getWriter();
		out.println(username + ", Welcome to HomePage");
	}
}
