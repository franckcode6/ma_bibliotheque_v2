package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Auteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuteurService {
    Page<Auteur> recupererAuteurs(Pageable pageable);

    void supprimerAuteur(Long id);
}
