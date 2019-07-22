package com.core.utilities;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class KeyValue {

    private final static Logger logger = Logger.getLogger(KeyValue.class.getName());

    /**
     * Get a key value from the general properties file
     * @param	key Value to request
     * @return	Requested value
     */
    public static String getGeneralProperty(String key) {
    	
    	String generalFileName = "general.properties";
    	return getValueFromPropertyFile(generalFileName, key);
    }
    
    /**
     * Get a key value from the specific general properties file
     * @param	key Value to request
     * @return	Requested value
     */
    public static String getGeneralProperty(String key, String app) {
    	
    	String generalFileName="";
    	if(app.equalsIgnoreCase("OST"))
    	{
    		generalFileName = "OST_general.properties";
    	}else if(app.equalsIgnoreCase("FSP"))
    	{
    		generalFileName = "FSP_general.properties";
    	}else if(app.equalsIgnoreCase("Classic"))
    	{
    		generalFileName = "Classic_general.properties";
    	}else
    	{
    		generalFileName = "general.properties";
    	}
 
    	return getValueFromPropertyFile(generalFileName, key);
    }
    
    /**
     * Get a key value from the timeout properties file
     * @param 	key Value to request
     * @return  Requested value
     */
    public static String getTimeoutProperty(String key) {
    	
    	String timeoutFileName = "timeout.properties";
    	return getValueFromPropertyFile(timeoutFileName, key);
    }
    
    /**
     * Get a key value from the grid properties file
     * @param 	key Value to request
     * @return  Requested value
     */
    public static String getGridProperty(String key) {
    	
    	String gridFileName = "grid.properties";
    	return getValueFromPropertyFile(gridFileName, key);
    }
    
    
    
    /**
     * Get a key value from the url properties file
     * @param 	key Value to request
     * @return  Requested value
     */
    public static String getUrlProperty(String key) {
    	String databaseFileName="url.properties";
    	
    	String env = KeyValue.getGeneralProperty("Environment");
    	    	
    	return getValueFromPropertyFile(databaseFileName, key);
    	
    	}
    
    /**
     * Get a key value from the 'OST_url.properties' file
     * @param 	key Value to request
     * @return  Requested value
     */
    public static String getUrlProperty_OST(String key) {
    	String databaseFileName = "OST_url.properties";	
    	return getValueFromPropertyFile(databaseFileName, key);	
    }
    
    /**
     * Get a key value from the iframe properties file
     * @param 	key Value to request
     * @return  Requested value
     */
    public static String getIframeProperty(String key) {
    	
    	String databaseFileName = "iframe.properties";
    	return getValueFromPropertyFile(databaseFileName, key);
    }
    /**
     * Get a key value from the iframe cache properties file
     * @param 	key Value to request
     * @return  Requested value
     */
    public static String getIframeCacheProperty(String key) {
    	
    	String databaseFileName = "iframecache.properties";
    	return getValueFromPropertyFile(databaseFileName, key);
    }
    
    /**
     * Get a value from a properties file
     * @param 	fileName File to read
     * @param 	key Key to read
     * @return  The key's value
     */
    private static String getValueFromPropertyFile(String fileName, String key) {
    	
        String 		propertyValue = "";        
    	Properties 	properties = new Properties();
    	    
        try {
        	properties.load(KeyValue.class.getClassLoader().getResourceAsStream((fileName)));
        	propertyValue = properties.getProperty(key);
        	logger.debug("Retrieved key value from property file. File=" + fileName + ", Key=" + key + ", Value=" + propertyValue);
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to access properties file: " + fileName);
            
        } catch (IOException f) {
            f.printStackTrace();
            throw new RuntimeException("Found the properties file but could access it");
        } 
        return propertyValue;
    }
    
    /**
     * Set a key value in the general properties file
     * @param 	key Key to set
     * @param 	value Value the key will be set to
     */
    public static void setGeneralProperty(String key, String value) {
    	
    	String fileName = "resources/general.properties";
    	setValueInPropertyFile(fileName, key, value);
    }
    
    /**
     * Set a key value in the timeout properties file
     * @param 	key Key to set
     * @param 	value Value the key will be set to
     */
    public static void setTimeoutProperty(String key, String value) {
    	
    	String fileName = "resources/timeout.properties";
    	setValueInPropertyFile(fileName, key, value);
    }
    
    /**
     * Set a key value in the grid properties file
     * @param 	key Key to set
     * @param 	value Value the key will be set to
     */
    public static void setGridProperty(String key, String value) {
    	
    	String fileName = "resources/grid.properties";
    	setValueInPropertyFile(fileName, key, value);
    }
    
    /**
     * Set a key value in the database properties file
     * @param 	key Key to set
     * @param 	value Value the key will be set to
     */
    public static void setDatabaseProperty(String key, String value) {
    	
    	String fileName = "resources/database.properties";
    	setValueInPropertyFile(fileName, key, value);
    }
    
    /**
     * Set a key value in the url properties file
     * @param 	key Key to set
     * @param 	value Value the key will be set to
     */
    public static void setUrlProperty(String key, String value) {
    	
    	String fileName = "resources/url.properties";
    	setValueInPropertyFile(fileName, key, value);
    }
    
    /**
     * Set a key value in the iframe properties file
     * @param 	key Key to set
     * @param 	value Value the key will be set to
     */
    public static void setIframeProperty(String key, String value) {
    	
    	String fileName = "resources/iframe.properties";
    	setValueInPropertyFile(fileName, key, value);
    }
    
    /**
     * Set a key value in the iframe cache properties file
     * @param 	key Key to set
     * @param 	value Value the key will be set to
     */
    public static void setIframeCacheProperty(String key, String value) {
    	
    	String fileName = "resources/iframecache.properties";
    	setValueInPropertyFile(fileName, key, value);
    }
   
    /**
     * Set a value within a property file
     * @param 	key Key to set
     * @param 	value Value the key to will be set to
     * @param 	fileName File name of the .property file to access (must reside within resources folder)
     */
    public static void setValueInPropertyFile(String fileName, String key, String value) {
        
    	Properties 	properties = new Properties();
		File		propertiesFile = new File(fileName);
	
		try {
		    properties.load(new FileInputStream(propertiesFile));
		    properties.setProperty(key, value);
		    properties.store(new FileOutputStream(propertiesFile), "");  
        	logger.debug("Set property key value in property file. File=" + fileName + ", Key=" + key + ", Value=" + value);
		} catch (NullPointerException e) {
			e.printStackTrace();
		    throw new RuntimeException("Unable to access properties file: " + fileName);
		} catch (IOException f) {
			f.printStackTrace();
		    throw new RuntimeException("Found the properties file but could access key. File=" + fileName +", Key=" + key);
		}
    }    
    
    /**
     * Get a key value from the database properties file
     * @param 	key Value to request
     * @return  Requested value
     */
    public static String getDatabaseProperty(String key) {
    	
    	String databaseFileName = "database.properties";
    	return getValueFromPropertyFile(databaseFileName, key);
    }
    
    /**
     * Get a key value from the android properties file
     * @param	key Value to request
     * @return	Requested value
     */
    public static String getAndroidProperty(String key) {
    	
    	String generalFileName = "android.properties";
    	return getValueFromPropertyFile(generalFileName, key);
    }
    
    /**
     * Get a key value from the ios properties file
     * @param	key Value to request
     * @return	Requested value
     */
    public static String getIOSProperty(String key) {
    	
    	String generalFileName = "ios.properties";
    	return getValueFromPropertyFile(generalFileName, key);
    }
    
    /**
     * Get a key value from the Android Elements properties file
     * @param	key Value to request
     * @return	Requested value
     */
    public static String getAndroidElementsProperty(String key) {
    	
    	String generalFileName = "AndroidElements.properties";
    	return getValueFromPropertyFile(generalFileName, key);
    }
    
    /**
     * Get a key value from the iOS Elements properties file
     * @param	key Value to request
     * @return	Requested value
     */
    public static String getIOSElementsProperty(String key) {
    	
    	String generalFileName = "IOSElements.properties";
    	return getValueFromPropertyFile(generalFileName, key);
    }
}
