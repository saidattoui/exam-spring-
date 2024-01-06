package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Classe;
import com.example.ancienexamen.entite.Client;
import com.example.ancienexamen.entite.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatRepository extends JpaRepository<Plat, Integer> {

    List<Plat> findAllByClientNomAndClientPrenom(String nom, String prenom);
}
