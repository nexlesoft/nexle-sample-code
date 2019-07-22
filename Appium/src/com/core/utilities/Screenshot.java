package com.core.utilities;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Screenshot {
	
    private final static Logger logger = Logger.getLogger(KeyValue.class.getName());

    /**
     * Take a screenshot of the current page
     * @param className Name of the current test class
     */
    public static void takeScreenShot(WebDriver driver, String className) {
    	
    	logger.debug("Screenshot taken for test: " + className);
        boolean databaseEnabled = Boolean.parseBoolean(KeyValue.getDatabaseProperty("Enabled"));
        
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(KeyValue.getGeneralProperty("ScreenshotDirectory") + className);
            
            if (databaseEnabled == true) {
            	MySQL.serializeImage(screenshot);
            }
            
            FileUtils.copyFileToDirectory(screenshot, destination);
            screenshot.delete();
        } 
        catch (WebDriverException e) {
            e.printStackTrace();
        } 
        catch (IOException f) {
            f.printStackTrace();
        } 
        catch (ParseException p) {
            p.printStackTrace();
        }
        
    } 
}
