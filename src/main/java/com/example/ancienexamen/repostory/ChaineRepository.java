package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Chaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ChaineRepository extends JpaRepository<Chaine, Long> {
    @Query("SELECT p.chaines, count(p) AS cp FROM Programme p " +
            "INNER JOIN p.utilisateurs u " +
            "WHERE u.usrId IS NOT NULL " +
            "GROUP BY p.chaines ORDER BY cp DESC")
    List<Object[]> listerchaines();
}
