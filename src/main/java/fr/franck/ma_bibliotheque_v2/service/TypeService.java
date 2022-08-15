package fr.franck.ma_bibliotheque_v2.service;

import fr.franck.ma_bibliotheque_v2.business.Type;

import java.util.List;

public interface TypeService {
    Type recupererType(Long id);

    List<Type> recupererTypes();
}
