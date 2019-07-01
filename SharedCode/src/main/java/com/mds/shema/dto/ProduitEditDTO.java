package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitEditDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1688273432319879581L;
	
	private Long codeInterne;
	private String codeExterne;
	private String description;
	private Long produitType;
	private Long produitEtat;
	private Long produitUniteStock;
	private Long produitUniteFacturation;
	private Boolean produitIndicateurAchat;
	private Boolean produitIndicateurVente;
	private String produitMarchee;
	private Long produitCodeTVAAchat;
	private Long produitCodeTVAVente;
	private String produitCommentaire1;
	private String produitCommentaire2;
}
