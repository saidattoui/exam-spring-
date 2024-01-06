package com.example.ancienexamen.entite;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chaine  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chId; // Identifiant projet (Clé primaire)

    private String chNom;
    @Enumerated(EnumType.STRING)
    private Thematique chTheme;

}
