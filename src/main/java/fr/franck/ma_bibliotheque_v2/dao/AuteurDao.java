package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurDao extends JpaRepository<Auteur, Long> {
}
