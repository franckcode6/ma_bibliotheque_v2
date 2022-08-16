package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Utilisateur;
import fr.franck.ma_bibliotheque_v2.dao.UtilisateurDao;
import fr.franck.ma_bibliotheque_v2.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurDao utilisateurDao;

    @Override
    public Utilisateur recupererUtilisateur(String email, String motDePasse) {
        return utilisateurDao.findByEmailAndMotDePasse(email, motDePasse);
    }
}
