package com.jenerator.generators;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultObjectGenerator <T> implements ObjectGenerator<T>{
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
			if (isStringAttribute(fieldTypeName)) {
				generateTestStringFromAttributeName(object, field);
			}
			
			if (fieldTypeName.equalsIgnoreCase(Integer.class.getName())){
				
			}
		}
		
		return object;
	}

	private void generateTestStringFromAttributeName(T object, Field field) {
		setGivenTestValue(object, field, field.getName());
	}

	private void setGivenTestValue(T object, Field field, Object givenValue) {
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

	private boolean isStringAttribute(String fieldTypeName) {
		return fieldTypeName.equalsIgnoreCase(String.class.getName());
	}
}
