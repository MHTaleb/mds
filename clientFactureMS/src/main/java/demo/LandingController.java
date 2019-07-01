package demo;




import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mds.shema.Feign.AppClientFeign;
import com.mds.shema.Feign.Menu;
import com.mds.shema.Feign.UserClientFeign;
import com.mds.shema.dto.AddClientDTO;
import com.mds.shema.dto.CompanySettingQuickFormDTO;





@Controller
public class LandingController {
	
	
	private static final Logger log = LoggerFactory.getLogger(LandingController.class);

	

	
	
	@Autowired
	private AppClientFeign appClientFeign;
	
	@Autowired
	private UserClientFeign userClientFeign;


	@RequestMapping("/")
	String home(Model model,Principal principal) {
		List<Menu> appMenus = appClientFeign.getAppMenus("facturation");
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		if(log.isDebugEnabled()) {
			StringBuilder stringBuilder2 = new StringBuilder();
			stringBuilder2.append(appMenus);
			stringBuilder2.append("");
			log.debug(stringBuilder2.toString());
		}
		model.addAttribute("menuV", appMenus);
		model.addAttribute("addClientObject", AddClientDTO.builder().build());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		if(log.isDebugEnabled())log.debug(stringBuilder.toString());
		return "facturation";
	}
/*
	@RequestMapping("/facturation-header")
	String facturationHeader(Model model,Principal principal) {
		List<Menu> appMenus = appClientFeign.getAppMenus("facturation");
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		if(log.isDebugEnabled()) {
			StringBuilder stringBuilder2 = new StringBuilder();
			stringBuilder2.append(appMenus);
			stringBuilder2.append("");
			log.debug(stringBuilder2.toString());
		}
		model.addAttribute("menuV", appMenus);
		model.addAttribute("addClientObject", AddClientDTO.builder().build());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		if(log.isDebugEnabled())log.debug(stringBuilder.toString());
		return "facturation-header";
	}
	

	@RequestMapping("/facturation-menu0")
	String facturationMenu0(Model model,Principal principal) {
		List<Menu> appMenus = appClientFeign.getAppMenus("facturation");
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		if(log.isDebugEnabled()) {
			StringBuilder stringBuilder2 = new StringBuilder();
			stringBuilder2.append(appMenus);
			stringBuilder2.append("");
			log.debug(stringBuilder2.toString());
		}
		model.addAttribute("menuV", appMenus);
		model.addAttribute("addClientObject", AddClientDTO.builder().build());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		if(log.isDebugEnabled())log.debug(stringBuilder.toString());
		return "facturation-menu0";
	}
	
	@RequestMapping("/facturation-menu0-func0-panel")
	String facturationmenu0func0panel(Model model,Principal principal) {
		List<Menu> appMenus = appClientFeign.getAppMenus("facturation");
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		if(log.isDebugEnabled()) {
			StringBuilder stringBuilder2 = new StringBuilder();
			stringBuilder2.append(appMenus);
			stringBuilder2.append("");
			log.debug(stringBuilder2.toString());
		}
		model.addAttribute("menuV", appMenus);
		model.addAttribute("addClientObject", AddClientDTO.builder().build());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		if(log.isDebugEnabled())log.debug(stringBuilder.toString());
		return "facturation-menu0-func0-panel";
	}
	
	

	@RequestMapping("/facturation-menu0-func1-panel")
	String facturationmenu0func1panel(Model model,Principal principal) {
		List<Menu> appMenus = appClientFeign.getAppMenus("facturation");
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		if(log.isDebugEnabled()) {
			StringBuilder stringBuilder2 = new StringBuilder();
			stringBuilder2.append(appMenus);
			stringBuilder2.append("");
			log.debug(stringBuilder2.toString());
		}
		model.addAttribute("menuV", appMenus);
		model.addAttribute("addClientObject", AddClientDTO.builder().build());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		if(log.isDebugEnabled())log.debug(stringBuilder.toString());
		return "facturation-menu0-func1-panel";
	}
	*/
	@RequestMapping("/html/{page}")
	String resolveHTML(Model model,Principal principal,@PathVariable String page) {
		List<Menu> appMenus = appClientFeign.getAppMenus("facturation");
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		if(log.isDebugEnabled()) {
			StringBuilder stringBuilder2 = new StringBuilder();
			stringBuilder2.append(appMenus);
			stringBuilder2.append("");
			log.debug(stringBuilder2.toString());
		}
		model.addAttribute("menuV", appMenus);
		model.addAttribute("addClientObject", AddClientDTO.builder().build());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		if(log.isDebugEnabled())log.debug(stringBuilder.toString());
		return page;
	}
	
	@RequestMapping("/html/{folder}/{page}")
	String resolveHTML(Model model,Principal principal,@PathVariable String page,@PathVariable String folder) {
		List<Menu> appMenus = appClientFeign.getAppMenus("facturation");
		model.addAttribute("applications", appClientFeign.getApps());
		model.addAttribute("applicationsHistory", appClientFeign.getAppsHistory(principal.getName()));
		model.addAttribute("currentUser", userClientFeign.getUserDetails(principal.getName()));
		if(log.isDebugEnabled()) {
			StringBuilder stringBuilder2 = new StringBuilder();
			stringBuilder2.append(appMenus);
			stringBuilder2.append("");
			log.debug(stringBuilder2.toString());
		}
		model.addAttribute("menuV", appMenus);
		model.addAttribute("addClientObject", AddClientDTO.builder().build());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" hello world ****************** ---------------------- ************************ \n \n \n");
		stringBuilder.append(appClientFeign.getApps());
		if(log.isDebugEnabled())log.debug(stringBuilder.toString());
		
		switch(page) {
			case "settingsForm":
				model.addAttribute("companySettingQuickForm", new CompanySettingQuickFormDTO());
				break;
			default:
				break;
		}
		
		return folder+"/"+page;
	}
	
}
