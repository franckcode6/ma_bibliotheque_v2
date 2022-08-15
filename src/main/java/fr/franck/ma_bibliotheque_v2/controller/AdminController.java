package fr.franck.ma_bibliotheque_v2.controller;

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
    private final EditeurService editeurService;
    private final LecteurService lecteurService;
    private final LivreService livreService;
    private final PretService pretService;

    @GetMapping("admin/lecteurs")
    public ModelAndView lecteursGet(@PageableDefault(size = NB_ELEMENTS_PAR_PAGE)
                                    Pageable pageable) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("listeDesLecteurs");
        mav.addObject("pageDeLecteurs", lecteurService.recupererLecteurs(pageable));

        return mav;
    }

    @GetMapping("admin/lecteur/supprimer")
    public ModelAndView supprimerLecteurGet(@RequestParam(name = "id", required = true) Long id) {

        lecteurService.supprimerLecteur(id);

        return new ModelAndView("redirect:/admin/lecteurs");
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

    @GetMapping("admin/editeur/supprimer")
    public ModelAndView supprimerEditeurGet(@RequestParam(name = "id", required = true) Long id) {

        editeurService.supprimerEditeur(id);

        return new ModelAndView("redirect:/admin/editeurs");
    }
}
