package com.cubic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginFormServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(LoginFormServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String error = req.getParameter("error");

		PrintWriter out = resp.getWriter();
		out.println("<HTML><BODY>");
		out.println("<h2>Login</h2><br/></br>");

		if (error != null) {
			logger.error("check for valid username/password");
			out.println("<font color=\"red\"><h4>Please enter valid username/ password</h4></font></br>");
		}

		out.println("<form method=\"POST\" action=\"login\">");
		out.println("<TABLE>");
		out.println("<TR>");
		out.println(
				"<td width=\"100\">User Name:</td><TD><input type=\"text\" name=\"username\" maxlength=\"100\" size=\"30\"></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println(
				"<td width=\"100\">Password:</td><TD><input type=\"password\" name=\"pwd\" maxlength=\"100\" size=\"30\"></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD colspan=\"2\" align=\"right\"><input type=\"submit\" value=\"Login\"></TD></TD>");
		out.println("</TR>");
		out.println("</TABLE>");
		out.println("</form>");
		out.println("</BODY></HTML>");
		out.close();

	}

}