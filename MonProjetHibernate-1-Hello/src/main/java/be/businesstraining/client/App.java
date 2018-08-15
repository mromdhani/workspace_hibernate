package be.businesstraining.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import be.businesstraining.domain.Compte;

public class App {
	public static void main(String[] args) {
		
		// Obtenir la session factory à partir de la configuration
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		// Obtenir une session à partir de la sessionfactory
		Session session = factory.openSession();
		
		// Travailler sur les objets persistants via la session
		//Compte compte = session.get(Compte.class, "A300");
		Compte compte = session.get(Compte.class, "A300AAAAAAAA");
		
		System.out.println("Got using an Hibernate Session : "+ compte);
		
		
		// Clean Up
		session.close();
		factory.close();
		
	
		
		
		
		System.out.println("====== FIN DU PROGRAMME =====");
		
		
	}
}
