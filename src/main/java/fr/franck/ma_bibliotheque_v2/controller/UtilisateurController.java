package fr.franck.ma_bibliotheque_v2.controller;

import fr.franck.ma_bibliotheque_v2.business.Lecteur;
import fr.franck.ma_bibliotheque_v2.business.Utilisateur;
import fr.franck.ma_bibliotheque_v2.service.PretService;
import fr.franck.ma_bibliotheque_v2.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class UtilisateurController {

    private final PretService pretService;
    private final UtilisateurService utilisateurService;
    private final HttpSession httpSession;

    @GetMapping("/connexion")
    public ModelAndView connexionGet() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("connexion");

        return mav;
    }

    @PostMapping("/connexion")
    public ModelAndView connexionPost(@RequestParam(name = "EMAIL") String email,
                                      @RequestParam(name = "MDP") String mdp) {

        Utilisateur utilisateur = utilisateurService.recupererUtilisateur(email, mdp);

        if (utilisateur == null) {
            return new ModelAndView("redirect:/connexion");
        } else if (utilisateur.getEmail().equals("admin@mabibliotheque.com")) {
            httpSession.setAttribute("admin", utilisateur);
            return new ModelAndView("redirect:/admin");
        } else {
            httpSession.setAttribute("lecteurConnecte", utilisateur);
            return new ModelAndView("redirect:/livres");
        }
    }

    @GetMapping("/deconnexion")
    public ModelAndView deconnexionGet() {
        httpSession.invalidate();
        return new ModelAndView("redirect:/livres");
    }

    @GetMapping("/compte")
    public ModelAndView compteGet() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("compte");
        Lecteur lecteur = (Lecteur) httpSession.getAttribute("lecteurConnecte");
        mav.addObject("lecteurConnecte", lecteur);
        mav.addObject("prets", pretService.recupererPrets(lecteur.getId()));

        return mav;
    }
}
