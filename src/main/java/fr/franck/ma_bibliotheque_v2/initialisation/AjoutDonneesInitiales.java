package fr.franck.ma_bibliotheque_v2.initialisation;

import com.github.javafaker.Faker;
import fr.franck.ma_bibliotheque_v2.dao.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    private final Faker faker = new Faker(new Locale("fr-FR"));

    private static final Random random = new Random();

    private final AdminDao adminDao;
    private final AuteurDao auteurDao;
    private final CategorieDao categorieDao;
    private final EditeurDao editeurDao;
    private final LecteurDao lecteurDao;
    private final LivreDao livreDao;
    private final TypeDao typeDao;


    @Override
    public void run(String... args) throws Exception {

    }
}
