package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.dao.exception.DBException;
import com.cubic.entity.ItemDetailEntity;
import com.cubic.entity.ItemEntity;

public class OneToOne {

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

			ItemEntity itemEntity = createItem();
			ItemDetailEntity itemDetail = createItemDetail();
			itemEntity.setItemDetailEntity(itemDetail);
			itemDetail.setItem(itemEntity);
			em.persist(itemEntity);
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

	private static ItemEntity createItem() {
		ItemEntity entity = new ItemEntity();
		entity.setItemName("I-phone 7s");
		entity.setItemDesc("Apple I phone latest version");
		return entity;
	}

	private static ItemDetailEntity createItemDetail() {
		ItemDetailEntity entity = new ItemDetailEntity();
		entity.setItemWidth("3 inches");
		entity.setItemHeight("8 inches");
		entity.setColor("Black/White");
		return entity;
	}
}
