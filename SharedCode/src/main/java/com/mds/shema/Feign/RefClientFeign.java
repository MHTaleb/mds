package com.mds.shema.Feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mds.shema.dto.AddClientDTO;
import com.mds.shema.dto.ClientDTO;



@FeignClient(name="REF")
public interface RefClientFeign {

	@RequestMapping(method = RequestMethod.POST, value = "/refcli")
	Boolean addClient(@RequestBody AddClientDTO addClientDTO, @RequestParam String principal);
	
	@RequestMapping(method = RequestMethod.GET,value = "/refcli")
	List<ClientDTO> getAllclients();
	
	@PutMapping("/refcli")
	ResponseEntity<Boolean> setClient(@RequestBody AddClientDTO clientDTO ,@RequestParam String principal);
		
	@DeleteMapping("/refcli")
	ResponseEntity<Boolean> deleteClient(@RequestParam Long codeInterne,@RequestParam String pricipal);
}
