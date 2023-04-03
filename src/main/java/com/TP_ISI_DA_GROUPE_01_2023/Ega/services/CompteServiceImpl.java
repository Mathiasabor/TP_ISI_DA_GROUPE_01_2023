package com.TP_ISI_DA_GROUPE_01_2023.Ega.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Compte;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.repositories.ClientRepository;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.repositories.CompteRepository;
@Service
public class CompteServiceImpl implements CompteService {
	

    @Autowired
	private CompteRepository compteRepo;
	@Override
	public List<Compte> showCompte() {
		return compteRepo.findAll();
	}

	@Override
	public Compte saveCompte(Compte compte) {
		return compteRepo.save(compte);
	}

	@Override
	public Compte getOneCompte(Long id) {
		return compteRepo.findById(id).get();
	}

	@Override
	public void deleteCompte(Long id) {
		compteRepo.deleteById(id);

	}

	/*
	 * private Long id;
	  *  private String numero;
	    private String type;
	    private LocalDate dateCreation;
	    private double solde;
	 * 
	 * 
	 * 
	 * */
	
	
	@Autowired
	public ClientService clientServ;
	
	
	@Override
	public Compte CreateCompte(String Type) {
		
		Compte compte = new Compte();
		compte.setId(null);
		compte.setNumero(genererNumeroCompte());
		compte.setType(Type);
		compte.setDateCreation(LocalDate.now());
		compte.setSolde(0.0);
		compte.setClient(null);
		
		return compte;
		
	}

	@Override
	public String genererNumeroCompte() {
		// Générer une chaîne aléatoire de 5 caractères majuscules alphanumériques
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 5; i++) {
	        sb.append(characters.charAt(random.nextInt(characters.length())));
	    }
	    String numeroCompte = sb.toString();
	    
	    // Ajouter l'année actuelle au numéro de compte généré
	    LocalDateTime date = LocalDateTime.now();
	    int annee = date.getYear();
	    numeroCompte += annee;
	    
	    return numeroCompte;
	}

	@Override
	public Compte AddSolde(Long id, Double solde) {
		Compte cpt = getOneCompte(id);
		Double sol = cpt.getSolde();
		sol = sol + solde;
		cpt.setSolde(sol);
		return cpt;
	}

	@Override
	public Compte RetirerSolde(Long id, Double solde) {
		Compte cpt = getOneCompte(id);
		Double sol = cpt.getSolde();
		if(sol<=0)
		{
			cpt.setSolde(sol);
		}else if(sol>0)
		{
			if(sol>solde)
			{
				sol = sol - solde;
				cpt.setSolde(sol);
			}
			if(sol<solde)
			{
				cpt.setSolde(sol);
			}
		}
		return cpt;
	}

	@Override
	public Compte Virement(Long id, Double solde, Long id1) {
		Compte cpt = getOneCompte(id);
		Compte cpt1 = getOneCompte(id1);
		Double sol = cpt.getSolde();
		cpt = RetirerSolde(id,solde);
		
		if(cpt.getSolde() != sol )
		{
			
			cpt1 = AddSolde(id1, solde);
		}else {
			cpt1 =cpt1;
		}
		
		return cpt1;
	}
	
	

	

}
