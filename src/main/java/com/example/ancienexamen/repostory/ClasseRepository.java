package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Classe;
import com.example.ancienexamen.entite.Programme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
   List<Classe> findByCodeClasse(Integer codeClasse) ;

}
