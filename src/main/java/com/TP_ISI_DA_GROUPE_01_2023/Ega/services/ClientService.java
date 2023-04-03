package com.TP_ISI_DA_GROUPE_01_2023.Ega.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Client;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Compte;
@Service
public interface ClientService {

    public List<Client> showClient();
	public Client saveClient(Client client);
	public Client getOneClient(Long id);
	public void deleteClient(Long id);
	public void AttribCompte(Client client,List<Compte> compte);
	
	//fonction pour la creation du compte
	public String genererNumeroCompte();

}
