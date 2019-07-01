/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.service;

import java.util.List;
import mds.client.domain.Adresse;
import mds.client.domain.Client;
import mds.client.domain.TypeClient;

/**
 *
 * @author taleb
 */
interface ClientConverterPolicy {
   
    public Client convertFrom(String reference, TypeClient typeClient, String nomEntreprise, String numeroSiret, String numeroTVA, String titre, String nom, String prenom, Long langueFacturation, List<Adresse> adresses, List<String> emails, List<String> telephones, List<String> numeroComptes);
}
