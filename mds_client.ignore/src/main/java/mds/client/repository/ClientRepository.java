/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.repository;

import java.util.List;
import mds.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taleb
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findAllByReference(String reference);

    public List<Client> findAllByNom(String nom);

    public List<Client> findAllByTypeClient(String typeClient);

    public List<Client> findAllByNomEntreprise(String nomEntreprise);

    public List<Client> findAllByNumeroSiret(String numeroSiret);

    public List<Client> findAllByNumeroTVA(String numero);

    public List<Client> findAllByTitre(String titre);

    public List<Client> findAllByPrenom(String prenom);

    public List<Client> findAllByLangueFacturation(String langueFacturation);

    public List<Client> findAllByAdresses(String adresses);

    public List<Client> findAllByEmails(String emails);

    public List<Client> findAllByDateCreation(String dateCreation);

    public List<Client> findAllByNumeroComptes(String numeroComptes);

}
