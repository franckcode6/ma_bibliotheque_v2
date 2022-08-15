package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie recupererCategorie(Long id);

    List<Categorie> recupererCategories();
}
