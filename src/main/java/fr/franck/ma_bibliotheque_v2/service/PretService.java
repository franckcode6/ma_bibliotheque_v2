package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import fr.franck.ma_bibliotheque_v2.business.Pret;
import fr.franck.ma_bibliotheque_v2.business.Utilisateur;

import java.util.List;

public interface PretService {

    void ajouterPret(Utilisateur utilisateur, Livre livre);

    List<Pret> recupererPrets(Long id);

    List<Pret> recupererPrets(List<Long> ids);

    Pret recupererPret(Long id);

    void supprimerPret(Pret pret);

}
