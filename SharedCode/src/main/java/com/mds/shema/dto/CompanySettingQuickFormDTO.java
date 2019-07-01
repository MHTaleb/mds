package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompanySettingQuickFormDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4788983142210860106L;
	
	private String companyName;
	private String adresse;
}
