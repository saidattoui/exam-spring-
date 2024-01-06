package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Categorie;
import com.example.ancienexamen.entite.Classe;
import com.example.ancienexamen.entite.Cuisinier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CuisinierRepostory extends JpaRepository<Cuisinier, Integer> {
 List<Cuisinier> findByIdCuisinier(Integer idCuisinier);
    @Query("SELECT c FROM Cuisinier c WHERE SIZE(c.plats) >= 2 AND c.plats IS NOT EMPTY")
    List<Cuisinier> findByPlatPrincipalCountGreaterThanOrEqual(int count);

    List<Cuisinier> findAllByPlatsCategorie(Categorie principal);
}
