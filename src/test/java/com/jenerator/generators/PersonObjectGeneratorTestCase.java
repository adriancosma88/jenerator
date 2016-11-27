package com.jenerator.generators;

import static com.jenerator.generators.PersonObjectGenerator.getRandomFirstName;
import static com.jenerator.generators.PersonObjectGenerator.getRandomLastName;
import static com.jenerator.utils.Constants.firstNames;
import static com.jenerator.utils.Constants.lastNames;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersonObjectGeneratorTestCase {
	@Test
	public void randomFirstNameIsCorrect() {
		String randomFirstName = getRandomFirstName();
		assertTrue(firstNames.contains(randomFirstName));
	}
	
	@Test
	public void randomLastNameIsCorrect() {
		String randomFirstName = getRandomLastName();
		assertTrue(lastNames.contains(randomFirstName));
	}
}
