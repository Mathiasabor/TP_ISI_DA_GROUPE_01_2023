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

import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Client;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Compte;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.services.ClientService;
import com.TP_ISI_DA_GROUPE_01_2023.Ega.services.CompteService;

@RestController
public class ClientRestController {

    @Autowired
    private ClientService clientServ;

    @Autowired
    private CompteService compteServ;
    @GetMapping("/clients")
    public List<Client> listeClient()
    {
        return clientServ.showClient();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id)
    {
        return clientServ.getOneClient(id);
    }

    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client)
    {
        return clientServ.saveClient(client);
    }

    @PutMapping("/client/{id}")
    public Client AddCompte(Long id,@RequestBody Client client)
    {
        Compte cmpt = compteServ.getOneCompte(id);
        client = client.AddComptes(client,cmpt);
        return clientServ.saveClient(client);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable Long id, Client client)
    {
        client.setId(id);
        return clientServ.saveClient(client);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable Long id)
    {
        clientServ.deleteClient(id);
    }



}
