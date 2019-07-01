

package demo.printer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.shema.json.ClientJsonDto;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
@RequestMapping(PrintController.API)
public class PrintController {
    public static final String API="print";

    public byte[] generatePDFReport(String inputFileName, Map<String, Object> params) {
		return generatePDFReport(inputFileName, params, new JREmptyDataSource());
	}
    
        
	public File loadJasperFile(String file) {
		
		try {
			return ResourceUtils.getFile("classpath:static/reports/"+file+".jasper");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
    
    public byte[] generatePDFReport(String inputFileName, Map<String, Object> params,
    	    JRDataSource dataSource) {
    	    byte[] bytes = null;
    	    JasperReport jasperReport = null;
    	    try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
    	      // Check if a compiled report exists


    	    	jasperReport = (JasperReport) JRLoader.loadObject(loadJasperFile(inputFileName));
    	      
    	      // Compile report from source and save
    	   
    	      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
    	      // return the PDF in bytes
    	      bytes = JasperExportManager.exportReportToPdf(jasperPrint);
    	      JasperExportManager.exportReportToPdfFile(jasperPrint, "rapport.pdf");
    	    }
    	    catch (JRException | IOException e) {
    	      e.printStackTrace();
    	    }
    	    return bytes;
    	  }

    @PostMapping("client")
    public ResponseEntity<byte[]> export(@RequestBody List<ClientJsonDto> datas,HttpServletResponse response){

    	System.out.println(datas);
    	


        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(datas);

        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource", itemsJRBean);

        byte[] bytes = generatePDFReport("refclient", parameters);
        System.out.println("\n\n\n  -------------  lengh: "+bytes.length);
        return ResponseEntity
			      .ok()
			      // Specify content type as PDF
			      .header("Content-Type", "application/x-pdf; charset=UTF-8")
			      // Tell browser to display PDF if it can
			      .header("Content-Disposition", "attachment;inline; filename=\"client.pdf\"")
			      .body(bytes);
    }
}
