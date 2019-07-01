package demo.refclient;

import java.security.Principal;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.shema.Feign.RefClientFeign;
import com.mds.shema.dto.AddClientDTO;



@RestController
@RequestMapping(RefClientMediatorController.API)
public class RefClientMediatorController {

	public static final String API = "client";

	
	private static final Logger log = LoggerFactory.getLogger(RefClientMediatorController.class);

	

	@Autowired
	private RefClientFeign refClientFeign;

	@PostMapping
	String addClient(Principal principal, Model model, AddClientDTO addClientDTO) {
		if(log.isDebugEnabled())log.debug(MessageFormat.format("{0}", addClientDTO));
		System.out.println(principal.getName());
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		String attributeValue = "client ajouter avec success";
		
			Boolean addClient = refClientFeign.addClient(addClientDTO,principal.getName());

			if (!addClient) {
				attributeValue = "erreur veuillez verifier votre formulaire";
			}
			
			
		
		return attributeValue;

	}
	
	
	@PutMapping
	String editClient(Principal principal, Model model, AddClientDTO addClientDTO) {
		if(log.isDebugEnabled())log.debug(MessageFormat.format("{0}", addClientDTO));
		log.info(principal.getName());
		String attributeValue = "client modifier avec success";
		
			Boolean addClient = refClientFeign.setClient(addClientDTO,principal.getName()).getBody();

			if (!addClient) {
				attributeValue = "erreur veuillez verifier votre formulaire";
			}
			
			
		
		return attributeValue;

	}
	
}
