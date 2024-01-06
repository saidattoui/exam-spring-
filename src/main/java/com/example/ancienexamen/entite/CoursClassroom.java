package com.example.ancienexamen.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoursClassroom  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours; // Identifiant projet (Clé primaire)

    private String nom;
    private  Integer nbHeures;
    private  boolean archive;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private  Classe classe;
}
