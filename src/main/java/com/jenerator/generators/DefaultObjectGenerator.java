package com.jenerator.generators;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jenerator.utils.GeneratorsUtils;

public class DefaultObjectGenerator <T> implements ObjectGenerator<T>{
	public static final int MIN_INT = 1;
	public static final int MAX_INT = 100;
	public static final double MIN_DOUBLE = 1.0;
	public static final double MAX_DOUBLE = 100.0;
		
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public T generateTestObject(Class<T> clazz) {
		T emptyObject;
		try {
			emptyObject = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {			
			e.printStackTrace();
			emptyObject = null;
		}
		
		return populateObject(emptyObject);
	}
	
	private T populateObject(T object) {
		for (Field field : object.getClass().getDeclaredFields()) {
			String fieldTypeName = field.getType().getName();
			if (GeneratorsUtils.isStringAttribute(fieldTypeName)) {
				generateTestStringFromAttributeName(object, field);
			}
			
			if (GeneratorsUtils.isIntegerAttribute(fieldTypeName)){
				setTestValue(object, field, GeneratorsUtils.getRandomInt(MIN_INT, MAX_INT));
			}
			
			if (GeneratorsUtils.isDoubleAttribute(fieldTypeName)) {
				setTestValue(object, field, GeneratorsUtils.getRandomDouble(MIN_DOUBLE, MAX_DOUBLE));
			}
		}
		
		return object;
	}	

	/**
	 * 
	 * @param holderObject the object which has the {@code field} attribute.
	 * @param field - the field which value will be set.
	 */
	private void generateTestStringFromAttributeName(T holderObject, Field field) {
		setTestValue(holderObject, field, field.getName());
	}

	private void setTestValue(T object, Field field, Object givenValue) {
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
}
