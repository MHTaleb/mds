/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client.controller;

import java.security.Principal;
import mds.client.service.CRUDClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author taleb
 */
@RequestMapping(ClientApiHttpController.API)
public class ClientApiHttpController {
    public static final String API = "clients";
    
    @Autowired private CRUDClientService clientService;
    
    
    @GetMapping
    public ResponseEntity getClientsByCreteria(@RequestBody ClientSearchRequest clientSearchRequest ,Principal principal){
         
        return new ResponseEntity(clientService.findBySearchCreteria(clientSearchRequest.getSearchCreteria(),clientSearchRequest.getSearchValue()),HttpStatus.FOUND);
    }
    
}
