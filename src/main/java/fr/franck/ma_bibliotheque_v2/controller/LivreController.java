package fr.franck.ma_bibliotheque_v2.controller;

import fr.franck.ma_bibliotheque_v2.service.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class LivreController {

    private static final int NB_LIVRES_PAR_PAGE = 10;

    private final LivreService livreService;

    @GetMapping({"livres", "/"})
    public ModelAndView livresGet(@PageableDefault(size = NB_LIVRES_PAR_PAGE, sort = "dateDeParution")
                                  Pageable pageable) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("pageDeLivres", livreService.recupererLivres(pageable));
        mav.setViewName("listeDeLivres");

        return mav;
    }

    @GetMapping("livres/details")
    public ModelAndView detailsLivreGet(@RequestParam(name = "id") Long id) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("livre", livreService.recupererLivre(id));
        mav.setViewName("detailsLivre");

        return mav;
    }
}
