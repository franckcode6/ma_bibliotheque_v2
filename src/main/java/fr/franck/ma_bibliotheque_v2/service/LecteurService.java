package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Lecteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface LecteurService {
    Lecteur recupererLecteur(Long id);

    Page<Lecteur> recupererLecteurs(Pageable pageable);

    void ajouterLecteur(String nom, String prenom, String email, String mdp, LocalDate date);

    void supprimerLecteur(Long id);

}
