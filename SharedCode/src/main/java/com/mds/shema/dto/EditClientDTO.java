package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6180497114140567876L;
	private String codeClient;
	private String identifiant;
	private String email;
	
	
	private Long typeClient;
	private Long etatClient;
}
