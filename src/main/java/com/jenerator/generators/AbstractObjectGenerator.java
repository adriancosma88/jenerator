package com.jenerator.generators;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.jenerator.utils.GeneratorUtils;

public abstract class AbstractObjectGenerator<T> implements ObjectGenerator<T>{
	public static final int MIN_INT = 1;
	public static final int MAX_INT = 100;
	public static final double MIN_DOUBLE = 1.0;
	public static final double MAX_DOUBLE = 100.0;
		
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public abstract T generateTestObject(Class<T> clazz);	
	
	protected T populateObject(T object) {
		for (Field field : object.getClass().getDeclaredFields()) {
			String fieldTypeName = field.getType().getName();			
			
			if (GeneratorUtils.isStringAttribute(fieldTypeName)) {
				doStringGeneration(object, field);
				continue;
			}
			
			if (GeneratorUtils.isIntegerAttribute(fieldTypeName)){
				doIntegerGeneration(object, field);
				continue;
			}
			
			if (GeneratorUtils.isDoubleAttribute(fieldTypeName)) {
				doDoubleGeneration(object, field);
				continue;
			}
			
			if (GeneratorUtils.isDateAttribute(fieldTypeName)) {
				doDateGeneration(object, field);
				continue;
			}
		}
		
		return object;
	}

	protected void doDateGeneration(T object, Field field) {
		setTestValue(object, field, GeneratorUtils.getRandomDate());
	}

	protected void doDoubleGeneration(T object, Field field) {
		setTestValue(object, field, GeneratorUtils.getRandomDouble(MIN_DOUBLE, MAX_DOUBLE));
	}

	protected void doIntegerGeneration(T object, Field field) {
		setTestValue(object, field, GeneratorUtils.getRandomInt(MIN_INT, MAX_INT));
	}

	protected void doStringGeneration(T object, Field field) {
		generateTestStringFromAttributeName(object, field);
	}
	
	/**
	 * 
	 * @param holderObject the object which has the {@code field} attribute.
	 * @param field - the field which value will be set.
	 */
	protected void generateTestStringFromAttributeName(T holderObject, Field field) {
		setTestValue(holderObject, field, field.getName());
	}

	protected void setTestValue(T object, Field field, Object givenValue) {
		try {
			field.setAccessible(true);
			field.set(object, givenValue);
			field.setAccessible(false);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			logger.log(Level.ALL, "An exception occured while "
					+ "generating " + field.getName()+ " test value");
		}
	}

	protected T generatePopulatedObject(Class<T> clazz) {
		T emptyObject;

		try {
			emptyObject = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {			
			e.printStackTrace();
			emptyObject = null;
		}
		
		return populateObject(emptyObject);
	}
	
	public static boolean isContainingSubstring(String subString, String theString) {
		return Pattern.compile(Pattern.quote(theString),
				Pattern.CASE_INSENSITIVE).matcher(subString).find();
	}
}
