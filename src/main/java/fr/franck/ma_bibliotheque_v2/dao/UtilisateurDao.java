package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
}
