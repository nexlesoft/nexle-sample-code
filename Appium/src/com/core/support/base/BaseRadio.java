package com.core.support.base;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.support.Core;

import io.appium.java_client.MobileElement;

public class BaseRadio extends Core {

	/**
	 * Click a radio input type
	 * @param by Input element
	 */
	public static void click(By by) {
		
		List<MobileElement> elements = findElements(by);

		if (!elements.isEmpty()) {
				findElement(by).click();
		}
	}
	
	/**
	 * Determine if a radio is selected or not
	 * @param by Input element
	 */
	public static boolean getSelectedStatus(By by) {
		
		boolean 			status = false;
		List<MobileElement> 	elements = findElements(by);

		if (!elements.isEmpty()) {
			if (findElement(by).isSelected()) {
				status = true;
			} else {
				status = false;
			}
		}
		return status;
	}
}