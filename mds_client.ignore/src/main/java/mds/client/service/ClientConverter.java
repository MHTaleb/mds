/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import mds.client.Operation;
import mds.client.domain.Adresse;
import mds.client.domain.Client;
import mds.client.domain.TypeClient;
import org.springframework.stereotype.Component;

/**
 * conversion class to client from http request param ( body )
 * @author taleb
 */
@Component
public class ClientConverter implements ClientConverterPolicy {

    /**
     * to use only to  create a new client
     * this is used to process a request http conversion to a
     * pojo client data type
     */
    @Override
    public Client convertFrom(String reference, TypeClient typeClient, String nomEntreprise, String numeroSiret, String numeroTVA, String titre, String nom, String prenom, Long langueFacturation, List<Adresse> adresses, List<String> emails, List<String> telephones, List<String> numeroComptes) {
        final Date now = Date.from(Instant.now());
        return Client.builder()
                .adresses(adresses)
                .dateCreation(now)
                .dateEdition(now)
                .emails(emails)
                .langueFacturation(langueFacturation)
                .lastOperation(Operation.CREATE.ordinal())
                .nom(nom)
                .nomEntreprise(nomEntreprise)
                .numeroComptes(numeroComptes)
                .numeroSiret(numeroSiret)
                .numeroTVA(numeroTVA)
                .prenom(prenom)
                .reference(reference)
                .telephones(telephones)
                .titre(titre)
                .typeClient(typeClient)
                    .build();

    }

}
