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

public class Utilisateur  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrId; // Identifiant projet (Clé primaire)

    private String usrNom;
    private Date usrDateInscription;

    @Enumerated(EnumType.STRING)
    private Profession profession;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private Set<Programme>programmes;
}
