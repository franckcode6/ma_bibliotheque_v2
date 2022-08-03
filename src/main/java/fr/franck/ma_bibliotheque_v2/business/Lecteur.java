package fr.franck.ma_bibliotheque_v2.business;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Lecteur extends Utilisateur {

    @NotNull
    private LocalDate dateDeNaissance;

    public Lecteur(String nom, String prenom, String email, String motDePasse, LocalDate dateDeNaissance) {
        super(nom, prenom, email, motDePasse);
        this.dateDeNaissance = dateDeNaissance;
    }
}
