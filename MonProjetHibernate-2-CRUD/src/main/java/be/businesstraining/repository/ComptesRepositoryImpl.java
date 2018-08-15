package be.businesstraining.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import be.businesstraining.domain.Compte;
import be.businesstraining.util.HibernateUtil;

public class ComptesRepositoryImpl implements IComptesRepository {

	@Override
	public void create(Compte c) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(c);
			tx.commit();			
		} catch (Exception e) {
			if ((tx != null) && tx.isActive()) {
				tx.rollback();
				System.out.println("LOG : Transaction annulée !");
			}
		}

	}

	@Override
	public Compte findById(String id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		return session.get(Compte.class, id);

	}

	@Override
	public List<Compte> findAll() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		 Query query = session.createQuery("from Compte c");  //HQL (JPA-QL)
		
		 return (List<Compte>)query.getResultList();
	
	}

	@Override
	public Compte update(Compte c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Compte à_supprimer = session.get(Compte.class, id);
			session.delete(à_supprimer);
			tx.commit();			
		} catch (Exception e) {
			if ((tx != null) && tx.isActive()) {
				tx.rollback();
				System.out.println("LOG : Transaction annulée !");
			}
		}
	}

}
