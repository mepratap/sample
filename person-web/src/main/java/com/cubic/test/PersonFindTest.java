package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.dao.exception.DBException;
import com.cubic.entity.PersonEntity;

public class PersonFindTest {

	public static void main(String[] args) throws DBException {

		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			TypedQuery<PersonEntity> query = em.createQuery("select p from PersonEntity p", PersonEntity.class);
			List<PersonEntity> results = query.getResultList();
			for (PersonEntity entity : results) {
				System.out.println(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();

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
