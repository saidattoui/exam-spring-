package com.example.ancienexamen.repostory;

import com.example.ancienexamen.entite.Pathologie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PathologieRepostory extends JpaRepository<Pathologie, Long> {
    List<Pathologie> findByCodePath(String codePath);
}
