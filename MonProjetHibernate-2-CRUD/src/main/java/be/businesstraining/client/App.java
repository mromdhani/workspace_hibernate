package be.businesstraining.client;

import java.math.BigDecimal;

import be.businesstraining.domain.Compte;
import be.businesstraining.repository.ComptesRepositoryImpl;
import be.businesstraining.repository.IComptesRepository;

public class App {
	public static void main(String[] args) {

		IComptesRepository repo = new ComptesRepositoryImpl();

		// testFindById(repo);

		// testCreate(repo);
		// testDelete(repo);

		testFindAll(repo);

		System.out.println("====== FIN DU PROGRAMME =====");

	}

	private static void testFindAll(IComptesRepository repo) {

		repo.findAll().forEach(System.out::println);

	}

	private static void testDelete(IComptesRepository repo) {
		repo.delete("Z100");

	}

	private static void testCreate(IComptesRepository repo) {

		repo.create(new Compte("C100", "Souhail AOUIRIKA", new BigDecimal("100")));

	}

	private static void testFindById(IComptesRepository repo) {
		System.out.println(repo.findById("A300"));
	}
}
