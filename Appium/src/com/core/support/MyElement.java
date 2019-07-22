package com.core.support;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.core.utilities.KeyValue;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MyElement {
	
	protected static AppiumDriver<MobileElement> 				driver;
	protected By by;
    public final Logger 					logger = Logger.getLogger(this.getClass());
    
    public By getElement(String value) {
    	String driverType = KeyValue.getGeneralProperty("DriverType");
    	if(driverType.equals("android")){
    		this.by = By.xpath(KeyValue.getAndroidElementsProperty(value));
    	}if(driverType.equals("ios")){
    		this.by = By.xpath(KeyValue.getIOSElementsProperty(value));
    	}
		
    	return by;

	}
    
    public MyElement() {}
    
    public By getXPath(String value) {
		return this.by;

	}

	public By getBy() {
		return by;
	}
}

