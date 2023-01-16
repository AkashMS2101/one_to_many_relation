package one_to_many_uni2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni2.dto.School;
import one_to_many_uni2.dto.Student;

public class SchoolDao {
	public void saveSchool(School school) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Student> list = school.getList();
		entityTransaction.begin();
		for (Student student : list) {
			entityManager.persist(student);
		}
		entityManager.persist(school);
		entityTransaction.commit();
	}

	public void updateSchool(int id, School school) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		School school2 = entityManager.find(School.class, id);
		school.setSclId(id);
		school.setList(school2.getList());

		if (school2 != null) {
			entityManager.merge(school);
			entityTransaction.commit();
		} else {
			System.out.println("school doesnt exist");
		}
	}

	public void deleteSchool(int id, School school) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		School school2 = entityManager.find(School.class, id);
		school.setSclId(id);
		school.setList(school2.getList());

		if (school2 != null) {
			entityManager.remove(school);
			entityTransaction.commit();
		} else {
			System.out.println("school doesnt exist");
		}
	}

	public void displayById(int id, School school) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		School school2 = entityManager.find(School.class, id);
		System.out.println(school2);
	}

	public void displayAllSchool() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		javax.persistence.Query query = entityManager.createQuery("select s from school s");

		List<School> list = query.getResultList();
		System.out.println(list);
	}
}
