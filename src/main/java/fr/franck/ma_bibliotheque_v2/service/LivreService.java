package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Livre;

import java.util.List;

public interface LivreService {
    List<Livre> recupererLivres();
}
