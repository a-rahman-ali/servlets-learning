package com.servlets.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/homepage", initParams = @WebInitParam(name = "username", value = "Username from annotation"))
public class HomePage extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init() of HomePage servlet called!");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() of HomePage servlet called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");

		ServletConfig config = getServletConfig();
		username = config.getInitParameter("username");

//		ServletContext context = getServletContext();
//		username = context.getInitParameter("username");

//		HttpSession session = req.getSession();
//		String username = (String) session.getAttribute("username");

//		Cookie[] cookies = req.getCookies();
//		String username = cookies[0].getValue();

		PrintWriter out = resp.getWriter();

//		for (Cookie c : cookies) {
//			out.println(c.getName() + " : " + c.getValue());
//		}

		out.println(username + ", Welcome to HomePage");
//		out.println(cookies[0].getValue() + ", Welcome to HomePage");
//		out.println(cookies[0].getValue() + ", your password is: " + cookies[1].getValue());
	}
}
