package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.*;
import fr.franck.ma_bibliotheque_v2.dao.LivreDao;
import fr.franck.ma_bibliotheque_v2.service.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LivreServiceImpl implements LivreService {

    private final LivreDao livreDao;

    @Override
    public List<Livre> recupererLivres() {
        return livreDao.findAll();
    }

    @Override
    public Page<Livre> recupererLivres(Pageable pageable) {
        return livreDao.findAll(pageable);
    }

    @Override
    public Livre recupererLivre(Long id) {

        return livreDao.findById(id).orElse(null);
    }

    @Override
    public void ajouterLivre(String titre,
                             String isbn,
                             LocalDate dateDeParution,
                             Auteur auteur,
                             Editeur editeur,
                             Categorie categorie,
                             Type type) {
        livreDao.save(new Livre(titre, isbn, dateDeParution, auteur, editeur, categorie, type));
    }

    @Override
    public void supprimerLivre(Long id) {
        livreDao.deleteById(id);
    }

    @Override
    public List<Livre> recupererLivresParTitre(String titre) {
        return livreDao.findAllByTitreContaining(titre);
    }

    @Override
    public List<Livre> recupererLivresParAuteur(String auteur) {
        return livreDao.findAllByAuteurNomContaining(auteur);
    }
}
