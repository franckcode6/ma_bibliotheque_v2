package fr.franck.ma_bibliotheque_v2.controller;

import fr.franck.ma_bibliotheque_v2.business.Auteur;
import fr.franck.ma_bibliotheque_v2.business.Categorie;
import fr.franck.ma_bibliotheque_v2.business.Editeur;
import fr.franck.ma_bibliotheque_v2.business.Type;
import fr.franck.ma_bibliotheque_v2.service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class AdminController {

    private final static int NB_ELEMENTS_PAR_PAGE = 20;

    private final AuteurService auteurService;
    private final CategorieService categorieService;
    private final EditeurService editeurService;
    private final LecteurService lecteurService;
    private final LivreService livreService;
    private final PretService pretService;
    private final TypeService typeService;

    @GetMapping("admin/lecteurs")
    public ModelAndView lecteursGet(@PageableDefault(size = NB_ELEMENTS_PAR_PAGE)
                                    Pageable pageable) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("listeDesLecteurs");
        mav.addObject("pageDeLecteurs", lecteurService.recupererLecteurs(pageable));

        return mav;
    }

    @GetMapping("admin/lecteurs/ajouter")
    public ModelAndView lecteursAjouterGet() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("lecteurAjout");

        return mav;
    }

    @PostMapping("admin/lecteurs/ajouter")
    public ModelAndView lecteursAjouterPost(@RequestParam(name = "NOM") String nom,
                                            @RequestParam(name = "PRENOM") String prenom,
                                            @RequestParam(name = "EMAIL") String email,
                                            @RequestParam(name = "MDP") String mdp,
                                            @RequestParam(name = "DATE_NAISSANCE") String dateDeNaissance) {

        LocalDate date = LocalDate.parse(dateDeNaissance);

        lecteurService.ajouterLecteur(nom, prenom, email, mdp, date);

        return new ModelAndView("redirect:/admin/lecteurs");
    }

    @GetMapping("admin/lecteur/supprimer")
    public ModelAndView supprimerLecteurGet(@RequestParam(name = "id", required = true) Long id) {

        lecteurService.supprimerLecteur(id);

        return new ModelAndView("redirect:/admin/lecteurs");
    }

    @GetMapping("admin/livres/ajouter")
    public ModelAndView livresAjouterGet() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("auteurs", auteurService.recupererAuteurs());
        mav.addObject("editeurs", editeurService.recupererEditeurs());
        mav.addObject("categories", categorieService.recupererCategories());
        mav.addObject("types", typeService.recupererTypes());
        mav.setViewName("livreAjout");

        return mav;
    }

    @PostMapping("admin/livres/ajouter")
    public ModelAndView livresAjouterPost(@RequestParam(name = "TITRE") String titre,
                                          @RequestParam(name = "ISBN") String isbn,
                                          @RequestParam(name = "DATE_PARUTION") String dateDeParution,
                                          @RequestParam(name = "AUTEUR_ID") Long auteurID,
                                          @RequestParam(name = "EDITEUR_ID") Long editeurId,
                                          @RequestParam(name = "CATEGORIE_ID") Long categorieId,
                                          @RequestParam(name = "TYPE_ID") Long typeId) {

        LocalDate date = LocalDate.parse(dateDeParution);

        Auteur auteur = auteurService.recupererAuteur(auteurID);
        Editeur editeur = editeurService.recupererEditeur(editeurId);
        Categorie categorie = categorieService.recupererCategorie(categorieId);
        Type type = typeService.recupererType(typeId);

        livreService.ajouterLivre(titre, isbn, date, auteur, editeur, categorie, type);

        return new ModelAndView("redirect:/livres");
    }

    @GetMapping("admin/livres/supprimer")
    public ModelAndView supprimerLivresGet(@RequestParam(name = "id", required = true) Long id) {

        livreService.supprimerLivre(id);

        return new ModelAndView("redirect:/livres");
    }

    @GetMapping("admin/auteurs")
    public ModelAndView auteursGet(@PageableDefault(size = NB_ELEMENTS_PAR_PAGE)
                                   Pageable pageable) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("listeDesAuteurs");
        mav.addObject("pageDAuteurs", auteurService.recupererAuteurs(pageable));

        return mav;
    }

    @GetMapping("admin/auteurs/ajouter")
    public ModelAndView auteursAjouterGet() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("auteurAjout");

        return mav;
    }

    @PostMapping("admin/auteurs/ajouter")
    public ModelAndView auteursAjouterPost(@RequestParam(name = "NOM") String nom,
                                           @RequestParam(name = "PRENOM") String prenom,
                                           @RequestParam(name = "DATE_NAISSANCE") String dateDeNaissance,
                                           @RequestParam(name = "NATIONALITE") String nationalite) {

        LocalDate date = LocalDate.parse(dateDeNaissance);

        auteurService.ajouterAuteur(nom, prenom, date, nationalite);

        return new ModelAndView("redirect:/admin/auteurs");
    }

    @GetMapping("admin/auteur/supprimer")
    public ModelAndView supprimerAuteurGet(@RequestParam(name = "id", required = true) Long id) {

        auteurService.supprimerAuteur(id);

        return new ModelAndView("redirect:/admin/auteurs");
    }

    @GetMapping("admin/editeurs")
    public ModelAndView editeursGet(@PageableDefault(size = NB_ELEMENTS_PAR_PAGE)
                                    Pageable pageable) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("listeDesEditeurs");
        mav.addObject("pageDEditeurs", editeurService.recupererEditeurs(pageable));

        return mav;
    }

    @GetMapping("admin/editeurs/ajouter")
    public ModelAndView editeursAjouterGet() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("editeurAjout");

        return mav;
    }

    @PostMapping("admin/editeurs/ajouter")
    public ModelAndView editeursAjouterPost(@RequestParam(name = "NOM") String nom) {

        editeurService.ajouterEditeur(nom);

        return new ModelAndView("redirect:/admin/editeurs");
    }

    @GetMapping("admin/editeur/supprimer")
    public ModelAndView supprimerEditeurGet(@RequestParam(name = "id", required = true) Long id) {

        editeurService.supprimerEditeur(id);

        return new ModelAndView("redirect:/admin/editeurs");
    }
}
