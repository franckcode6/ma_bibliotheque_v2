package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LivreService {
    List<Livre> recupererLivres();

    Page<Livre> recupererLivres(Pageable pageable);
}
