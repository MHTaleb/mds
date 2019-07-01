package com.mds.shema.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientAdressDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7675654516231166156L;
	public String adress;
	public String ville;

}
