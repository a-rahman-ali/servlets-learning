package com.servlets.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	static int count = 4;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");

//		HttpSession session = req.getSession();
//		session.setAttribute("username", username);

		Cookie c1 = new Cookie("username", username);
		Cookie c2 = new Cookie("password", password);

		resp.addCookie(c1);
		resp.addCookie(c2);

		if (password.equals("password")) {
//			RequestDispatcher requestDispatcher = req.getRequestDispatcher("homepage");
//			requestDispatcher.forward(req, resp);

			resp.sendRedirect("homepage");
		} else if (count > 1) {
			count--;
			out.println((count) + " Attempts Remaining");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
			requestDispatcher.include(req, resp);
		} else {
			resp.sendRedirect("blocked.html");
		}

	}
}
