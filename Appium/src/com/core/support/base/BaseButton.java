package com.core.support.base;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.core.support.Core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BaseButton extends Core {

	/**
	 * Determine whether an element is enabled
	 * @param by By element to retrieve text from
	 */
	public static boolean isEnabled(By by) {

		boolean 			enabled = false;
		List<MobileElement> 	elements = findElements(by);

		if (!elements.isEmpty()) {
			if(findElementIgnoreError(by).isEnabled()) {
				enabled = true;
			} else {
				enabled = false;
			}
		}
		return enabled;
	}
	
	/**
	 * Get the value of an input element
	 * @param by By element to retrieve text from
	 */
	public static String getText(By by) {

		String 				foundText = "";
		List<MobileElement> 	elements = findElements(by);

		if (!elements.isEmpty()) {
			foundText = getElementText(by);
		}
		
		return foundText;
	}
	
	/**
	 * Set the value of an input element
	 * @param 	element By element to enter a value into
	 * @param 	value Value to enter into the element
	 */
	public static void setText(By by, String value) {

		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
			findElement(by).clear();
			findElement(by).sendKeys(value);
		}
	}
	
	/**
	 * Click on an element
	 * @param by By element representing the field element.
	 */
	public static void click(By by) {
		
		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
			WebElement element = findElement(by);
			Actions action = new Actions(driver);
			action.click(element);
		}
	}
	
	/**
	 * Tap on an element
	 * @param by By element representing the field element.
	 */
	public static void tap(By by) {
		
		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
			WebElement element = findElement(by);
			TouchAction action = new TouchAction(driver);
			action.tap(element).perform();
		}
	}
	
	
	/**
	 * Press on an element
	 * @param by By element representing the field element.
	 */
	public static void press(By by) {
		
		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
			WebElement element = findElement(by);
			TouchAction action = new TouchAction(driver);
			action.press(element).perform();
		}
	}
	
	/**
	 * Long Press on an element
	 * @param by By element representing the field element.
	 */
	public static void longPress(By by) {
		
		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
			WebElement element = findElement(by);
			TouchAction action = new TouchAction(driver);
			action.longPress(element).perform();
		}
	}
	
	public static void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {

		Dimension size = driver.manage().window().getSize();

		int anchor = (int) (size.width * anchorPercentage);

		int startPoint = (int) (size.height * startPercentage);

		int endPoint = (int) (size.height * finalPercentage);

		new TouchAction(driver).press(anchor, startPoint).waitAction(duration).moveTo(anchor, endPoint).release().perform();

	}
	
	public static void swipeHorizontal(double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {

		Dimension size = driver.manage().window().getSize();

		int anchor = (int) (size.height * anchorPercentage);

		int startPoint = (int) (size.width * startPercentage);

		int endPoint = (int) (size.width * finalPercentage);

		new TouchAction(driver).press(startPoint, anchor).waitAction(duration).moveTo(endPoint, anchor).release().perform();

	}
	
}