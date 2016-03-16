package com.cubic.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userName = req.getParameter("username");
			String password = req.getParameter("pwd");
			if ("admin".equalsIgnoreCase(userName) && "1234".equals(password)) {
				HttpSession session = req.getSession();
				// session.setMaxInactiveInterval(60);
				session.setAttribute("User", userName);
				session.setAttribute("FullName", "pratap");

				Cookie c1 = new Cookie("coffee", "starbuck");
				Cookie c2 = new Cookie("phone", "iphone");
				c1.setMaxAge(120);
				c2.setMaxAge(60);
				resp.addCookie(c1);
				resp.addCookie(c2);

				resp.sendRedirect("list");

			} else {
				resp.sendRedirect("loginform?error=true");
			}
		} catch (Exception e) {
			resp.sendRedirect("loginform?error=true");
		}
	}

}
