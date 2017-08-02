package com.jnit.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class AuthorBook {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Book book = new Book();
		book.setName("Introduction to java");

		Book book1 = new Book();
		book.setName("Introduction to hibernate");

		Book book2 = new Book();
		book.setName("Introduction to AdvancedJava");

		session.save(book);
		session.save(book1);
		session.save(book2);

		Author author = new Author();
		author.setAuthorName("samuel");

		author.getBooks().add(book);
		author.getBooks().add(book1);
		author.getBooks().add(book2);

		// employee.getTasks().add(task);

		session.save(author);

		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
