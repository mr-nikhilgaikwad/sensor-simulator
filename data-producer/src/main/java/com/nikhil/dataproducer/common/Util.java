package com.nikhil.dataproducer.common;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Util {
	public static String getISODate() { 
		// Define the desired date-time format 
		var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS") 
				.withZone(ZoneOffset.UTC);  
		return formatter.format(Instant.now());
	}
}
