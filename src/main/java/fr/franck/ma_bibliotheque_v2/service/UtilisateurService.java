package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Utilisateur;

public interface UtilisateurService {
    Utilisateur recupererUtilisateur(String email, String motDePasse);
}
