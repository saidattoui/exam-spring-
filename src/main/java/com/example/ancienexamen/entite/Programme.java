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

public class Programme  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prId; // Identifiant projet (Clé primaire)

    private String prNom;
   @ManyToMany(mappedBy = "programmes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)


   @ToString.Exclude
   private Set<Utilisateur>utilisateurs;
@ManyToOne(cascade = CascadeType.ALL)

@ToString.Exclude
   private Chaine chaines;


}
