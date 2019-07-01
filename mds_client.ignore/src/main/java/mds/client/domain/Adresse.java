/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mds.client.ComonsDomain;

/**
 *
 * @author taleb
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adresse extends ComonsDomain implements Serializable {
    
   private String adresse;
   private String ville;
   private String codePostal;

    @Builder
    public Adresse(String adresse, String ville, String codePostal, Long id, Date dateCreation, Date dateEdition, Integer lastOperation) {
        super(id, dateCreation, dateEdition, lastOperation);
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }
    
   
   
}
