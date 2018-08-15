package be.businesstraining.client;

import java.time.LocalDate;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import be.businesstraining.domain.Categorie;
import be.businesstraining.domain.Produit;
import be.businesstraining.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {
			Session session = factory.openSession();
			
			// une catégorie et deux produits
			Categorie c1 = new Categorie("Smartphones");
			
			Produit p1 = new Produit("iPhone X", LocalDate.now(), c1);
			Produit p2 = new Produit("Samsung S", LocalDate.now(), c1);
			Produit p3 = new Produit("LG X", LocalDate.now(), c1);
			
			c1.setProduits(Arrays.asList(p1,p2,p3));
			
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				session.save(p1);
				session.save(p2);
				session.save(p3);
				session.save(c1);
				tx.commit();
				
			} catch (Exception e) {
			 if ((tx !=null) && (tx.isActive())) {
				 tx.rollback();
				 System.out.println("LOG : Annluation de la transaction "+tx);				
			}
			}			
			
			
		};
		System.out.println("==== FIN DU PROGRAMME ===="); 
		
		
	}
}
