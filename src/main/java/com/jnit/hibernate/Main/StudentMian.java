package com.jnit.hibernate.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.jnit.hibernate.model.Address;
import com.jnit.hibernate.model.Student;

public class StudentMian {

	public static void getStudent() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Student student = (Student) s.get(Student.class, 1);
		System.out.println(student);
		s.close();
		sf.close();
	}

	public static void insertStudent() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Student student = new Student();
		student.setName("sam");
		Transaction t = s.beginTransaction();
		s.save(student);
		t.commit();
		s.close();
		sf.close();
	}

	public static void insertStudentAddress() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Student student = new Student();
		student.setName("steve");
		Address address = new Address();
		address.setStreet("pinnacle");
		address.setCity("Lew");
		address.setState("TX");
		address.setZipCode("75607");
		student.setAddress(address);
		address.setStudent(student);
		Transaction t = s.beginTransaction();
		s.save(student);
		t.commit();
		s.close();
		sf.close();
	}

	public static void updateStudent() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Student student = (Student) s.load(Student.class, 1);
		Transaction t = s.beginTransaction();
		student.setName("joe");
		s.update(student);
		t.commit();
		s.close();
		sf.close();
	}

	public static void main(String[] args) {

		// insertStudent();
		updateStudent();
		// getStudent();
		// insertStudentAddress();

	}
}
