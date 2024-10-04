package com.servlets.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String username = req.getParameter("username");

//		HttpSession session = req.getSession();
//		String username = (String) session.getAttribute("username");

		Cookie[] cookies = req.getCookies();
//		String username = cookies[0].getValue();

		PrintWriter out = resp.getWriter();

		for (Cookie c : cookies) {
			out.println(c.getName() + " : " + c.getValue());
		}
		out.println(cookies[0].getValue() + ", Welcome to HomePage");
		out.println(cookies[0].getValue() + ", your password is: " + cookies[1].getValue());
	}
}
