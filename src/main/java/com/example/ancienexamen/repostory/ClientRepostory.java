package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Classe;
import com.example.ancienexamen.entite.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface ClientRepostory extends JpaRepository<Client, Integer> {
    List<Client> findByIdClient(Integer idClient);


    List<Client> findByNomAndPrenom(String nom, String prenom);}
