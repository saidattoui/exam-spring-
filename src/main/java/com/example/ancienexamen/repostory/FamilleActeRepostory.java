package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.FamilleActe;
import com.example.ancienexamen.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleActeRepostory extends JpaRepository<FamilleActe, Long> {
}
