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
public class FamilleActe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFA; // Identifiant projet (Clé primaire)
    private String codeFA;
    private String libelle;
    private String  description;
    @OneToMany(mappedBy = "familleActe", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Set<Acte>actes;

}
