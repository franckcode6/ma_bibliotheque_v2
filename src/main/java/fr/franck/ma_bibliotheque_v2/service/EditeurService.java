package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Editeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EditeurService {
    Page<Editeur> recupererEditeurs(Pageable pageable);

    void ajouterEditeur(String nom);

    void supprimerEditeur(Long id);
}
