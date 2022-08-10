package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import fr.franck.ma_bibliotheque_v2.dao.LivreDao;
import fr.franck.ma_bibliotheque_v2.service.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LivreServiceImpl implements LivreService {

    private final LivreDao livreDao;

    @Override
    public List<Livre> recupererLivres() {
        return livreDao.findAll();
    }

    @Override
    public Page<Livre> recupererLivres(Pageable pageable) {
        return livreDao.findAll(pageable);
    }

    @Override
    public Livre recupererLivre(Long id) {

        return livreDao.findById(id).orElse(null);
    }
}
