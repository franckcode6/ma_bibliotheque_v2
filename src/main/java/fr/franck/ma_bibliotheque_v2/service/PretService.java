package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import fr.franck.ma_bibliotheque_v2.business.Pret;
import fr.franck.ma_bibliotheque_v2.business.Utilisateur;

public interface PretService {
    void ajouterPret(Utilisateur utilisateur, Livre livre);
}
