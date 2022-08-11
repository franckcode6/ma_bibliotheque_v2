package fr.franck.ma_bibliotheque_v2.controller;

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

    final LecteurService lecteurService;
    final LivreService livreService;
    final PretService pretService;

    @GetMapping("pret")
    public ModelAndView pretGet() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("nouveauPret");

        return mav;
    }

    @PostMapping("pret")
    public ModelAndView pretPost(@RequestParam(name = "id") Long id) {
        return new ModelAndView("redirect:/pret/utilisateur");
    }
}
