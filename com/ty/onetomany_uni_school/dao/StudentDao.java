package com.ty.onetomany_uni_school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany_uni_school.dto.Student;



public class StudentDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;

	}

	public void insertStudent(List<Student> list) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for(Student s:list) {
			entityTransaction.begin();
		entityManager.persist(s);
		entityTransaction.commit();
		}
		System.out.println("data insert sucessfully");

	}

	public void UPdateStudent(int id, Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction enitityTransaction = entityManager.getTransaction();
		Student student2 = entityManager.find(Student.class, id);
		if (student2 != null) {
			student2.setId(id);

			enitityTransaction.begin();
			entityManager.merge(student2);
			enitityTransaction.commit();
		} else {
			System.out.println("school not exist");
		}

	}
	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		student.setId(id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();

	}

	public void getStudentById(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		System.out.println(student);

	}
	public void RetriveAllStudent() {
		EntityManager entityManager = getEntityManager();
		javax.persistence.Query query = entityManager.createQuery("select p from Student p");
		List resultList = query.getResultList();
		System.out.println(resultList);
	}

}

