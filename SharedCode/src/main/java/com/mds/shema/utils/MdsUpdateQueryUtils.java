package com.mds.shema.utils;

public class MdsUpdateQueryUtils {
	private MdsUpdateQueryUtils() {
		
	}
  public static String getUpdateCommon(String prefix,String principal,String program) {
	  return " ";//+prefix+".datmaj = CURDATE() , "+prefix+".deruser = '"+principal+"' ,"+prefix+".derprg = '"+program+"' , "+prefix+".donord = '"+principal+"'";	
  }
}
