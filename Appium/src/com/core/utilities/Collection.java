package com.core.utilities;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

public class Collection {
	
	private final static Logger logger = Logger.getLogger(Convert.class.getName());

    /**
     * Get the difference between two arrays
     * @param 	arrayOne First array
     * @param 	arrayTwo Second array
     * @return 	The difference as a Set
     */
    public static Set<String> getArrayDifference(String[] arrayOne, String[] arrayTwo) { 
    	
		logger.debug("Returning the difference between two arrays");
        Set<String> base = new HashSet<String>(Arrays.asList(arrayOne));
        base.addAll(Arrays.asList(arrayTwo));
        
        Set<String> intersection = new HashSet<String>(Arrays.asList(arrayOne));
        intersection.retainAll(Arrays.asList(arrayTwo));
        base.removeAll(intersection);
        
        return base;
    }
    
    /**
     * Get the intersection between two arrays
     * @param 	arrayOne First array
     * @param 	arrayTwo Second array
     * @return 	The intersection as a Set
     */
    public static Set<String> getArrayIntersection(String[] arrayOne, String[] arrayTwo) {    
    	
		logger.debug("Returning the intersection between two arrays");
        Set<String> setOne = new HashSet<String>(Arrays.asList(arrayOne));
        Set<String> setTwo = new HashSet<String>(Arrays.asList(arrayTwo));
        setOne.retainAll(setTwo);
        
        String[] result = setOne.toArray(new String[setOne.size()]);
        Set<String> base = new HashSet<String>(Arrays.asList(result));
        
        return base;
    }
    
    /**
     * Get the union between two arrays
     * @param 	arrayOne First array
     * @param 	arrayTwo Second array
     * @return 	The union as a Set
     */
    public static Set<String> getArrayUnion(String[] arrayOne, String[] arrayTwo) {      
    	
		logger.debug("Returning the union between two arrays");
        Set<String> setOne = new HashSet<String>(Arrays.asList(arrayOne));
        Set<String> setTwo = new HashSet<String>(Arrays.asList(arrayTwo));
        setOne.addAll(setTwo);
        
        String[] result = setOne.toArray(new String[setOne.size()]);
        Set<String> base = new HashSet<String>(Arrays.asList(result));
        
        return base;
    }
    
    /**
     * Sort a List alphabetically
     * @param 	element Name of passed in List object
     * @return  Alphabetized List object
     */
    public static List<String> sortListAlphabetically(List<String> element) {
		logger.debug("Sorting a List element alphabetically");
        Collections.sort(element);
        return element;
    }
    
    /**
     * Trim all elements within an array
     * @param 	elements Array of strings
     * @return 	Trimmed Array object
     */
    public static String[] trimArray(String[] elements) { 
    	
		logger.debug("Trimming all elements within an array");
        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i].trim();
        }
        return elements;
    }
}