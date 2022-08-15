package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface LivreService {
    Page<Livre> recupererLivres(Pageable pageable);

    Livre recupererLivre(Long id);

    void ajouterLivre(String titre,
                      String isbn,
                      LocalDate dateDeParution,
                      Auteur auteur,
                      Editeur editeur,
                      Categorie categorie,
                      Type type);
}
