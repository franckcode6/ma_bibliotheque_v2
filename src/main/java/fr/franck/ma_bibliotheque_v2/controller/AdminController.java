package fr.franck.ma_bibliotheque_v2.controller;

import fr.franck.ma_bibliotheque_v2.service.LecteurService;
import fr.franck.ma_bibliotheque_v2.service.LivreService;
import fr.franck.ma_bibliotheque_v2.service.PretService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AdminController {

    private final static int NB_LECTEURS_PAR_PAGE = 20;

    private final LecteurService lecteurService;
    private final LivreService livreService;
    private final PretService pretService;

    @GetMapping("admin/lecteurs")
    public ModelAndView lecteursGet(@PageableDefault(size = NB_LECTEURS_PAR_PAGE)
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
}
