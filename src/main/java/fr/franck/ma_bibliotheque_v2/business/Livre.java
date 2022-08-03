package fr.franck.ma_bibliotheque_v2.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titre;

    @NotBlank
    private String isbn;

    @NotNull
    private LocalDate dateDeParution;

    @NotBlank
    private boolean estDisponible;

    @ManyToOne
    private Auteur auteur;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Editeur editeur;

    @OneToMany(mappedBy = "livre")
    private List<Pret> prets;

    public Livre() {
        this.estDisponible = true;
    }
}
