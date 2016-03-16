package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.entity.CategoryEntity;
import com.cubic.entity.ItemEntity;

public class OneToManyExample {
	public static void main(String[] args) {

		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			et = em.getTransaction();
			et.begin();

			CategoryEntity category = new CategoryEntity();
			category.setCategoryName("teswt");
			ItemEntity itemEntity = createItem();
			itemEntity.setCategory(category);
			category.getItems().add(itemEntity);

			em.persist(category);

			et.commit();
		} catch (Exception e) {
			et.setRollbackOnly();
			System.out.println("NO");
		} finally {
			if (em != null) {
				em.close();
			}

			if (emFactory != null) {
				emFactory.close();
			}
		}
	}

	private static ItemEntity createItem() {
		ItemEntity entity = new ItemEntity();
		entity.setItemName("laptop Phone 6S");
		entity.setItemDesc("laptop Phone 6Sx");

		return entity;
	}

}
