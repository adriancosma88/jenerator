package com.jenerator.generators;

public class DefaultObjectGenerator <T> extends AbstractObjectGenerator<T>{	
	public T generateTestObject(Class<T> clazz) {
		return generatePopulatedObject(clazz);
	}
}
