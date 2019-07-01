package demo;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mds.shema.Feign.AppClientFeign;
import com.mds.shema.Feign.UserClientFeign;

@Controller
public class LandingController {

	
	private static final Logger log = LoggerFactory.getLogger(LandingController.class);

	
	
	
	
	@Autowired
	private AppClientFeign appClientFeign;
	
	@Autowired
	private UserClientFeign userClientFeign;


	@RequestMapping("/")
	String home(Model model,Principal principal) {
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		log.debug(stringBuilder.toString());
		return "desktop";
	}

  
}
