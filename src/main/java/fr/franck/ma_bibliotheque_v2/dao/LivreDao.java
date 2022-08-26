package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreDao extends JpaRepository<Livre, Long> {
    List<Livre> findAllByTitreContaining(String titre);

    List<Livre> findAllByAuteurNomContaining(String auteur);

    List<Livre> findAllByEditeurNomContaining(String editeur);

    List<Livre> findAllByCategorieNomContaining(String categorie);

    List<Livre> findAllByTypeNomContaining(String type);
}
