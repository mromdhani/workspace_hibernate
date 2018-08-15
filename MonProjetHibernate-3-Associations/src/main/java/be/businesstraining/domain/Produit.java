package be.businesstraining.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produits")
public class Produit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	
	private String nom;
	
	private LocalDate dateDeProduction;
	
	public Produit() {
	}
	
	public Produit(String nom, LocalDate dateDeProduction, Categorie categorie) {
		super();
		this.nom = nom;
		this.dateDeProduction = dateDeProduction;
		this.categorie = categorie;
	}

	@ManyToOne
	private Categorie categorie;

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateDeProduction() {
		return dateDeProduction;
	}

	public void setDateDeProduction(LocalDate dateDeProduction) {
		this.dateDeProduction = dateDeProduction;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nom=" + nom + ", dateDeProduction=" + dateDeProduction + "]";
	}
	
	

}
