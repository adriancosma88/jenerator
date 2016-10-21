package com.jenerator.generators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jenerator.generators.DefaultObjectGenerator;
import com.jenerator.generators.ObjectGenerator;
import com.jenerator.testObjects.IntHolder;
import com.jenerator.testObjects.Person;

public class DefaultGeneratorTestCase {
	private static final String FIRST_NAME = "firstName";

	@Test
	public void testStringGenerator() throws Exception {
		ObjectGenerator<Person> personGenerator = new DefaultObjectGenerator<>();
		Person person = personGenerator.generateTestObject(Person.class);
		
		assertEquals("firstName should have the value \"firstName\"", 
				FIRST_NAME, person.getFirstName());
	}
	
	@Test
	public void testIntegerGenerator() {
		ObjectGenerator<IntHolder> integerGenerator = new DefaultObjectGenerator<>();
		IntHolder intHolder = integerGenerator.generateTestObject(IntHolder.class);
		
		assertTrue("Integer generated value should be in the interval [1, 10).", 
				0 < intHolder.getTestInt() && intHolder.getTestInt() < 10);
	}	
}
