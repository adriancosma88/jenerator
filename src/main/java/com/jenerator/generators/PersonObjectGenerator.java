package com.jenerator.generators;

import static com.jenerator.utils.Constants.firstNames;
import static com.jenerator.utils.Constants.lastNames;

import java.lang.reflect.Field;

import com.jenerator.utils.GeneratorUtils;

public final class PersonObjectGenerator<T> extends AbstractObjectGenerator<T> {
	private static final String FIRST_NAME = "firstName";

	@Override
	public T generateTestObject(Class<T> clazz) {
		return generatePopulatedObject(clazz);
	}
	
	protected void doStringGeneration(T object, Field field) {
		//TODO: write test!
		if (isContainingSubstring(FIRST_NAME, field.getName())) {
			setTestValue(object, field, getRandomFirstName());
		}
		generateTestStringFromAttributeName(object, field);
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
