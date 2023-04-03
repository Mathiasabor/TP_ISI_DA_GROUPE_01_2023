package com.TP_ISI_DA_GROUPE_01_2023.Ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TP_ISI_DA_GROUPE_01_2023.Ega.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
