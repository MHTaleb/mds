/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import mds.client.domain.Adresse;
import mds.client.domain.Client;
import mds.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taleb
 */
@Service
public class CRUDClientService implements CRUDService<Client> {

    private static final Logger LOGGER = Logger.getLogger(CRUDClientService.class.getName());

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createEntity(Client entity) {
        entity = clientRepository.save(entity);
        return entity;
    }

    @Override
    public Client editEntity(Long id, Client entity) {
        Optional<Client> clientqueryResult = clientRepository.findById(id);
        if (clientqueryResult.isPresent()) {

            Client editableClient = clientqueryResult.get();
            LogEdit(editableClient, entity);

            List<Adresse> adresses = editableClient.getAdresses();
            adresses.removeAll(adresses);
            adresses.addAll(entity.getAdresses());

            List<String> emails = editableClient.getEmails();
            emails.removeAll(emails);
            emails.addAll(entity.getEmails());

            List<String> numeroComptes = editableClient.getNumeroComptes();
            numeroComptes.removeAll(numeroComptes);
            numeroComptes.addAll(entity.getNumeroComptes());
        }
        LogEditError(id);
        return null;
    }

    /**
     * ** **** **
     * loggin ****
     */
    private void LogEdit(Client editableClient, Client entity) {
        LOGGER.log(Level.FINE, "client edition starter from {0} to {1}", new Object[]{editableClient, entity});
    }

    private void LogEditError(Long id) {
        LOGGER.log(Level.SEVERE, "error there is no id  to edit for client with : {0}", id);
    }

    @Override
    public Client findEntity(Long id) {
        Client client = null;
        Optional<Client> queryResultClient = clientRepository.findById(id);
        if (queryResultClient.isPresent()) {
            LogSuccessSearchById(id);
            return queryResultClient.get();
        }
        return client;
    }

    @Override
    public void removeEntity(Long id) {
        clientRepository.deleteById(id);
    }

    private void LogSuccessSearchById(Long id) {
        LOGGER.log(Level.FINE, "search client successfull {0}", id);
    }

    public String[] searchCreterias(){
        return new String[]{"reference","typeClient","nomEntreprise","numeroSiret","numeroTVA","titre","nom","prenom","langueFacturation","adresses","emails","telephones","numeroComptes","id","dateCreation"};                                
    }
    
    public List<Client> findBySearchCreteria(String searchCreteria, String searchValue) {
        switch(searchCreteria){
            case "langueFacturation":{return langueFacturationSearch(searchValue);}
            case "typeClient":{return typeClientSearch(searchValue);}
            case "dateCreation":{return dateCreationSearch(searchValue);}
            case "reference":{return referenceSearch(searchValue);}
            case "nomEntreprise":{return nomEntrepriseSearch(searchValue);}
            case "numeroSiret":{return numeroSiretSearch(searchValue);}
            case "numeroTVA":{return numeroTVASearch(searchValue);}
            case "titre":{return titreSearch(searchValue);}
            case "nom":{return nomSearch(searchValue);}
            case "prenom":{return prenomSearch(searchValue);}
            case "adresses":{return adressesSearch(searchValue);}
            case "emails":{return emailsSearch(searchValue);}
            case "numeroComptes":{return numeroComptesSearch(searchValue);}
            case "id":{return idSearch(searchValue);}
        }
        
        return null;
        
    }

    private List<Client> referenceSearch(String reference) {
        return clientRepository.findAllByReference(reference);
    }

    private List<Client> typeClientSearch(String typeClient) {
        return clientRepository.findAllByTypeClient(typeClient);
    }

    private List<Client> nomEntrepriseSearch(String nomEntreprise) {
         return clientRepository.findAllByNomEntreprise(nomEntreprise);
    }

    private List<Client> numeroSiretSearch(String numeroSiret) {
       return clientRepository.findAllByNumeroSiret(numeroSiret);
    }

    private List<Client> numeroTVASearch(String numero) {
       return clientRepository.findAllByNumeroTVA(numero);    
    }

    private List<Client> nomSearch(String nom) {
         return clientRepository.findAllByNom(nom);
    }

    private List<Client> titreSearch(String titre) {
         return clientRepository.findAllByTitre(titre);    
    }

    private List<Client> prenomSearch(String prenom) {
     return clientRepository.findAllByPrenom(prenom);    
    }

    private List<Client> langueFacturationSearch(String langueFacturation) {
        return clientRepository.findAllByLangueFacturation(langueFacturation);    
    }

    private List<Client> adressesSearch(String adresses) {
        return clientRepository.findAllByAdresses(adresses);    
        
    }

    private List<Client> emailsSearch(String emails) {
        return clientRepository.findAllByEmails(emails);    
    }

    private List<Client> dateCreationSearch(String dateCreation) {
        return clientRepository.findAllByDateCreation(dateCreation);
    }

    private List<Client> idSearch(String id) {
        ArrayList ids = new ArrayList();
        ids.add(Long.parseLong(id));
        return clientRepository.findAllById(ids);
    }

    private List<Client> numeroComptesSearch(String numeroComptes) {
        return clientRepository.findAllByNumeroComptes(numeroComptes);        
    }
    
    
}
    
