package com.core.support.base;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.core.support.Core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BaseInput extends Core {

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
			action.click(element).build().perform();
		}
	}
	
	/**
	 * Set the value of an input element inside an inline edit div
	 * @param 	element By element to enter a value into
	 * @param 	value Value to enter into the element
	 */
	public static void setTextInlineEdit(By field, By input, String value) {

		List<MobileElement> elements = findElements(field);
		
		if (!elements.isEmpty()) {
			MobileElement element = findElement(field);
			Actions action = new Actions(driver);
			action.moveToElement(element).doubleClick().build().perform();
			findElement(input).clear();
			findElement(input).sendKeys(value);
		}
	}
}