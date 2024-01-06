package com.example.ancienexamen.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPatient; // Identifiant projet (Clé primaire)

    private String nomP;
    private String prenomP;
     private Date dateEmission;
    @Enumerated(EnumType.STRING)
    private TypePieceldentite typePieceIdentite;
    private String identifiantPieceIdentite;
    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private Set<Pathologie> pathologies;
}
