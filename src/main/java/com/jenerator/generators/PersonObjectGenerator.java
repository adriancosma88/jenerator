package com.jenerator.generators;

import java.lang.reflect.Field;

import com.jenerator.utils.Constants;
import com.jenerator.utils.GeneratorUtils;

public class PersonObjectGenerator<T> extends AbstractObjectGenerator<T> {
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
	
	private String getRandomFirstName() {
		return Constants.firstNames.get(
				GeneratorUtils.getRandomInt(0, Constants.firstNames.size()));
	}
}
