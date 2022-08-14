package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import fr.franck.ma_bibliotheque_v2.business.Pret;
import fr.franck.ma_bibliotheque_v2.business.Utilisateur;
import fr.franck.ma_bibliotheque_v2.dao.PretDao;
import fr.franck.ma_bibliotheque_v2.service.PretService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PretServiceImpl implements PretService {

    private final PretDao pretDao;

    @Override
    public void ajouterPret(Utilisateur utilisateur, Livre livre) {
        pretDao.save(new Pret(utilisateur, livre));
    }

    @Override
    public List<Pret> recupererPrets(Long id) {
        return pretDao.findAllByUtilisateurId(id);
    }

    @Override
    public Pret recupererPret(Long id) {
        return pretDao.findById(id).orElse(null);
    }

    @Override
    public void supprimerPret(Pret pret) {
        pretDao.delete(pret);
    }
}
