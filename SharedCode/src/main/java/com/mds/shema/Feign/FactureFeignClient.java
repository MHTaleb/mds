package com.mds.shema.Feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mds.shema.dto.FactureDTO;




@FeignClient("FACTURES")
public interface FactureFeignClient {

	@PostMapping("/facture")
	Boolean addFacture(@RequestBody FactureDTO factureDto , @RequestParam String principal);
	
	@GetMapping("/facture")
	List<FactureDTO> getFactures();
	
	@PutMapping("/facture")
	Boolean editFacture(@RequestBody FactureDTO factureDto , @RequestParam String principal);
	
	@DeleteMapping("/facture")
	Boolean deleteFacture(@RequestParam String codeExterne , @RequestParam String principal);

	
}
