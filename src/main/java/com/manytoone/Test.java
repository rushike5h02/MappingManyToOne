package com.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {



		Employee e1 = new Employee(); 
		e1.setName("rushikesh");
		e1.setEmail("rushikesh@gmail.com");

		Employee e2 = new Employee(); 
		e2.setName("bhand"); 
		e2.setEmail("bhand@gmail.com");


		Address address1 = new Address(); 
		address1.setCity("Nagar"); 
		address1.setState("Maharashtra");
		 
		address1.setCountry("India");
		address1.setPinCode("414001");


		Configuration configuration = new Configuration(); 
		configuration.configure("hibernate.cfg.xml"); //load the file
		SessionFactory sessionFactory = configuration.buildSessionFactory(); 
		Session session=sessionFactory.openSession();
		Transaction t= session.beginTransaction(); 
		
		e1.setAddress(address1); 
		e2.setAddress(address1);


		session.save(e1); 
		session.save(e2); 
		
		t.commit(); 
		session.close(); 
		sessionFactory.close();

		System.out.println("Insertion Succesfull");

		}


}
