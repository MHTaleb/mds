package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientContactDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8195489790764704744L;
	private String nom;
	private String prenom;
	private String telephonePortable;
	private String email;
}
