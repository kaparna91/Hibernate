package com.jnit.hibernate.Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hibernate.util.HibernateUtil;
import com.jnit.hibernate.model.Address;
import com.jnit.hibernate.model.Student;

public class OnetoOne {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Student c = new Student();
		c.setName("jack");
		Address address = new Address();
		address.setStreet("pinnacle");
		address.setCity("LewisVille");
		address.setState("TX");
		address.setZipCode("75607");
		c.setAddress(address);
		address.setStudent(c);
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
		sf.close();
	}

}
