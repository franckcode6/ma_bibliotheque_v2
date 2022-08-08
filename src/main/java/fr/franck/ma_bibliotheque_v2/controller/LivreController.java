package fr.franck.ma_bibliotheque_v2.controller;

import fr.franck.ma_bibliotheque_v2.service.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class LivreController {

    private final LivreService livreService;

    @GetMapping("/")
    public ModelAndView livresGet() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("livres", livreService.recupererLivres());
        mav.setViewName("listeDeLivres");

        return mav;
    }
}
