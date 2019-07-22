package com.core;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.core.support.Core;
import com.core.utilities.KeyValue;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Driver {
	 
    /**
     * Set the driver object and it's associated properties
     * @return The driver object to be used for the test run
     */
    public static AppiumDriver<MobileElement> initialize(AppiumDriver<MobileElement> driver) throws IOException, URISyntaxException {
       
    	String url = KeyValue.getUrlProperty("url");
    	String driverType = KeyValue.getGeneralProperty("DriverType");
    	if(driverType.equals("android")){
    		driver = new AndroidDriver<MobileElement>(new URL(url), getAndroidCapability());
    	}else if(driverType.equals("ios")){
    		driver = new IOSDriver<MobileElement>(new URL(url), getIOSCapability());
    	}
        
       
 
        Core.setDriver(driver);
        return driver;
    }
   

    /**
     * Set capabilities for Android
     * @return DesiredCapabilities object used upon the launch of Android
     */
    private static DesiredCapabilities getAndroidCapability() {
       
        String deviceName = KeyValue.getAndroidProperty("deviceName");
        String udid = KeyValue.getAndroidProperty("udid");
        String platformName = KeyValue.getAndroidProperty("platformName");
        String platformVersion = KeyValue.getAndroidProperty("platformVersion");
        String skipUnlock = KeyValue.getAndroidProperty("skipUnlock");
        String appPackage = KeyValue.getAndroidProperty("appPackage");
        String appActivity = KeyValue.getAndroidProperty("appActivity");
        String noReset = KeyValue.getAndroidProperty("noReset");
        
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("skipUnlock", skipUnlock);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("noReset", noReset);
       
        return capabilities;
    }
    
    /**
     * Set capabilities for iOS
     * @return DesiredCapabilities object used upon the launch of iOS
     */
    private static DesiredCapabilities getIOSCapability() {
       
        String deviceName = KeyValue.getAndroidProperty("deviceName");
        String udid = KeyValue.getAndroidProperty("udid");
        String platformName = KeyValue.getAndroidProperty("platformName");
        String platformVersion = KeyValue.getAndroidProperty("platformVersion");
        String xcodeOrgId = KeyValue.getAndroidProperty("xcodeOrgId");
        String xcodeSigningId = KeyValue.getAndroidProperty("xcodeSigningId");
        String automationName = KeyValue.getAndroidProperty("automationName");
        String ipa = KeyValue.getAndroidProperty("ipa");
        String bundleId = KeyValue.getAndroidProperty("bundleId");
        String newCommandTimeout = KeyValue.getAndroidProperty("newCommandTimeout");
        String showXcodeLog = KeyValue.getAndroidProperty("showXcodeLog");
        String noReset = KeyValue.getAndroidProperty("noReset");
        
        DesiredCapabilities capabilities = DesiredCapabilities.ipad();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("xcodeOrgId", xcodeOrgId);
        capabilities.setCapability("xcodeSigningId", xcodeSigningId);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("ipa", ipa);
        capabilities.setCapability("bundleId", bundleId);
        capabilities.setCapability("newCommandTimeout", newCommandTimeout);
        capabilities.setCapability("showXcodeLog", showXcodeLog);
        capabilities.setCapability("noReset", noReset);
       
        return capabilities;
    }
    
    /**
     * Destroy the driver object
     * @param clearCookies Determine whether cookies should be deleted before closing
     */
    public static void terminate(AppiumDriver<MobileElement> driver) {
       
        driver.closeApp();
    }
}