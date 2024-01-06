package com.example.ancienexamen.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Plat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlat; // Identifiant projet (Clé primaire)

    private String label;
    private Float prix;
    private Float calories;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Client client;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Cuisinier> cuisiniers =new HashSet<>() ;



}
