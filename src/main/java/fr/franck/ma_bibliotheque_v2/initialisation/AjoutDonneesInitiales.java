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
    private List<Auteur> auteurs;
    private List<Categorie> categories;
    private List<Editeur> editeurs;
    private List<Lecteur> lecteurs;
    private List<Livre> livres;
    private List<Type> types;


    @Override
    public void run(String... args) {
        Date dateDebut = new Date();

        //ADMIN
        ajouterAdmin();

        //AUTEURS
        ajouterAuteurs();

        //CATEGORIES
        ajouterCategories();

        //EDITEURS
        ajouterEditeurs();

        //LECTEURS
        ajouterLecteurs();

        //TYPES
        ajouterTypes();

        //LIVRES
        ajouterLivres();

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

    private void ajouterAdmin() {
        if (adminDao.count() == 0) {
            adminDao.save(new Admin(faker.name().lastName(),
                    faker.name().firstName(),
                    "admin@test@com",
                    "12345",
                    "0610111213"));
        }
    }

    private void ajouterCategories() {
        if (categorieDao.count() == 0) {
            categories.add(new Categorie("Jeunesse"));
            categories.add(new Categorie("Action"));
            categories.add(new Categorie("Litterature classique"));
            categories.add(new Categorie("Theatre"));
            categories.add(new Categorie("Science Fiction"));
            categories.add(new Categorie("Autobiographie"));
            categories.add(new Categorie("Conte"));
            categories.add(new Categorie("Drame"));
            categories.add(new Categorie("Aventure"));
            categories.add(new Categorie("Humour"));
            categories.add(new Categorie("Horreur"));
            categories.add(new Categorie("Ado"));
            categorieDao.saveAll(categories);
        }
    }

    private void ajouterEditeurs() {
        if (editeurDao.count() == 0) {
            editeurs.add(new Editeur("Albin Michel"));
            editeurs.add(new Editeur("Le livre de proche"));
            editeurs.add(new Editeur("Pocket"));
            editeurs.add(new Editeur("Glenat"));
            editeurs.add(new Editeur("Dupuis"));
            editeurs.add(new Editeur("Flammarion"));
            editeurs.add(new Editeur("Auto-edition"));
            editeurDao.saveAll(editeurs);
        }
    }

    private void ajouterLecteurs() {
        if (lecteurDao.count() == 0) {
            for (int i = 0; i < 150; i++) {
                lecteurs.add(new Lecteur(faker.name().lastName(),
                        faker.name().firstName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(),
                        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
            }
            lecteurDao.saveAll(lecteurs);
        }
    }

    private void ajouterLivres() {
        if (livreDao.count() == 0) {
            for (int i = 0; i < 500; i++) {
                livres.add(new Livre(faker.book().title(),
                        "978-" + random.nextInt(1, 9) + "-" + random.nextInt(1000, 9999) + "-" + random.nextInt(1000, 9999) + "-" + random.nextInt(1, 9),
                        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        auteurs.get(random.nextInt(auteurs.size())),
                        categories.get(random.nextInt(categories.size())),
                        editeurs.get(random.nextInt(editeurs.size())),
                        types.get(random.nextInt(types.size()))));
            }
            livreDao.saveAll(livres);
        }
    }

    private void ajouterTypes() {
        if (typeDao.count() == 0) {
            types.add(new Type("BD"));
            types.add(new Type("Poche"));
            types.add(new Type("Broche"));
            types.add(new Type("Relie"));
            types.add(new Type("Autre"));
            types.add(new Type("Revue"));
            typeDao.saveAll(types);
        }
    }
}
