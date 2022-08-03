package fr.franck.ma_bibliotheque_v2.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Admin extends Utilisateur{

    @NotBlank
    private String numeroDeTelephone;

    public Admin(String nom, String prenom, String email, String motDePasse, String numeroDeTelephone) {
    	super(nom, prenom, email, motDePasse);
    	this.numeroDeTelephone = numeroDeTelephone;
    }
}
