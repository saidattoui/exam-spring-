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
public class Cuisinier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuisinier; // Identifiant projet (Clé primaire)

    private String nom;
    private String Prenom;
   @ManyToMany(mappedBy = "cuisiniers",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JsonIgnore
   @ToString.Exclude
    private Set<Plat> plats;
}
