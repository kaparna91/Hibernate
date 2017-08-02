package com.jnit.hibernate.Main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.jnit.hibernate.model.Customer;
import com.jnit.hibernate.model.Order;

public class CustomerMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tran = s.beginTransaction();
		Customer customer = new Customer();
		customer.setCustomerName("aparna");
		
		
		Order order = new Order();
		order.setItem("Book");
		order.setCustomer(customer);
		Order order1 = new Order();
		order1.setItem("Watch");
		order1.setCustomer(customer);
		
		customer.getOrdersPlaced().add(order);
		customer.getOrdersPlaced().add(order1);
		
		s.saveOrUpdate(customer);
		
		
		
	
		
		tran.commit();
		// Customer customer = s.load(Customer.class, 1L);
		// Customer customer = s.get(Customer.class,1L);
		/*
		 * System.out.println(customer.getCustomerName());
		 * customer.setCustomerName("Aparna"); s.update(customer);
		 * tran.commit();
		 */
		s.close();
		sf.close();

	}
}
