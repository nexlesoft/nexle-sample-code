package com.core.test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.apache.log4j.PropertyConfigurator;
import org.apache.tools.ant.types.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;
import com.core.Driver;
import com.core.gurock.testrail.APIException;
import com.core.utilities.KeyValue;
import com.core.utilities.RetryRule;
import com.core.utilities.Screenshot;
import com.core.utilities.XMLReader;
import com.core.utilities.util_TestRail;
import com.core.utilities.util_TestWatcher;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;

public abstract class BaseTest extends util_TestWatcher{
	
    protected static XMLReader 	xmlReader;
    protected String 			className = this.getClass().getSimpleName();
	private final Logger 		logger = Logger.getLogger(className);
    protected AppiumDriver<MobileElement> 		driver;
    
    @Rule
    public TestName 			testName = new TestName();
          
  //Set rule to re-run for another 1 time after the first failed
    @Rule
    public RetryRule retryRule = new RetryRule(2);
    
    @Before
    public void initializeTest() throws IOException, URISyntaxException {   	
    	
    	PropertyConfigurator.configure("resources/log4j.properties");
    	logger.info(className);
        KeyValue.setGeneralProperty("CurrentTestName", testName.getMethodName());
        xmlReader = new XMLReader(className);
        driver = Driver.initialize(driver); 
    }
    
    @After
    public void tearDownTest() throws ParseException {
    	
        Screenshot.takeScreenShot(driver, testName.getMethodName());
        Driver.terminate(driver);   
    }
    
    /**
     * Method to close browser (terminate driver) and re-open a new browser
     * @throws ParseException
     * @throws IOException
     * @throws URISyntaxException
     * @throws APIException 
     */
    public void restartDriver() throws ParseException, IOException, URISyntaxException, APIException {   	
        this.tearDownTest();
    	this.initializeTest();
    }
    
}
