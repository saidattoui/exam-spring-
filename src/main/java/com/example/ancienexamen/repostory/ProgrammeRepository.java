package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
    List<Programme> findByPrNom(String prNom);
    List<Programme> findAllByPrNom(String prNom);
}
