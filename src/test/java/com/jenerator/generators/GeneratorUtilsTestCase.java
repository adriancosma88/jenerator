package com.jenerator.generators;

import static com.jenerator.utils.GeneratorsUtils.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeneratorUtilsTestCase {
	@Test
	public void testRandomIntGenerator() {
		int minInt = 10;
		int maxInt = 200;
		int generated = getRandomInt(minInt, maxInt);
		
		assertTrue(minInt <= generated && generated < maxInt);
	}
	
	@Test
	public void testRandomDoubleGenerator() {
		double minDouble = 10.0;
		double maxDouble = 200.0;
		double generated = getRandomDouble(minDouble, maxDouble);
		
		assertTrue(minDouble <= generated && generated < maxDouble);
	}
	
	@Test
	public void testIsStringAttribute() {
		assertTrue(isStringAttribute("java.lang.string"));
		assertTrue(isStringAttribute("java.lang.String"));
		assertFalse(isStringAttribute("java.lang.double"));
		assertFalse(isStringAttribute(""));
		assertFalse(isStringAttribute(null));
	}
	
	@Test
	public void testIsDoubleAttribute() {
		assertTrue(isDoubleAttribute("double"));
		assertTrue(isDoubleAttribute("Double"));
		assertFalse(isDoubleAttribute("java.lang.double"));
		assertFalse(isDoubleAttribute(""));
		assertFalse(isDoubleAttribute(null));
	}
}
