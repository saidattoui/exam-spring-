package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Niveau;
import com.example.ancienexamen.entite.Programme;
import com.example.ancienexamen.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
 List<User> findByIdUtilisateur(Integer idUtilisateur);

 @Query("SELECT COUNT(u) FROM User u WHERE u.classe.niveau = :niveau")
 Integer nbUtilisateurParNiveau(@Param("niveau") Niveau niveau);
}
