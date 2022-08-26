package fr.franck.ma_bibliotheque_v2.controller;

import fr.franck.ma_bibliotheque_v2.service.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class LivreController {

    private static final int NB_LIVRES_PAR_PAGE = 20;

    private final LivreService livreService;

    @GetMapping({"livres", "/"})
    public ModelAndView livresGet(@PageableDefault(size = NB_LIVRES_PAR_PAGE)
                                  Pageable pageable) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("pageDeLivres", livreService.recupererLivres(pageable));
        mav.setViewName("listeDeLivres");

        return mav;
    }

    @GetMapping({"livres/filtrer", "/filtrer"})
    public ModelAndView livresGet(@RequestParam(name = "titre", required = false) String titre,
                                  @RequestParam(name = "auteur", required = false) String auteur,
                                  @RequestParam(name = "editeur", required = false) String editeur,
                                  @RequestParam(name = "categorie", required = false) String categorie,
                                  @RequestParam(name = "type", required = false) String type) {
        ModelAndView mav = new ModelAndView();

        if (titre != null) {
        mav.addObject("livres", livreService.recupererLivresParTitre(titre));
        }

        if (auteur != null) {
        mav.addObject("livres", livreService.recupererLivresParAuteur(auteur));
        }

        if (editeur != null) {
        mav.addObject("livres", livreService.recupererLivresParEditeur(editeur));
        }

        if (categorie != null) {
        mav.addObject("livres", livreService.recupererLivresParCategorie(categorie));
        }

        if (type != null) {
        mav.addObject("livres", livreService.recupererLivresParType(type));
        }

        mav.setViewName("listeDeLivresFiltree");

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
