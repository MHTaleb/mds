package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParamaitreFactureDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1464508465664553838L;
	private String codeExterneSiteDelivreur;
	private Long typeFacture; // vente , vente sans tv , vente exonérée
	private Long devise; // 1 : DA   2: Euro ... tablde des devises  id Long
}
