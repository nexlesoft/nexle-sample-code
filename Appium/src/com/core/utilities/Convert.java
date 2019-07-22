package com.core.utilities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.log4j.Logger;

public class Convert {  
	
	private final static Logger logger = Logger.getLogger(Convert.class.getName());

	/**
	 * Convert a HashSet to Array
	 * @param 	value HashSet to be converted
	 * @return 	Array object
	 */
	public static String[] hashSetToArray(HashSet<String> value) {
		logger.debug("Converting HashSet to String Array");
		return value.toArray(new String[value.size()]);	
	}
	
	/**
	 * Convert a List to Array
	 * @param 	value List to be converted
	 * @return 	Array object
	 */
	public static String[] listToArray(List<String> value) {
		logger.debug("Converting String List to String Array");
		return value.toArray(new String[value.size()]);	
	}
	
	/**
	 * Convert a Set to Array
	 * @param 	value Set to be converted
	 * @return 	Array object
	 */
	public static String[] setToArray(Set<String> value) {
		logger.debug("Converting Set to String Array");
		return value.toArray(new String[value.size()]);	
	}
	
	/**
	 * Convert a String to Date
	 * @param 	value String to be converted
	 * @return 	Date object
	 */
	public static Date stringToDate(String value) throws ParseException {
		logger.debug("Converting value to date in format M/d/yyyy: " + value);
		Date date = new SimpleDateFormat("M/d/yyyy", Locale.ENGLISH).parse(value);
		return date;
	}
}