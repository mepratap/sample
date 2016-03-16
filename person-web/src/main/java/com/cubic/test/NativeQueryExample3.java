package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cubic.dao.exception.DBException;

public class NativeQueryExample3 {

	public static void main(String[] args) throws DBException {
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			Query query = em.createNamedQuery("ItemEntity.cols");
			List<Object[]> results = query.getResultList();
			for (Object[] result : results) {
				System.out.println(result[0] + "===>" + result[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}

			// if(emFactory != null) {
			emFactory.close();
		}
	}

}
