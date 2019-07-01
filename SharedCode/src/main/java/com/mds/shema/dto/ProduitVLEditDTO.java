package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitVLEditDTO implements Serializable {

	
	
	private static final long serialVersionUID = -1688273432319879581L;
	
	private Long codeInterneProduit;

	private Long codeInterneVL;

	private String codeExterneVL;

	private Boolean etatVL;
	
	
}
