package demo.refclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.shema.Feign.RefClientFeign;
import com.mds.shema.dto.ClientDTO;

@RestController
@RequestMapping(RefClientMediatorRestController.API)
public class RefClientMediatorRestController {
 
	public static final String API="client/api";
	
	@Autowired
	private RefClientFeign refClientFeign;
	
	@GetMapping
	ResponseEntity<List<ClientDTO>> getAllClients(){
		List<ClientDTO> response = refClientFeign.getAllclients();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
