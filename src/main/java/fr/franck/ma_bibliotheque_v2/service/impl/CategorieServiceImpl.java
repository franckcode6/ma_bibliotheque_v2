package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Categorie;
import fr.franck.ma_bibliotheque_v2.dao.CategorieDao;
import fr.franck.ma_bibliotheque_v2.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private final CategorieDao categorieDao;

    @Override
    public Categorie recupererCategorie(Long id) {
        return categorieDao.findById(id).orElse(null);
    }

    @Override
    public List<Categorie> recupererCategories() {
        return categorieDao.findAll();
    }
}
