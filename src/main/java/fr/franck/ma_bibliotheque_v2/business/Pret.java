package fr.franck.ma_bibliotheque_v2.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
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
}
