package com.mds.shema.dto;

import lombok.Data;

@Data
public class NotificationDTO {

	
	private Long clinotci;
	
	private String clinotttr;

	private String clinotdesc;

	private String clinotdet;

	private Boolean clinotcon = false;

	private Long clinotgra = 0L;
}
