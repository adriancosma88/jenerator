package com.jenerator.generators;

import static com.jenerator.utils.Constants.firstNames;
import static com.jenerator.utils.Constants.lastNames;

import java.lang.reflect.Field;

import com.jenerator.utils.GeneratorUtils;

public final class PersonObjectGenerator<T> extends AbstractObjectGenerator<T> {
	static final String TEST_DOMAIN_COM = "@testDomain.com";
	private static final String EMAIL = "email";
	private static final String LAST_NAME = "lastName";
	private static final String FIRST_NAME = "firstName";

	@Override
	public T generateTestObject(Class<T> clazz) {
		return generatePopulatedObject(clazz);
	}
	
	protected void doStringGeneration(T object, Field field) {
		if (isContainingSubstring(FIRST_NAME, field.getName())) {
			setTestValue(object, field, getRandomFirstName());
			return;
		}
		
		if (isContainingSubstring(LAST_NAME, field.getName())) {
			setTestValue(object, field, getRandomLastName());
			return;
		}
		
		if (isContainingSubstring(EMAIL, field.getName())) {
			String generatedLastName = "";
			String generatedFirstName = "";
			
			for (Field iterated : object.getClass().getFields()) {
				if (isContainingSubstring(FIRST_NAME, iterated.getName())) {
					generatedFirstName = getStringValue(iterated, object);
				}
				
				if (isContainingSubstring(LAST_NAME, iterated.getName())) {
					generatedLastName = getStringValue(iterated, object);
				}
			}
			setTestValue(object, field, 
					generateEmail(generatedFirstName, generatedLastName));
			return;
		}
		
		generateTestStringFromAttributeName(object, field);
	}

	protected String getStringValue(Field iterated, T object) {
		String generatedFirstName;
		try {
			generatedFirstName = (String) iterated.get(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			generatedFirstName = "";
		}
		return generatedFirstName;
	}
	
	static String generateEmail(String generatedFirstName, String generatedLastName) {
		return generatedFirstName + "." + generatedLastName + TEST_DOMAIN_COM;
	}

	static String getRandomFirstName() {
		return firstNames.get(
				GeneratorUtils.getRandomInt(0, firstNames.size()));
	}

	static String getRandomLastName() {
		return lastNames.get(
				GeneratorUtils.getRandomInt(0, lastNames.size()));
	}
}
