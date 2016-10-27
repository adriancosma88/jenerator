package com.jenerator.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GeneratorsUtils {	
	public static double getRandomDouble(double minDouble, double maxDouble) {
		return ThreadLocalRandom.current().nextDouble(minDouble, maxDouble);
	}
	
	public static int getRandomInt(int minInt, int maxInt) {
		return ThreadLocalRandom.current().nextInt(minInt, maxInt);
	}
	
	public static boolean isDoubleAttribute(String fieldTypeName) {
		if (fieldTypeName == null) {
			return false;
		}
		return fieldTypeName.equalsIgnoreCase(double.class.getName());
	}
	
	public static boolean isIntegerAttribute(String fieldTypeName) {
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
	
	private GeneratorsUtils(){}
}
