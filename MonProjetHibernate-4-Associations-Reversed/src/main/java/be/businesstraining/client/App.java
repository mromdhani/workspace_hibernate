package be.businesstraining.client;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import be.businesstraining.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {
			Session session = factory.openSession();
			
			
			Query query = session.createQuery("from Produit p");
			
			query.getResultList().forEach(System.out::println);
			
			
		};
		System.out.println("==== FIN DU PROGRAMME ===="); 
		
		
	}
}
