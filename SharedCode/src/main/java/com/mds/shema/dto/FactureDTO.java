package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactureDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3188925501120384637L;
	private ParamaitreFactureDTO paramettre;
	private EntetFactureDTO entete;
	private DetailFactureDTO detail;
	private PiedFactureDTO pied;
	
}
