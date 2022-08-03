package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Lecteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecteurDao extends JpaRepository<Lecteur, Long> {
}
