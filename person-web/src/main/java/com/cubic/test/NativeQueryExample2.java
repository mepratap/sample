package com.cubic.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cubic.dao.exception.DBException;
import com.cubic.entity.ItemEntity;

public class NativeQueryExample2 {

	public static void main(String[] args) throws DBException {
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			BigDecimal count = (BigDecimal) em.createNamedQuery("ItemEntity.findAll", ItemEntity.class);
			System.out.println(count);

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
