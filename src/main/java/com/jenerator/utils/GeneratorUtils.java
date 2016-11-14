package com.jenerator.utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratorsUtils {	
	private GeneratorsUtils(){}
	
	public static double getRandomDouble(double minDouble, double maxDouble) {
		return ThreadLocalRandom.current().nextDouble(minDouble, maxDouble);
	}
	
	public static int getRandomInt(int minInt, int maxInt) {
		return ThreadLocalRandom.current().nextInt(minInt, maxInt);
	}
	
	public static Date getRandomDate() {
		Calendar cal = GregorianCalendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		return getRandomDate(currentYear - 2, currentYear);
	}
	
	public static Date getRandomDate(int minYear, int maxYear) {
		int year = getRandomInt(minYear, maxYear + 1);
		int month = getRandomInt(0, 12);
		int day = getRandomInt(0, 28);
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(year, month, day);
		Date randomDate = calendar.getTime();
		
		return randomDate;
	}
	
	public static LocalDate getRandomLocalDate(int minYear, int maxYear) {
		long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
	    long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		return LocalDate.ofEpochDay(randomDay);
	}
	
	public static boolean isDoubleAttribute(String fieldTypeName) {
		if (fieldTypeName == null) {
			return false;
		}
		return fieldTypeName.equalsIgnoreCase(double.class.getName());
	}
	
	public static boolean isIntegerAttribute(String fieldTypeName) {
		if (fieldTypeName == null) {
			return false;
		}
		return fieldTypeName.equalsIgnoreCase(Integer.class.getName()) || 
				fieldTypeName.equalsIgnoreCase(int.class.getName());
	}

	/**
	 * 
	 * @return true if the {@code fieldTypeName} is String.
	 */
	public static boolean isStringAttribute(String fieldTypeName) {
		if (fieldTypeName == null) {
			return false;
		}
		return fieldTypeName.equalsIgnoreCase(String.class.getName());
	}
	
	public static boolean isDateAttribute(String fieldTypeName) {
		if (fieldTypeName == null) {
			return false;
		}
		return fieldTypeName.equalsIgnoreCase(Date.class.getName());
	}
	
	public static boolean isLocalDateAttribute(String fieldTypeName) {
		if (fieldTypeName == null) {
			return false;
		}
		return fieldTypeName.equalsIgnoreCase(LocalDate.class.getName());
	}
}
