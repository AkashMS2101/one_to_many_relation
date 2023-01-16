package one_to_many_uni2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni2.dto.School;
import one_to_many_uni2.dto.Student;

public class StudentDao {
	public void saveStudent(Student std) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(std);
		entityTransaction.commit();
	}

	public void updateStudent(int id, Student std) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Student std2 = entityManager.find(Student.class, id);
		std2.setSid(id);

		if (std2 != null) {
			entityManager.merge(std);
			entityTransaction.commit();
		} else {
			System.out.println("student doesnt exist");
		}
	}

	public void deleteStudent(int id, Student student) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Student std = entityManager.find(Student.class, id);
		if (std != null) {
			entityManager.remove(student);
			entityTransaction.commit();
		} else {
			System.out.println("student doesnt exist");
		}
	}

	public void displayById(int id, Student std) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student std2 = entityManager.find(Student.class, id);
		System.out.println(std2);
	}

	public void displayAllStudent() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		javax.persistence.Query query = entityManager.createQuery("select s from student s");

		List<School> list = query.getResultList();
		System.out.println(list);
	}
}
