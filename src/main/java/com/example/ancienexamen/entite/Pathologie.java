package com.example.ancienexamen.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pathologie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPath; // Identifiant projet (Clé primaire)
    private String codePath;
    private String libelle;
    private String  description;
    private Boolean archive;
    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private Set<Acte> actes;
}
