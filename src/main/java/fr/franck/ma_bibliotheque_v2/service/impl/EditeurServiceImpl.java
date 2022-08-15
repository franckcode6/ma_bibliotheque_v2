package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Editeur;
import fr.franck.ma_bibliotheque_v2.dao.EditeurDao;
import fr.franck.ma_bibliotheque_v2.service.EditeurService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditeurServiceImpl implements EditeurService {

    private final EditeurDao editeurDao;

    @Override
    public Page<Editeur> recupererEditeurs(Pageable pageable) {
        return editeurDao.findAll(pageable);
    }

    @Override
    public void supprimerEditeur(Long id) {
        editeurDao.deleteById(id);
    }
}
