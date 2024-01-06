package com.example.ancienexamen.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idActe; // Identifiant projet (Clé primaire)
    private String codeActe;
    private int cotationActe;
    private float  prixUnitaireActe;
    private String designationActe;
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
   FamilleActe familleActe;
    @ManyToMany(mappedBy = "actes")
    @ToString.Exclude
    @JsonIgnore
    private Set<Pathologie>pathologies;






}