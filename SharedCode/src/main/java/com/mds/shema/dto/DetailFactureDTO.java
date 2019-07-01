package com.mds.shema.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailFactureDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731841969790849071L;
	private String codeExternProduit;
	private Date dateAchatProduit;
	private Double qte;
	private Long codeUnite;
	private Double prixUnitaire;
	private Long codeTVA;
}
