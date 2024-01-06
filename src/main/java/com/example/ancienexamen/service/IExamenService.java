package com.example.ancienexamen.service;

import com.example.ancienexamen.entite.*;

import java.util.Date;
import java.util.List;

public interface IExamenService {
    public Utilisateur ajouterUtilisateur(Utilisateur u);
    public Programme ajouterProgrammeEtChaine(Programme p);
    public Programme ajouterProgrammeEtAffecterChaine (Programme p, Long chId);
    public void affecterProgrammeAUtilisateur (String prNom, String usrNom);
    public List<Utilisateur> recupererUtilisateurs(Profession p, Date d, Thematique t);
    public void desaffecterProgrammeDeUtilisateur(String prNom, String usrNom);
    public User ajouterUtilisateur (User user);
    public Classe ajouterClasse (Classe c);
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);
    public Integer nbUtilisateursParNiveau(Niveau nv);
    public void desaffecterCoursClassroomClasse(Integer idCours);
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);
    public Pathologie ajouterPathologie(Pathologie path);
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String
            codePath);
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe fA);
    public Client ajouterClient(Client client);
    public void ajouterCuisinier (Cuisinier cuisinier);
    public Plat ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier);
    List<Plat> afficherListePlatsParClient (String nom,String prenom);
    public float MontantApayerParClient(Integer idClient) ;

    public static void ModifierImc(Integer idClient) {

    }
}
