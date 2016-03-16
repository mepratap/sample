package com.cubic.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cubic.dao.PersonDAO;
import com.cubic.util.SpringFactory;
import com.cubic.vo.PersonVO;

public class PersonCreateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			PersonDAO dao = SpringFactory.getInstance().getBean(PersonDAO.class);
			String firstName = req.getParameter("fname");
			String lastName = req.getParameter("lname");
			String id = req.getParameter("pk");

			Long pk = (id != null && id.trim().matches("\\d+")) ? new Long(id) : null;

			PersonVO person = new PersonVO();

			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setId(pk);

			if (pk != null) {
				dao.modifyPerson(person);
			} else {
				dao.createPerson(person);
			}

			System.out.println("fname: " + person.getFirstName());
			System.out.println("lname: " + person.getLastName());
			System.out.println("id: " + person.getId());
			// dao.createPerson(person);
			System.out.println("Debug123");

		} catch (Exception e) {
			System.out.println("Coming inside create servlet exception");
			e.printStackTrace();
		}
		resp.sendRedirect("list");
	}

}