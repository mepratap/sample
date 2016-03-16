package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.entity.StudentEntity;

public class StudentQueryExample1 {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("PersistExample");
			em = emFactory.createEntityManager();
			System.out.println("success");
			TypedQuery<StudentEntity> query = em.createNamedQuery("StudentEntity.GetAll", StudentEntity.class);
			List<StudentEntity> results = query.getResultList();
			for (StudentEntity entity : results) {
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
