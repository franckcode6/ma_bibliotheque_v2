package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Auteur;
import fr.franck.ma_bibliotheque_v2.dao.AuteurDao;
import fr.franck.ma_bibliotheque_v2.service.AuteurService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AuteurServiceImpl implements AuteurService {

    private final AuteurDao auteurDao;

    @Override
    public Page<Auteur> recupererAuteurs(Pageable pageable) {
        return auteurDao.findAll(pageable);
    }

    @Override
    public void supprimerAuteur(Long id) {
        auteurDao.deleteById(id);
    }

    @Override
    public void ajouterAuteur(String nom, String prenom, LocalDate dateDeNaissance, String nationalite) {
        auteurDao.save(new Auteur(nom, prenom, dateDeNaissance, nationalite));
    }
}
