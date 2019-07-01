package com.mds.shema.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO implements Serializable{
   
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -9220049364187660058L;
	private Long codeInterne;
	private String clientName;
	private String clientPhone;
	private String codeExterne;
	private String email;
	private Long clientType;
	private Long clientEtat;
	private String identifiant;
	private List<ClientContactDTO> contacts;
	private List<ClientAdressDTO> adresses;
}
