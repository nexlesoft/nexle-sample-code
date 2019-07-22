package com.core.support.base;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.support.Core;

import io.appium.java_client.MobileElement;

public class BaseList extends Core {

	/**
	 * Click li element within an unordered list
	 * @param by By element representing the unordered list (ul) element
	 * @param value Value to select from the list
	 */
	public static void click(By by, String value) {
		
		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
			WebElement parent = findElement(by);
			List<WebElement> listElements = parent.findElements(By.tagName("li"));
			
			for (WebElement li : listElements) {
				if(li.getText().equalsIgnoreCase(value)) {
					li.click();
					break;
				}
			}	
		}
	}
	
	/**
	 * Get li elements within an unordered list
	 * @param by By element representing the unordered list (ul) element
	 */
	public static List<MobileElement> getListItems(By by) {
		
		List<MobileElement> 	listElements = new ArrayList<MobileElement>();
		List<MobileElement> 	elements = findElements(by);

		if (!elements.isEmpty()) {
			MobileElement parent = findElement(by);
			listElements = parent.findElements(By.tagName("li"));
		}
		return listElements;
	}
}