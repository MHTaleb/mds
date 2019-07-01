package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddClientDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1688273432319879581L;
	
	private Long codeInterne;
	private String codeExterne;
	private String identifiant;
	private String email;
	
	private String adress;
	private String ville;
	private String telephonePortable;
	private String clientPhone;
	

	private String nom;
	private String prenom;
	
	private Long clientType;
	private Long clientEtat;
}
