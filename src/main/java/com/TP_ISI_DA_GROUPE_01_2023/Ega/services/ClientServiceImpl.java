package com.TP_ISI_DA_GROUPE_01_2023.Ega.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Client;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Compte;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.repositories.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService {
	
    @Autowired
	private ClientRepository clientRepo;

	@Override
	public List<Client> showClient() {
		
		return clientRepo.findAll();
	}

	@Override
	public Client saveClient(Client client) {
		
		return clientRepo.save(client);
	}

	@Override
	public Client getOneClient(Long id) {
		
		return clientRepo.findById(id).get();
	}

	@Override
	public void deleteClient(Long id) {
		clientRepo.deleteById(id);

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
	public void AttribCompte(Client client, List<Compte> compte) {
		
		client.setComptes(compte);
	}
	


}
