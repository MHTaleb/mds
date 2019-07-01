package com.mds.shema.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author taleb Mohammed Housseyn
 * 
 * all date tools
 * 
 * dry principle
 * */
public class MdsDateUtils {

	/**
	 * needs java8 or above, implemented using the LocalDate on time package
	 * @return 2049/12/31 wrapped in a java.util.Date
	 * */
	public static Date getEndDate() {

		return Date.from(Instant.from(LocalDate.of(2049, 12, 31).atStartOfDay(ZoneId.systemDefault())));

	}

	/**
	 * needs java 8 or above , implemented depending on LocalDate from time package
	 * @param year the year
	 * @param mounth the mounth
	 * @param day the day
	 * 
	 * @return a java.util.Date representation 
	 * */
	public static Date getEndDate(int year,int mounth, int day) {

		return Date.from(Instant.from(LocalDate.of(year, mounth, day).atStartOfDay(ZoneId.systemDefault())));

	}

	private MdsDateUtils() {}
}
