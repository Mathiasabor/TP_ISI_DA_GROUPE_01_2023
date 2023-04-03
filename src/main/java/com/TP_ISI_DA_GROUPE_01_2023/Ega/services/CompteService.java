package com.TP_ISI_DA_GROUPE_01_2023.Ega.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Compte;
@Service
public interface CompteService {

    public List<Compte> showCompte();
	public Compte saveCompte(Compte compte);
	public Compte getOneCompte(Long id);
	public void deleteCompte(Long id);
	public Compte CreateCompte(String Type);
	public String genererNumeroCompte();
	public Compte AddSolde(Long id, Double solde);
	public Compte RetirerSolde(Long id, Double solde);
	public Compte Virement(Long id, Double solde, Long id1);

}
