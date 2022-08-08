package fr.franck.ma_bibliotheque_v2.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @OneToMany(mappedBy = "editeur")
    private List<Livre> livres;

    public Editeur(String nom) {
        this.nom = nom;
    }
}
