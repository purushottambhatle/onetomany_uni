package com.ty.onetomany_uni_school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.onetomany_uni_school.dto.School;
import com.ty.onetomany_uni_school.dto.Student;

public class SchoolDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager createEntityManager = entityManagerFactory.createEntityManager();
		return createEntityManager;
	}

	public void saveSchool(School school) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Student> students = school.getStudents();
		entityTransaction.begin();
		entityManager.persist(school);
		for (Student s : students) {

			entityManager.persist(s);

		}
		entityTransaction.commit();

	}
	public void updateSchoool(int id, School school) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school2 = entityManager.find(School.class, id);

		if (school2 != null) {
			school2.setId(id);
			school2.setName(school.getName());
			entityTransaction.begin();
			entityManager.merge(school2);
			entityTransaction.commit();
		} else {
			System.out.println("school not exist");
		}

	}

	public void removeSchool(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school2 = entityManager.find(School.class, id);

		entityTransaction.begin();
		entityManager.remove(school2);
		entityTransaction.commit();
	}

	public void getSchool(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school2 = entityManager.find(School.class, id);
		System.out.println(school2);
	}

	public void getAllSchool() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from School p");
		List<School> list = query.getResultList();
		System.out.println(list);
		System.out.println("sucessfully we fetch all data");

	}
}

