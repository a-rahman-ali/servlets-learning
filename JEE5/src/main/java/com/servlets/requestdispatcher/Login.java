package com.servlets.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	static int count = 4;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

//		HttpSession session = req.getSession(true);
//		Integer count = (Integer) session.getAttribute("count");
//
//		if (count == null) {
//			count = 4;
//		}
//		session.setAttribute("count", count);
		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");

		if (username.equals("admin") && password.equals("password")) {
//			session.setAttribute("count", 4);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("homepage");
			requestDispatcher.forward(req, resp);

			// problem araising due to this(i.e the username is not being send) has been
			// fixed in next project
//			resp.sendRedirect("homepage");
		} else if (count > 1) {
			count--;
//			session.setAttribute("count", count);
			out.println((count) + " Attempts Remaining");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
			requestDispatcher.include(req, resp);
		} else {
//			session.setAttribute("count", 0);
//			out.println("Maxx attempts reached... Please try again later");

//			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/blocked.html");
//			requestDispatcher.forward(req, resp);

			resp.sendRedirect("blocked.html");
		}

//		session.invalidate();
	}
}
