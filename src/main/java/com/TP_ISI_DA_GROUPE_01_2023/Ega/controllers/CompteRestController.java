package com.TP_ISI_DA_GROUPE_01_2023.Ega.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Compte;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.services.CompteService;
@RestController
public class CompteRestController {


    @Autowired
    private CompteService compteServ;




    @GetMapping("/comptes")
    public List<Compte> listeCompte()
    {
        return compteServ.showCompte();
    }

    @GetMapping("/comptes/{id}")
    public Compte getCompte(@PathVariable Long id)
    {
        return compteServ.getOneCompte(id);
    }

    @PostMapping("/comptes")
    public Compte saveCompte(@RequestBody Compte compte)
    {
        return compteServ.saveCompte(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte updateCompte(@PathVariable Long id, Compte compte)
    {
        compte.setId(id);
        return compteServ.saveCompte(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void deleteCompte(@PathVariable Long id)
    {
        compteServ.deleteCompte(id);
    }

    @PutMapping("retirer/{id}/{solde}")
    public Compte retirer(@PathVariable Long id, @PathVariable Double solde)
    {
        Compte cpte = compteServ.RetirerSolde(id, solde);
        return compteServ.saveCompte(cpte);
    }

    @PutMapping("virer/{id}/{montant}/{id1}")

    public Compte virer(@PathVariable Long id, @PathVariable Double montant, @PathVariable Long id1)
    {
        Compte cpte = compteServ.Virement(id,montant,id1);
        return compteServ.saveCompte(cpte);
    }
    @PutMapping("ajouter/{id}/{solde}")
    public Compte Ajouter(@PathVariable Long id, @PathVariable Double solde)
    {
        Compte cpte = compteServ.AddSolde(id, solde);
        return compteServ.saveCompte(cpte);
    }

    @PostMapping("creer/{Type}")
    public Compte creerCompte(@PathVariable String Type)
    {
        Compte cpte = compteServ.CreateCompte(Type);

        return compteServ.saveCompte(cpte);
    }

}
