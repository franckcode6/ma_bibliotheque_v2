package fr.franck.ma_bibliotheque_v2.initialisation;

import com.github.javafaker.Faker;
import fr.franck.ma_bibliotheque_v2.business.*;
import fr.franck.ma_bibliotheque_v2.dao.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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

    private List<Admin> admins;
    private List<Auteur> auteurs;
    private List<Categorie> categories;
    private List<Editeur> editeurs;
    private List<Lecteur> lecteurs;
    private List<Livre> livres;
    private List<Type> types;


    @Override
    public void run(String... args) throws Exception {
        Date dateDebut = new Date();

        //AUTEURS
        ajouterAuteurs();

        Date dateFin = new Date();
        System.out.println("Données initiales générées en " + (dateFin.getTime() - dateDebut.getTime()) + " ms");
    }

    private void ajouterAuteurs() {
        if (auteurDao.count() == 0) {
            auteurs.add(new Auteur("Werber", "Bernard", faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "France"));
            auteurs.add(new Auteur("King", "Stephen", faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "USA"));
            auteurs.add(new Auteur("Roth", "Philip", faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "USA"));
            auteurs.add(new Auteur("Asimov", "Isaac", faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "USA"));
            for (int i = 0; i < 50; i++) {
                auteurs.add(new Auteur(faker.name().lastName(), faker.name().firstName(), faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), faker.address().country()));

            }
        }
        auteurDao.saveAll(auteurs);
    }
}
