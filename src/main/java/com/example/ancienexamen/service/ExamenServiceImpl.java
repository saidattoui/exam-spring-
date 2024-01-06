package com.example.ancienexamen.service;

import com.example.ancienexamen.entite.*;
import com.example.ancienexamen.repostory.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class ExamenServiceImpl implements IExamenService {
    UtilisateurRepository utilisateurRepository;
    ProgrammeRepository programmeRepository;
    ChaineRepository chaineRepository;
    ClasseRepository classeRepository;
    UserRepository userRepository;
    CoursClassroomRepository coursClassroomRepository;
    ActeRepostory acteRepostory;
    PathologieRepostory pathologieRepostory;
    FamilleActeRepostory familleActeRepostory;
    PatientRepostory patientRepostory;
    ClientRepostory clientRepostory;
    PlatRepository platRepository;
    CuisinierRepostory cuisinierRepostory;

    public Utilisateur ajouterUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);

    }

    public Programme ajouterProgrammeEtChaine(Programme p) {

        return programmeRepository.save(p);
    }

    @Override
    public Programme ajouterProgrammeEtAffecterChaine(Programme p, Long chId) {
        Chaine chaine = chaineRepository.findById(chId).get();
        p.setChaines(chaine);
        return programmeRepository.save(p);
    }

    @Override
    public void affecterProgrammeAUtilisateur(String prNom, String usrNom) {
        Programme programme = programmeRepository.findByPrNom(prNom).get(0);
        Utilisateur utilisateur = utilisateurRepository.findByUsrNom(usrNom).get(0);
        utilisateur.getProgrammes().add(programme);
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> recupererUtilisateurs(Profession p, Date d, Thematique t) {
        return utilisateurRepository.listerUtilisateurs(p, d, t);
    }

    @Override
    public void desaffecterProgrammeDeUtilisateur(String prNom, String usrNom) {
        Programme p = programmeRepository.findAllByPrNom(prNom).get(0);
        Utilisateur u = utilisateurRepository.findAllByUsrNom(usrNom).get(0);

        u.getProgrammes().remove(p);

        utilisateurRepository.save(u);


    }

    @Scheduled(fixedDelay = 20000)
    public void ordonnerChaines() {

        List<Object[]> l = chaineRepository.listerchaines();

        for (Object[] obj : l) {
            Chaine chaine = (Chaine) obj[0];
            Long nbre = (Long) obj[1];
            log.info("Chaine : " + chaine.getChNom() + ".  Nombre de fois où les programmes de cette Chaine sont marqués comme favoris  : " + nbre);
        }

    }

    @Override
    public User ajouterUtilisateur(User user) {
        return userRepository.save(user);
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepository.save(c);
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe classe = classeRepository.findByCodeClasse(codeClasse).get(0);
        cc.setClasse(classe);
        return coursClassroomRepository.save(cc);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        User user = userRepository.findByIdUtilisateur(idUtilisateur).get(0);
        Classe classe = classeRepository.findByCodeClasse(codeClasse).get(0);
        // Affecter la classe à l'utilisateur
        user.setClasse(classe);
        userRepository.save(user);
    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        return userRepository.nbUtilisateurParNiveau(nv);
    }

    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom cc = coursClassroomRepository.findAllByIdCours(idCours).get(0);
        cc.setClasse(null);
        coursClassroomRepository.save(cc);


    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        return coursClassroomRepository.nbHeuresParSpecialiteEtdNiveau(sp, nv);
    }


    @Scheduled(fixedDelay = 60000)
    public void archiverCoursClassrooms() {
        log.info("La méthode archiverCoursClassrooms a été déclenchée.");

        List<CoursClassroom> ccs = coursClassroomRepository.findAll();
        for (CoursClassroom coursClassroom : ccs) {
            coursClassroom.setArchive(true);
            coursClassroomRepository.save(coursClassroom);
            log.info("Cours archivé : nom={}", coursClassroom.getNom());
        }
    }

    @Override
    public Pathologie ajouterPathologie(Pathologie path) {
        // par defaut archive false
        path.setArchive(false);
        return pathologieRepostory.save(path);
    }

    @Override
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath) {
        Pathologie pathologie = pathologieRepostory.findByCodePath(codePath).get(0);
        p.setPathologies(new HashSet<>());
        return patientRepostory.save(p);
    }

    @Override
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe fA) {
        FamilleActe f = familleActeRepostory.save(fA);
        Set<Acte> actes = f.getActes();
        actes.stream().forEach(acte -> {
            acte.setFamilleActe(f);
            acteRepostory.save(acte);
        });
        return f;
    }



    @Scheduled(fixedDelay = 30000)
    public void calculerNombreActesParPathologie(){

        List<Pathologie> c = pathologieRepostory.findAll();
        for (Pathologie pathologie : c) {
            Long nombreActes = acteRepostory.countByPathologies(pathologie);
            log.info("Pathologie : " + pathologie.getLibelle() + ". Nombre d'actes : " + nombreActes);
        }
    }

    @Override
    public Client ajouterClient(Client client) {
        return clientRepostory.save(client);
    }

    @Override
    public void ajouterCuisinier(Cuisinier cuisinier) {
        cuisinierRepostory.save(cuisinier);
    }

    @Override

    public Plat ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier) {
        // Récupérer le client et le cuisinier par leurs identifiants
        Client client = clientRepostory.findByIdClient(idClient).get(0);
        Cuisinier cuisinier = cuisinierRepostory.findByIdCuisinier(idCuisinier).get(0);

        // Associer le plat au client et au cuisinier
        plat.setClient(client);
        plat.getCuisiniers().add(cuisinier);

        // Enregistrer le plat dans la base de données
        return platRepository.save(plat);
    }

    @Override
    public List<Plat> afficherListePlatsParClient(String nom, String prenom) {

        return platRepository.findAllByClientNomAndClientPrenom(nom, prenom);
    }

    @Override
    public float MontantApayerParClient(Integer idClient) {
        // Récupérer le client par son identifiant
        Client client = clientRepostory.findById(idClient).orElse(null);

        if (client != null) {
            // Récupérer les plats associés au client
            Set<Plat> platsDuClient = client.getPlats();

            // Calculer le montant total
            float montantTotal = 0.0f;

            for (Plat plat : platsDuClient) {
                // Ajouter le prix de chaque plat au montant total
                montantTotal += plat.getPrix();
            }

            return montantTotal;
        } else {
            // Gérer le cas où le client n'est pas trouvé
            throw new EntityNotFoundException("Client introuvable avec l'identifiant : " + idClient);
        }
    }
    public void ModifierImc(Integer idClient) {
        Client client = clientRepostory.findById(idClient).orElse(null);
        List<Plat> plats = platRepository.findAllByClientNomAndClientPrenom(client.getNom() , client.getPrenom()) ;
        float sumCalories = 0 ;
        for (int i = 0 ; i< plats.size()  ; i++)  {
            sumCalories+= plats.get(i).getCalories() ;
        }
        if(sumCalories < 2000) {
            client.setImc(Imc.FAIBLE);
        }
        else if (sumCalories == 2000) {
            client.setImc(Imc.IDEAL);

        }
        else if (sumCalories > 2000) {
            client.setImc(Imc.FORT);

        }

        clientRepostory.save(client);
        log.info("imc est modifié " + sumCalories/plats.size());
    }



}











