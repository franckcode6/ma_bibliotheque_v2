package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Lecteur;
import fr.franck.ma_bibliotheque_v2.dao.LecteurDao;
import fr.franck.ma_bibliotheque_v2.service.LecteurService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LecteurServiceImpl implements LecteurService {

    private final LecteurDao lecteurDao;

    @Override
    public Lecteur recupererLecteur(Long id) {
        return lecteurDao.findById(id).orElse(null);
    }

    @Override
    public Page<Lecteur> recupererLecteurs(Pageable pageable) {
        return lecteurDao.findAll(pageable);
    }

    @Override
    public void ajouterLecteur(String nom, String prenom, String email, String mdp, LocalDate date) {
        lecteurDao.save(new Lecteur(nom, prenom, email, mdp, date));
    }

    @Override
    public void supprimerLecteur(Long id) {
        lecteurDao.deleteById(id);
    }
}
