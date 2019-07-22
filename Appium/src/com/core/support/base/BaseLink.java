package com.core.support.base;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.core.support.Core;

import io.appium.java_client.MobileElement;

public class BaseLink extends Core {

	/**
	 * Click on a link
	 * @param by By element representing the link element.
	 */
	public static void click(By by) {
		
		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
			findElement(by).click();	
		}
	}
	
	/**
	 * Get the text of a link element
	 * @param by By element to retrieve text from
	 */
	public static String getText(By by) {

		String 				foundText = "";
		List<MobileElement> 	elements = findElements(by);

		if (!elements.isEmpty()) {
			foundText = findElement(by).getText();
		}
		return foundText;
	}
	
	/**
	 * Get the href attribute of a link element
	 * @param by By element to retrieve href from
	 */
	public static String getURL(By by) {

		String 				foundURL = "";
		List<MobileElement> 	elements = findElements(by);

		if (!elements.isEmpty()) {
			foundURL = getElementAttribute(by, "href");
		}
		return foundURL;
	}
	
	/**
	 * Hover on a button
	 * @param by By element representing the img element.
	 * @throws InterruptedException 
	 */
	public static void hover(By field) throws InterruptedException {
		List<MobileElement> elements = findElements(field);
		
		if (!elements.isEmpty()) {
			WebElement element = findElement(field);
			String javaScript = "var evObj = document.createEvent('MouseEvents');" +
	                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
	                "arguments[0].dispatchEvent(evObj);";

			((JavascriptExecutor)driver).executeScript(javaScript, element);
			
		}
		
	}
	
	/**
	 * Hover on a button
	 * @param by By element representing the img element.
	 * @throws InterruptedException 
	 */
	public static void hoverAndClick(By field, String seletedItem) throws InterruptedException {
		

		List<MobileElement> elements = findElements(field);
		
		if (!elements.isEmpty()) {
			WebElement element = findElement(field);
			WebElement menuOption = driver.findElement(By.xpath(seletedItem));
			Actions action = new Actions(driver);
			action.moveToElement(element).click(menuOption).build().perform();
		}
	}
}