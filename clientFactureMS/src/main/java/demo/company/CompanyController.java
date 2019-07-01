package demo.company;

import static org.springframework.http.HttpStatus.METHOD_FAILURE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.shema.dto.CompanySettingQuickFormDTO;

@RestController
@RequestMapping(CompanyController.API)
public class CompanyController {
	public static final String API = "/company";
	private String errorMessage;
	@PutMapping("/setting")
	public ResponseEntity<String> saveCompanySettingQuickForm(@RequestBody CompanySettingQuickFormDTO companySettingQuickForm){
		
		if(!validateSettings(companySettingQuickForm)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
		
		return ResponseEntity.ok("companySettings saved succesfully");
	}
	private boolean validateSettings(CompanySettingQuickFormDTO companySettingQuickForm) {
	
		return !companySettingQuickForm.getAdresse().isEmpty() && !companySettingQuickForm.getCompanyName().isEmpty() ;
	}
	
}
