package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Livre;
import fr.franck.ma_bibliotheque_v2.dao.LivreDao;
import fr.franck.ma_bibliotheque_v2.service.LivreService;
import lombok.AllArgsConstructor;
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
}
