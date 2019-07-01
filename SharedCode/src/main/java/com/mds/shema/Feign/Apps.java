package com.mds.shema.Feign;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Apps {
	private Long appID;
	private String appName;
	private String appIcon;
	private String appLink;
	
	
	
}
