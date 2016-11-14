package com.jenerator.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {
	public static final List<String> firstNames = 
			Collections.unmodifiableList(Arrays.asList(
					"Andrei", "Mihai", "John", "Jimmy", "Michael"
					));
	
	public static final List<String> lastNames = 
			Collections.unmodifiableList(Arrays.asList(
					"Ionescu", "Popescu", "Faraday", "White", "Bolton"
					));
			
}
