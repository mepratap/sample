package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.dao.exception.DBException;
import com.cubic.entity.ItemEntity;

public class NativeQueryExample {

	public static void main(String[] args) throws DBException {
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			TypedQuery<ItemEntity> query = em.createNamedQuery("ItemEntity.findAll", ItemEntity.class);
			List<ItemEntity> results = query.getResultList();
			for (ItemEntity entity : results) {
				System.out.println(entity);
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
