package demo.produit;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.shema.Feign.ProductFeignClient;
import com.mds.shema.dto.ProduitEditDTO;

@RestController
@RequestMapping(ProduitRestMediatorController.API)
public class ProduitRestMediatorController {

	public static final  String API = "api/produit";
	
	@Autowired
	private ProductFeignClient productFeignClient;
	
	
	/**
	 * to create a product
	 * @param productDto 
	 * @param principal 
	 * */
	@PostMapping
	String createProduct(@RequestBody ProduitEditDTO productDto, Principal principal) {
		
		return productFeignClient.addProduct(productDto, principal.getName());
		
	}
	
	
	@GetMapping
	List<ProduitEditDTO> getAllProducts(){
		return productFeignClient.getProducts();
	}
	
	
	@PutMapping
	String editProduct(@RequestBody ProduitEditDTO productDto, Principal principal) {
		return productFeignClient.editProduct(productDto, principal.getName());
	}
	
	@DeleteMapping
	String deleteProduct(@RequestBody String codeExterne, Principal principal) {
		return productFeignClient.deleteProduct(codeExterne, principal.getName());
	}
	
	
}
