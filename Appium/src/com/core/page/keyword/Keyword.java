package com.core.page.keyword;
import org.openqa.selenium.By;
import com.core.annotation.ActiveMethod;
import com.core.page.Page;
import com.core.support.base.BaseButton;
import com.core.support.base.BaseInput;
import com.core.support.base.BaseLink;
import com.core.utilities.KeyValue;

public class Keyword extends Page {

	
	/**
	 * Login (All tests start here)
	 */
	/*@ActiveMethod(page = "Keyword", name = "login", author = "JDAPPER", date = "8/1/2016")
	public Keyword login() {
		String homepage = KeyValue.getUrlProperty("HomePage");
		logger.debug("Navigating to URL: " + homepage);
		BaseButton.go(homepage);
		return this;
	}*/
	
	/**
	 * Generate By Element based upon a passed in object type and method value
	 */
	@ActiveMethod(page = "Keyword", name = "generateByObject", author = "JDAPPER", date = "8/1/2016")
	public static By generateByObject(String objectMethodType, String objectMethodValue) {
		By returnedElement = null;
		
		System.out.println("Creating By using paramters: " + objectMethodType + ", " + objectMethodValue);
		switch(objectMethodType.toUpperCase().trim()) {
		
			case "XPATH":
				returnedElement = By.xpath(objectMethodValue);
				break;
				
			case "CSS SELECTOR":
				returnedElement = By.cssSelector(objectMethodValue);
				break;
			
			case "ID":
				returnedElement = By.id(objectMethodValue);
				break;
			
			case "TAG":
				returnedElement = By.tagName(objectMethodValue);
				break;
				
			case "NAME":
				returnedElement = By.name(objectMethodValue);
				break;	
				
			case "CLASS":
				returnedElement = By.className(objectMethodValue);
				break;		
				
			case "LINKTEXT":
				returnedElement = By.linkText(objectMethodValue);
				break;	
	
			default:
				break;
			}
		
		return returnedElement;
	}
	
	/**
	 * Run a webdriver api action based upon a passed in by element, object type and method
	 */
	@ActiveMethod(page = "Keyword", name = "executeAction", author = "JDAPPER", date = "8/1/2016")
	public static Boolean executeAction(By by, String objectType, String actionMethod, String inputValue) {
			
		switch(objectType.toUpperCase().trim()) {
		
			case "BUTTON"://button
				
				if(actionMethod.toUpperCase().trim().equals("CLICK")) {
					try {
						BaseButton.click(by);
						return true;
					} catch (Exception e) {
						return false;
					}
				} else if(actionMethod.toUpperCase().trim().equals("ISENABLED")) {
					try {
						BaseButton.isEnabled(by);
						return true;
					} catch (Exception e) {
						return false;
					}
				} else {
					return false;
				}
				
			case "A"://link
				
				if(actionMethod.toUpperCase().trim().equals("CLICK")) {
					try {
						BaseLink.click(by);
						return true;
					} catch (Exception e) {
						return false;
					}
				} else {
					return false;
				}
					
			case "TEXT"://text input box
				
				if(actionMethod.toUpperCase().trim().equals("SETTEXT")) {
					try {
						BaseInput.setText(by, inputValue);
						return true;
					} catch (Exception e) {
						return false;
					}
				} else if(actionMethod.toUpperCase().trim().equals("ISENABLED")) {
					try {
						BaseInput.isEnabled(by);
						return true;
					} catch (Exception e) {
						return false;
					}
				} else {
					return false;
				}
					
			default:
				break;
			}
		
		return false;
	}

}
