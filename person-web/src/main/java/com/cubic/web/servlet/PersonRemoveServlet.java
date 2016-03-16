package com.cubic.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubic.dao.PersonDAO;
import com.cubic.util.SpringFactory;
import com.cubic.vo.PersonVO;

public class PersonRemoveServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			PersonDAO dao = SpringFactory.getInstance().getBean(PersonDAO.class);
			String firstName = req.getParameter("fname");
			String lastName = req.getParameter("lname");
			String id = req.getParameter("pk");

			Long pk = (id != null && id.trim().matches("\\d+")) ? new Long(id) : null;
			PersonVO person = new PersonVO();
			person.setId(pk);
			if (pk != null) {
				dao.removePerson(pk);
			} else {
				System.out.println("empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("list");

	}
}
