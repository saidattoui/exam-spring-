package com.example.ancienexamen.controller;

import com.example.ancienexamen.entite.*;
import com.example.ancienexamen.service.IExamenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Tag(name = "Web Services pour la gestion de Projets")
@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ExmanController {
    IExamenService iExamenService;
    @PostMapping("/add-user")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur u) {
        Utilisateur utilisateur = iExamenService.ajouterUtilisateur(u);
        return utilisateur;
    }

    @PostMapping("/add-program-channel")
    public Programme ajouterProgrammeEtChaine(@RequestBody Programme p) {
        Programme programme = iExamenService.ajouterProgrammeEtChaine(p);
        return programme;
    }
    @PostMapping("/add-program-assign-channel/{ch-id}")
    public Programme ajouterUtilisateur(@RequestBody Programme p, @PathVariable("ch-id") Long chId) {
        Programme programme = iExamenService.ajouterProgrammeEtAffecterChaine(p, chId);
        return programme;
    }
    @PutMapping("/assign-program-user/{pr-nom}/{usr-nom}")
    public void affecterProgrammeAUtilisateur(@PathVariable("pr-nom") String prNom, @PathVariable("usr-nom") String usrNom) {

       iExamenService.affecterProgrammeAUtilisateur(prNom, usrNom);

    }
    @GetMapping("/get-users/{p}/{d}/{t}")
    public List<Utilisateur> listerUtilisateurs(@PathVariable("p") Profession p, @PathVariable("d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d, @PathVariable("t") Thematique t) {

        return iExamenService.recupererUtilisateurs(p, d, t);

    }
    @PutMapping("/unassign-program-user/{pr-nom}/{usr-nom}")
    public void desaffecterProgrammeAUtilisateur(@PathVariable("pr-nom") String prNom, @PathVariable("usr-nom") String usrNom) {

        iExamenService.desaffecterProgrammeDeUtilisateur(prNom, usrNom);

    }
    @PostMapping("/add-users")
    public User ajouterUtilisateur(@RequestBody User user) {
       User user1 = iExamenService.ajouterUtilisateur(user);
        return user1;
    }
    @PostMapping("/add-class")
    public Classe ajouterClasse(@RequestBody Classe c) {
        Classe classe = iExamenService.ajouterClasse(c);
        return classe;
    }
    @PostMapping("/add-program/{code}")
    public CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc, @PathVariable("code") Integer codeClasse) {
       CoursClassroom coursClassroom = iExamenService.ajouterCoursClassroom(cc, codeClasse);
        return coursClassroom;
    }
    @PutMapping("/assign/{idUtilisateur}/{codeClasse}")
    public void affecterUtilisateurClasse(@PathVariable("idUtilisateur") Integer idUtilisateur, @PathVariable("codeClasse") Integer codeClasse) {

        iExamenService. affecterUtilisateurClasse(idUtilisateur, codeClasse);

    }
    @GetMapping("/nb-utilisateur-par-niveau/{niveau}")
    public Integer nbUtilisateurParNiveau(@PathVariable("niveau") Niveau niveau) {
        return iExamenService.nbUtilisateursParNiveau(niveau);
    }
    @PutMapping("/unassign/{idCours}")
    public void desaffecterCoursClassroomClasse(@PathVariable("idCours") Integer idCours) {

        iExamenService.desaffecterCoursClassroomClasse(idCours);

    }
    @GetMapping("/nb-heures-par-spec-niv/{spec}/{niv}")
    public Integer nbHeuresParSpecEtNiv(@PathVariable("spec") Specialite sp, @PathVariable("niv") Niveau nv) {
        return iExamenService.nbHeuresParSpecEtNiv(sp, nv);
    }
    @PostMapping("/add-pathologie")
    public Pathologie ajouterPathologie(@RequestBody Pathologie path) {
       Pathologie pathologie = iExamenService.ajouterPathologie(path);
        return pathologie;
    }
    @PostMapping("/add-program12/{ch}")
    public Patient ajouterPatient(@RequestBody Patient p, @PathVariable("ch") String
            codePath) {
        Patient patient = iExamenService.ajouterPatientEtAffecterAPathologie(p, codePath);
        return patient;
    }
    @PostMapping("/ajouterFamilleActeEtActeAssocie")
    FamilleActe ajouterFamilleActeEtActeAssocie3(@RequestBody FamilleActe fA){
        return iExamenService.ajouterFamilleActeEtActeAssocie( fA);
    }
    @PostMapping("/Clinet")
    public Client ajouterClient(@RequestBody Client client) {
        Client client1= iExamenService.ajouterClient(client);
        return client1;
    }
    @PostMapping("/Cuisinier")
    public ResponseEntity<Void> ajouterCuisinier(@RequestBody Cuisinier cuisinier) {
      iExamenService.ajouterCuisinier(cuisinier);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/addplat/{ch-id}/{er-id}")
    public Plat ajouterPlat(@RequestBody Plat plat, @PathVariable("ch-id") Integer idClient, @PathVariable("er-id") Integer idCuisinier) {
        Plat plat1 = iExamenService.ajouterPlatAffecterClientEtCuisinier(plat, idClient, idCuisinier);
        return plat1;
    }
    @GetMapping("/AfficherListePlatsParClient/{nom}/{prenom}")
    @ResponseBody
    public List<Plat> AfficherListePlatsParClient(@PathVariable("nom") String nom , @PathVariable("prenom") String prenom) {
        return  iExamenService.afficherListePlatsParClient(nom, prenom);
    }
    @GetMapping("/montantAPayer")
    public ResponseEntity<Float> montantAPayerParClient(@RequestParam Integer idClient) {

            float montantAPayer = iExamenService.MontantApayerParClient(idClient);
            return new ResponseEntity<>(montantAPayer, HttpStatus.OK);

    }
    @PutMapping("/ModifierImc/{idClient}")
    @ResponseBody
    public void ModifierImc( @PathVariable("idClient") Integer idClient) {
        IExamenService.ModifierImc(idClient);
    }

}
