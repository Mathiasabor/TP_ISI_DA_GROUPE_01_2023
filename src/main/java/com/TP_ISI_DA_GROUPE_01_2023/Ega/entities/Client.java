package com.TP_ISI_DA_GROUPE_01_2023.Ega.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	    private String nom;
	    
		private String prenom;
	    private LocalDate dateNaissance;
	    private String sexe;
	    private String adresse;
	    
	    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	    private List<Compte> comptes;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public LocalDate getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(LocalDate dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public List<Compte> getComptes() {
			return comptes;
		}

		public void setComptes(List<Compte> comptes) {
			this.comptes = comptes;
		}
		
		public Client AddComptes(Client client, Compte compte)
		{
			client.comptes.add(compte);
			return client;
		}
	    


	    
}
