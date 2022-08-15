package fr.franck.ma_bibliotheque_v2.service.impl;

import fr.franck.ma_bibliotheque_v2.business.Type;
import fr.franck.ma_bibliotheque_v2.dao.TypeDao;
import fr.franck.ma_bibliotheque_v2.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeDao typeDao;

    @Override
    public List<Type> recupererTypes() {
        return typeDao.findAll();
    }
}
