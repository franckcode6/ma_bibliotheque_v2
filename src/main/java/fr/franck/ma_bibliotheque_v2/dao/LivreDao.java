package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreDao extends JpaRepository<Livre, Long> {
}
