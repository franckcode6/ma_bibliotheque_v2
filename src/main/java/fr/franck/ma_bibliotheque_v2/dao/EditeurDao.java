package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Editeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurDao extends JpaRepository<Editeur, Long> {
}
