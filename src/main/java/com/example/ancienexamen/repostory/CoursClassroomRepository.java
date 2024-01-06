package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.CoursClassroom;
import com.example.ancienexamen.entite.Niveau;
import com.example.ancienexamen.entite.Programme;
import com.example.ancienexamen.entite.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursClassroomRepository extends JpaRepository<CoursClassroom, Integer> {
   List<CoursClassroom> findAllByIdCours(Integer idCours) ;
   @Query("SELECT SUM(cc.nbHeures) FROM CoursClassroom cc WHERE cc.specialite =:specialite AND cc.classe.niveau = :niveau")
   Integer nbHeuresParSpecialiteEtdNiveau(@Param("specialite") Specialite specialite, @Param("niveau") Niveau niveau);
}
