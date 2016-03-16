package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.dao.exception.DBException;
import com.cubic.entity.PersonEntity;

public class PersonDAOTest {

	public static void main(String[] args) throws DBException {
		// PersonDAO dao = SpringFactory.getInstance().getBean(PersonDAO.class);
		// PersonDAO dao = new PersonDAOImpl();
		/*
		 * String id = "86"; Long pk = new Long(id); PersonVO vo =
		 * dao.getPerson(pk); System.out.println(vo);
		 */

		/*
		 * vo.setFirstName("roshan"); vo.setLastName("shrestha");
		 * vo=dao.createPerson(vo); System.out.println(vo);
		 */

		/*
		 * vo.setFirstName("roshan"); vo.setLastName("sharma"); vo.setId(25);
		 * vo=dao.modifyPerson(vo); System.out.println(vo);
		 */

		/*
		 * List<PersonVO> results=dao.searchPersons("r");
		 * System.out.println(results);
		 */
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			et = em.getTransaction();
			et.begin();

			PersonEntity entity = new PersonEntity();
			entity.setFirstName("sulabh");
			entity.setLastName("bhandari");
			em.persist(entity);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.setRollbackOnly();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emFactory != null) {
				emFactory.close();
			}
		}

	}

}
