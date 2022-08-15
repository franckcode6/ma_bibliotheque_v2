package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Auteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface AuteurService {
    List<Auteur> recupererAuteurs();

    Page<Auteur> recupererAuteurs(Pageable pageable);

    void supprimerAuteur(Long id);

    void ajouterAuteur(String nom, String prenom, LocalDate dateDeNaissance, String nationalite);
}
