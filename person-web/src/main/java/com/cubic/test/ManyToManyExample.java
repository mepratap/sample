package com.cubic.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.entity.CourseEntity;
import com.cubic.entity.StudentEntity;

public class ManyToManyExample {
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

			CourseEntity entity = new CourseEntity();
			entity.setCourseName("Acting");
			List<StudentEntity> students = createStudents(entity);
			entity.getStudents().addAll(students);

			em.persist(entity);

			et.commit();
		} catch (Exception e) {
			et.setRollbackOnly();
		} finally {
			if (em != null) {
				em.close();
			}

			// if(emFactory != null) {
			emFactory.close();
		}
	}

	private static List<StudentEntity> createStudents(CourseEntity entity) {
		List<StudentEntity> students = new ArrayList<StudentEntity>();
		StudentEntity sEntity1 = new StudentEntity();
		sEntity1.setStudentName("Pie D");
		sEntity1.getCourses().add(entity);

		StudentEntity sEntity2 = new StudentEntity();
		sEntity2.setStudentName("Khalid");
		sEntity2.getCourses().add(entity);

		students.add(sEntity1);
		students.add(sEntity2);

		return students;
	}

}