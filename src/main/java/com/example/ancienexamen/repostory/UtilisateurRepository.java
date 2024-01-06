package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Niveau;
import com.example.ancienexamen.entite.Profession;
import com.example.ancienexamen.entite.Thematique;
import com.example.ancienexamen.entite.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
   List<Utilisateur> findByUsrNom(String usrNom) ;
   List<Utilisateur> findAllByUsrNom(String usrNom);
   @Query("SELECT distinct (u) FROM Utilisateur u " +
           "INNER JOIN u.programmes p " +
           "WHERE u.profession=:p " +
           "AND u.usrDateInscription >= :d " +
           "AND p.chaines.chTheme = :t")
   List<Utilisateur> listerUtilisateurs(@Param("p") Profession p, @Param("d") Date d, @Param("t") Thematique t);


}
