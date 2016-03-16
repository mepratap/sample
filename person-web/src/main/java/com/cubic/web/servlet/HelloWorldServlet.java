package com.cubic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class HelloWorldServlet extends HttpServlet{

	private int counter=0;
	@Override
	public void init(ServletConfig config) throws ServletException {
		counter=0;
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		counter++;
		PrintWriter out=resp.getWriter();
		out.println("<html><header>");
		out.println("<title>This is title</title></header>");
		out.print("<body>Hello World");
		out.print("<body>Hello World hi");
		out.println("</body></html>");
		
	}
	

}
