package com.jenerator.generators;

import static com.jenerator.generators.PersonObjectGenerator.getRandomFirstName;
import static com.jenerator.generators.PersonObjectGenerator.getRandomLastName;
import static com.jenerator.utils.Constants.firstNames;
import static com.jenerator.utils.Constants.lastNames;
import static org.junit.Assert.*;

import org.junit.Test;

import com.jenerator.generators.testObjects.Student;
import com.jenerator.utils.Constants;

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
	
	@Test
	public void emailAddressIsGeneratedFromName() throws Exception {
		assertEquals("firstName.lastName" + PersonObjectGenerator.TEST_DOMAIN_COM,
				PersonObjectGenerator.generateEmail("firstName", "lastName"));
	}
	
	@Test
	public void fullPersonGenerator() throws Exception {		
		PersonObjectGenerator<Student> studentGenerator = 
				new PersonObjectGenerator<>();
		Student student = 
				studentGenerator.generatePopulatedObject(Student.class);
		
		assertTrue(Constants.firstNames.contains(student.firstName));
		assertTrue(Constants.lastNames.contains(student.lastName));
		assertEquals(student.firstName + "." + student.lastName
				+ PersonObjectGenerator.TEST_DOMAIN_COM, student.email);
		assertEquals("homeTown", student.homeTown);		
	}
}
