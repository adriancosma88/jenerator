package com.jenerator.generators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.jenerator.generators.DefaultObjectGenerator;
import com.jenerator.generators.ObjectGenerator;
import com.jenerator.generators.testObjects.DateHolder;
import com.jenerator.generators.testObjects.DoubleHolder;
import com.jenerator.generators.testObjects.IntHolder;
import com.jenerator.generators.testObjects.Person;

public class DefaultGeneratorTestCase {
	private static final String FIRST_NAME = "firstName";

	@Test
	public void testStringGenerator_shouldGenerateValueFromFieldName() throws Exception {
		ObjectGenerator<Person> personGenerator = new DefaultObjectGenerator<>();
		Person person = personGenerator.generateTestObject(Person.class);
		
		assertEquals("firstName should have the value \"firstName\"", 
				FIRST_NAME, person.getFirstName());
	}
	
	@Test
	public void testIntegerGenerator_shouldGenerateBoundedRandomInt() {
		ObjectGenerator<IntHolder> integerGenerator = new DefaultObjectGenerator<>();
		IntHolder intHolder = integerGenerator.generateTestObject(IntHolder.class);
		
		assertTrue("Integer generated value [" + intHolder.getTestInt()
				+ "] should be in the interval [1, 100).", 
				DefaultObjectGenerator.MIN_INT <= intHolder.getTestInt()
				&& intHolder.getTestInt() < DefaultObjectGenerator.MAX_INT);
	}
	
	@Test
	public void testDoubleGenerator_shouldGenerateBoundedRandomDouble() {
		ObjectGenerator<DoubleHolder> doubleGenerator = new DefaultObjectGenerator<>();
		DoubleHolder doubleHolder = doubleGenerator.generateTestObject(DoubleHolder.class);
		
		assertTrue("Double generated value [" +  doubleHolder.getTestDouble()
				+ "] should be in the interval [1, 100)",
				DefaultObjectGenerator.MIN_DOUBLE <= doubleHolder.getTestDouble() 
				&& doubleHolder.getTestDouble() < DefaultObjectGenerator.MAX_DOUBLE);
	}
	
	@Test
	public void testDateGenerator_shouldGenerateBoundedDate() {
		ObjectGenerator<DateHolder> dateGenerator = new DefaultObjectGenerator<>();
		DateHolder dateHolder = dateGenerator.generateTestObject(DateHolder.class);
		
		Date now = GregorianCalendar.getInstance().getTime();
		
		assertTrue("Date generated value [" +  dateHolder.getTestDate()
				+ "] should be in the interval [1, 100)",
		dateHolder.getTestDate().before(now));
	}
	
	@Test
	public void test() {
	}
}
