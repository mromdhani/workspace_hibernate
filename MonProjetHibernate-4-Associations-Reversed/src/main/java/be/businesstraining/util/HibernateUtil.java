package be.businesstraining.util;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			 System.out.println("LOG : ATTENTION, Il y a problème lors de la creation de la SessionFactory");
		}
	 }
	
	public static SessionFactory getSessionFactory() {
		 return sessionFactory;
	
	}

}
