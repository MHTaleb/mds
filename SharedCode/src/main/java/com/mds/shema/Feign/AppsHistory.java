package com.mds.shema.Feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppsHistory {
	private String AppName;
	private Long appID;
	private String liClass;
	private String AppIcon;
}
