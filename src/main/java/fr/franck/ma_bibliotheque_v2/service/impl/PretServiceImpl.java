package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import fr.franck.ma_bibliotheque_v2.business.Pret;
import fr.franck.ma_bibliotheque_v2.business.Utilisateur;
import fr.franck.ma_bibliotheque_v2.dao.PretDao;
import fr.franck.ma_bibliotheque_v2.service.PretService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PretServiceImpl implements PretService {

    private final PretDao pretDao;

    @Override
    public void ajouterPret(Utilisateur utilisateur, Livre livre) {
        pretDao.save(new Pret(utilisateur, livre));
    }
}
