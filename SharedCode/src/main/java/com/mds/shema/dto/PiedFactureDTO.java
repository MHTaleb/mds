package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PiedFactureDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -944131178459151015L;
	private String noteBasPage;
}
