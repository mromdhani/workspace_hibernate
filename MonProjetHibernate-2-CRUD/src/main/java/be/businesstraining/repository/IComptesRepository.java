package be.businesstraining.repository;

import java.util.List;

import be.businesstraining.domain.Compte;

public interface IComptesRepository {
	
	// CRUD Facade
	void create(Compte c);
	Compte findById(String id);
	List<Compte> findAll();
	Compte update (Compte c);
	void delete (String id);

}
