package com.mds.shema.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntetFactureDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6843298321323181L;
	private String codeExterneClient;
	private String numeroFacture; // code externe facture
	private Date dateFacture; 	
	private Long delaiDePayement;
	private String message;
	private String titre;
	
} 
