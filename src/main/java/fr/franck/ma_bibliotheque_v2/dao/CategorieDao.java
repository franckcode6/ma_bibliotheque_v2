package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieDao extends JpaRepository<Categorie, Long> {
}
