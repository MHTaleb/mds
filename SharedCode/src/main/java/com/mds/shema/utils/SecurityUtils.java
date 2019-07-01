package com.mds.shema.utils;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

public class SecurityUtils {

	@Autowired
	public static Principal currentUser;
	
}
