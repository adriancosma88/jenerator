package com.jenerator.generators;

public interface ObjectGenerator <T> {
	public T generateTestObject(Class<T> clazz);
}
