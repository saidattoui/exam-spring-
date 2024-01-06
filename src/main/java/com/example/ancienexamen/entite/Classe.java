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
public class Classe  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeClasse; // Identifiant projet (Clé primaire)

    private String titre;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToMany(mappedBy = "classe",cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Set<CoursClassroom> coursClassrooms;

}
