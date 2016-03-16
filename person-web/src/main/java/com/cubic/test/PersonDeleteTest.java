package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.dao.exception.DBException;
import com.cubic.entity.PersonEntity;

public class PersonDeleteTest {

	public static void main(String[] args) throws DBException {

		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			et = em.getTransaction();
			et.begin();

			PersonEntity entity = em.find(PersonEntity.class, new Long(105));
			em.remove(entity);
			et.commit();

			System.out.println(entity);
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
