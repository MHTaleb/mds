/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
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
@NamedQueries({
    @NamedQuery(name="Client.findAllByReference",query ="SELECT e FROM Client e WHERE e.reference like :reference"),
    @NamedQuery(name="Client.findAllByNom",query ="SELECT e FROM Client e WHERE e.nom like '%:nom%'"),
    @NamedQuery(name="Client.findAllByTypeClient",query ="SELECT e FROM Client e WHERE e.typeClient = :typeClient"),
    @NamedQuery(name="Client.findAllByNomEntreprise",query ="SELECT e FROM Client e WHERE e.nomEntreprise like '%:nomEntreprise%'"),
    @NamedQuery(name="Client.findAllByNumeroSiret",query ="SELECT e FROM Client e WHERE e.numeroSiret like ':numeroSiret'"),
    @NamedQuery(name="Client.findAllByNumeroTVA",query ="SELECT e FROM Client e WHERE e.numeroTVA like ':numeroTVA'"),
    @NamedQuery(name="Client.findAllByTitre",query ="SELECT e FROM Client e WHERE e.titre like '%:titre%'"),
    @NamedQuery(name="Client.findAllByPrenom",query ="SELECT e FROM Client e WHERE e.prenom like '%:prenom%'"),
    @NamedQuery(name="Client.findAllByLangueFacturation",query ="SELECT e FROM Client e WHERE e.langueFacturation = :langueFacturation"),
    @NamedQuery(name="Client.findAllByNom",query ="SELECT e FROM Client e WHERE e.nom like '%:nom%'")
})
public class Client extends ComonsDomain implements Serializable {

    @Unique
    private String reference;

    private TypeClient typeClient;

    @Unique
    private String nomEntreprise;

    @Unique
    private String numeroSiret;

    @Unique
    private String numeroTVA;

    private String titre;
    private String nom;
    private String prenom;
    private Long langueFacturation;

    @OneToMany
    private List<Adresse> adresses;

    @OneToMany
    private List<@Email String> emails;

    @OneToMany
    private List<String> telephones;

    @OneToMany
    private List<String> numeroComptes;

    @Builder
    public Client(String reference, TypeClient typeClient, String nomEntreprise, String numeroSiret, String numeroTVA, String titre, String nom, String prenom, Long langueFacturation, List<Adresse> adresses, List<String> emails, List<String> telephones, List<String> numeroComptes, Long id, Date dateCreation, Date dateEdition, Integer lastOperation) {
        super(id, dateCreation, dateEdition, lastOperation);
        this.reference = reference;
        this.typeClient = typeClient;
        this.nomEntreprise = nomEntreprise;
        this.numeroSiret = numeroSiret;
        this.numeroTVA = numeroTVA;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.langueFacturation = langueFacturation;
        this.adresses = adresses;
        this.emails = emails;
        this.telephones = telephones;
        this.numeroComptes = numeroComptes;
    }

    @Override
    public String toString() {
        return "Client{" + "\nreference=" + reference + ", \ntypeClient=" + typeClient + ", \nnomEntreprise=" + nomEntreprise + ", \nnumeroSiret=" + numeroSiret + ", \nnumeroTVA=" + numeroTVA + ", \ntitre=" + titre + ", nom=" + nom + ", \nprenom=" + prenom + ", \nlangueFacturation=" + langueFacturation + ", \nadresses=" + adresses + ", \nemails=" + emails + ", \ntelephones=" + telephones + ", \nnumeroComptes=" + numeroComptes + "\n}";
    }

    
    
    
}
