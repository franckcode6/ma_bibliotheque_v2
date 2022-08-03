package fr.franck.ma_bibliotheque_v2.dao;

import fr.franck.ma_bibliotheque_v2.business.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDao extends JpaRepository<Type, Long> {
}
