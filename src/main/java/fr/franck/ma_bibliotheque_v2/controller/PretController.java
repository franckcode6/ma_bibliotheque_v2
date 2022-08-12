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

    @PostMapping("pret/lecteur")
    public ModelAndView pretLecteurPost(@RequestParam(name = "id") Long id,
                                        @RequestParam(name = "LIVRE_ID") Long livreId) {
        Livre livre = livreService.recupererLivre(livreId);
        livre.setEstDisponible(false);

        pretService.ajouterPret(lecteurService.recupererLecteur(id), livre);

        return new ModelAndView("redirect:/pret");
    }
}
