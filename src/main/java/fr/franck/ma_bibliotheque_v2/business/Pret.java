package fr.franck.ma_bibliotheque_v2.business;

import jdk.jshell.execution.Util;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate dateDebut;

    @NotNull
    private LocalDate dateFin;

    @NotNull
    @ManyToOne
    private Utilisateur utilisateur;

    @NotNull
    @ManyToOne
    private Livre livre;

    public Pret() {
        this.dateDebut = LocalDate.now();
        this.dateFin = LocalDate.now().plusDays(30);
    }

    public Pret(Utilisateur utilisateur, Livre livre) {
        this();
        this.utilisateur = utilisateur;
        this.livre = livre;
    }

    @Override
    public String toString() {
        return "Pret{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
