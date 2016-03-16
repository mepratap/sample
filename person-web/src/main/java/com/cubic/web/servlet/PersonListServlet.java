package com.cubic.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cubic.dao.PersonDAO;
import com.cubic.util.SpringFactory;
import com.cubic.vo.PersonVO;

public class PersonListServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(PersonListServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<HTML><BODY>");
		try {
			logger.debug("entering inside personlistservlet");
			HttpSession session = req.getSession(false);
			if (session != null) {
				out.println("<BR/>");
				out.println("<h4>User Logged In:" + session.getAttribute("user") + "</h4>");
				out.println("<h4>Welcome:" + session.getAttribute("fullName") + "</h4>");
				out.println("<h4><a href=\"logOut\">logout" + session.getAttribute("user") + "</a></h4>");
				out.println("<BR/>");

			}

			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				out.println("Cookie Information:");
				for (Cookie c : cookies) {
					out.println(c.getName() + "-->" + c.getValue());
				}
			}

			PersonDAO dao = SpringFactory.getInstance().getBean(PersonDAO.class);
			List<PersonVO> results = dao.getAllPersons();
			out.println("<BR/>");
			out.println("<h2>Person List Records</h2>");
			out.println("<BR/><BR/>");
			out.println("click here to create person==> <a href=\"form\">Person</a>");
			out.println("<BR/><BR/>");
			out.println("<TABLE>");
			out.println("<TR>");
			out.println("  <TH>PERSON ID</TH>");
			out.println("  <TH>First Name</TH>");
			out.println("  <TH>Last Name</TH>");
			out.println("  <TH>&nbsp;</TH>");
			out.println("</TR>");
			for (PersonVO vo : results) {
				out.println("<TR>");
				out.println("  <TD>" + vo.getId() + "</TD>");
				out.println(" <TD><a href=\"form?pk=" + vo.getId() + "\">" + vo.getFirstName() + "</a></TD>");
				out.println("  <TD>" + vo.getLastName() + "</TD>");
				out.println(" <TD><a href=\"remove?pk=" + vo.getId() + "\">" + "remove" + "</a></TD>");
				out.println(" <TD>&nbsp;</TD>");
				out.println("</TR>");
			}
			out.println("</TABLE>");

		} catch (Exception e) {
			logger.error("error occured");
			e.printStackTrace();
			out.println("<h2>Exception occurred :" + e.getMessage() + "</h2>");
		} finally {
			out.println("</BODY></HTML>");
			out.close();
		}

	}

}