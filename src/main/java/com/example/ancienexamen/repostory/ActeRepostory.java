package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Acte;
import com.example.ancienexamen.entite.Pathologie;
import com.example.ancienexamen.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeRepostory extends JpaRepository< Acte, Long> {
    Long countByPathologies(Pathologie pathologie);
}
