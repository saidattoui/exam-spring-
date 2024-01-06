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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient; // Identifiant projet (Clé primaire)

    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Imc imc;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Plat> plats;
}
