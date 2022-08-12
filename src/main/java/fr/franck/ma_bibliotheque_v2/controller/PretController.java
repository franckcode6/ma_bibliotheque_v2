package fr.franck.ma_bibliotheque_v2.controller;

import fr.franck.ma_bibliotheque_v2.business.Lecteur;
import fr.franck.ma_bibliotheque_v2.business.Livre;
import fr.franck.ma_bibliotheque_v2.business.Pret;
import fr.franck.ma_bibliotheque_v2.service.LecteurService;
import fr.franck.ma_bibliotheque_v2.service.LivreService;
import fr.franck.ma_bibliotheque_v2.service.PretService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class PretController {

    private final LecteurService lecteurService;
    private final LivreService livreService;
    private final PretService pretService;

    @GetMapping("pret")
    public ModelAndView pretGet() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("pret");

        return mav;
    }

    @GetMapping("pret/lecteur")
    public ModelAndView pretLecteurGet(@RequestParam(name = "id") Long id) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("lecteur", lecteurService.recupererLecteur(id));
        mav.setViewName("pretLecteur");

        return mav;
    }

    @PostMapping("pret/ajout/lecteur")
    public ModelAndView pretLecteurPost(@RequestParam(name = "id") Long id,
                                        @RequestParam(name = "LIVRE1_ID") Long livre1Id,
                                        @RequestParam(name = "LIVRE2_ID", required = false) Long livre2Id,
                                        @RequestParam(name = "LIVRE3_ID", required = false) Long livre3Id,
                                        @RequestParam(name = "LIVRE4_ID", required = false) Long livre4Id) {
        Lecteur lecteur = lecteurService.recupererLecteur(id);
        Livre livre1 = livreService.recupererLivre(livre1Id);
        Livre livre2 = livreService.recupererLivre(livre2Id);
        Livre livre3 = livreService.recupererLivre(livre3Id);
        Livre livre4 = livreService.recupererLivre(livre4Id);

        livre1.setEstDisponible(false);
        livre2.setEstDisponible(false);
        livre3.setEstDisponible(false);
        livre4.setEstDisponible(false);

        pretService.ajouterPret(lecteur, livre1);
        pretService.ajouterPret(lecteur, livre2);
        pretService.ajouterPret(lecteur, livre3);
        pretService.ajouterPret(lecteur, livre4);
        
        return new ModelAndView("redirect:/pret");
    }

    @GetMapping("pret/ajout/lecteur")
    public ModelAndView pretLecteurAjoutGet(@RequestParam(name = "id") Long id) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("lecteur", lecteurService.recupererLecteur(id));
        mav.setViewName("pretLecteurAjout");

        return mav;
    }
}
