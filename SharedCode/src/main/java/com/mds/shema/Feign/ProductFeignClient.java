package com.mds.shema.Feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mds.shema.dto.ProduitEditDTO;

@FeignClient("PRODUITS")
public interface ProductFeignClient {

	public static final String PRODUCT = "/products";

	@PostMapping(PRODUCT)
	String addProduct(@RequestBody ProduitEditDTO productDto , @RequestParam String principal);
	
	@GetMapping(PRODUCT)
	List<ProduitEditDTO> getProducts();
	
	@PutMapping(PRODUCT)
	String editProduct(@RequestBody ProduitEditDTO productDto , @RequestParam String principal);
	
	@DeleteMapping(PRODUCT)
	String deleteProduct(@RequestParam String codeExterne , @RequestParam String principal);
}
