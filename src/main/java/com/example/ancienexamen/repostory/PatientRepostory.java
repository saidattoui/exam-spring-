package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Patient;
import com.example.ancienexamen.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepostory extends JpaRepository<Patient, Long> {
}
