package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PretDao extends JpaRepository<Pret, Long> {

    List<Pret> findAllByUtilisateurId(Long id);
}
