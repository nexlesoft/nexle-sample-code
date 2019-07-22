package com.core.page.sportstg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.core.annotation.ActiveMethod;
import com.core.page.Page;
import com.core.support.Core;
import com.core.support.MyElement;
import com.core.support.base.BaseButton;
import com.core.support.base.BaseInput;
import com.core.support.base.BaseLink;

import static org.junit.Assert.assertEquals;

public class CourtsideLogin extends Page {
	
	private static CourtsideLogin instance;
	public static CourtsideLogin Instance = (instance != null) ? instance : new CourtsideLogin();
    
	public CourtsideLogin(){}
    
	MyElement myElement = new MyElement(); 
    /** UI Mappings */
	
	By titleLocator = myElement.getElement("titleLocator");
    By courtIDLocator = myElement.getElement("courtIDLocator");
    By setupIDLocator = myElement.getElement("setupIDLocator");
    By changeLinkLocator = myElement.getElement("changeLinkLocator");
    By adminLocator = myElement.getElement("adminLocator");
    By settingsLocator = myElement.getElement("settingsLocator");
    By clearAllTextLocator = myElement.getElement("clearAllTextLocator");
    By clearAllNotificationLocator = myElement.getElement("clearAllNotificationLocator");
    By changeCourtTextLocator = myElement.getElement("changeCourtTextLocator");
    By invalidLoginTextLocator = myElement.getElement("invalidLoginTextLocator");
    
    /** Page Methods */
    
	/**
	 * Set value in Court ID field on Login page.
	 * @param strCourtID - Court ID to enter into the login form.
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "setCourtID", author = "Thanh Phan", date = "5/14/2018")
	public CourtsideLogin setCourtID(String strCourtID) {
		logger.debug("Setting the Court ID field to: " + strCourtID);
		BaseInput.setText(courtIDLocator, strCourtID);
		
		return this;
	}
	
	
	/**
	 * Set value in Setup ID field on Login page.
	 * @param strSetupID - Setup ID to enter into the login form.
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "setSetupID", author = "Thanh Phan", date = "5/14/2018")
	public CourtsideLogin setSetupID(String strSetupID) {
		logger.debug("Setting the Setup ID field to: " + strSetupID);
		BaseInput.setText(setupIDLocator, strSetupID);
		
		return this;
	}
	
	
	/**
	 * Click 'Change' link on Login Page
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "clickChangeLink", author = "Thanh Phan", date = "5/14/2018")
	public CourtsideLogin clickChangeLink() {
		logger.debug("Clicking 'Change' link on Login Form");
		
		BaseButton.tap(changeLinkLocator);
		
		return this;
	}
	
	/**
	 * Press ENTER key from keyboard
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "pressEnterKey", author = "Thanh Phan", date = "5/14/2018")
	public CourtsideLogin pressEnterKey() {
		logger.debug("Press Enter key");
		
		Core.pressEnterKey();
		
		this.synchronizeWait(changeLinkLocator, 0, 360);
		
		return this;
	}
	
	
	/**
	 * Login
	 * @throws InterruptedException 
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "login", author = "Thanh Phan", date = "5/15/2018")
	public CourtsideLogin login(String courtsideID, String setupID) throws InterruptedException {
		logger.debug("Login to the system");
		this.synchronizeLongLoadingPage();
		this.verifyLoginPopupTitle("Enter Court & Setup ID");
		
		this.setCourtID(courtsideID);
		this.setSetupID(setupID);
		this.clickChangeLink();
		
		return this;
	}
	
	/**
	 * Verify Header title on Detail page
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "verifyDetailPageTitle", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideLogin verifyHeaderTitle(String strTitle)
	{	 
		By headerLocator = By.xpath("//android.widget.FrameLayout[contains(@resource-id,'android:id/content')]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]");
		String actualValue = Core.getElementAttribute(headerLocator, "text", 1);
		logger.debug("Verifying the actual Detail Page Title as '" + actualValue + "'");
		assertEquals(strTitle, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Login title on Login page
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "verifyLoginPopupTitle", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideLogin verifyLoginPopupTitle(String strTitle)
	{	 
		
		String actualValue = Core.getElementAttribute(titleLocator, "text", 1);
		logger.debug("Verifying the Login popup title as '" + actualValue + "'");
		assertEquals(strTitle, actualValue);
		
		return this;
	}
	
	/**
	 * Logout
	 * @throws InterruptedException 
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "logout", author = "Thanh Phan", date = "5/15/2018")
	public CourtsideLogin logout() throws InterruptedException {
		logger.debug("Logout to the system");
		this.synchronizePage();
		BaseButton.tap(adminLocator);
		this.synchronizePage();
		BaseButton.tap(settingsLocator);
		this.synchronizePage();
		BaseLink.click(clearAllTextLocator);
		this.synchronizePage();
		BaseButton.tap(clearAllNotificationLocator);
		this.synchronizeLongLoadingPage();
		this.verifyLoginPopupTitle("Enter Court & Setup ID");
		
		return this;
	}
	
	
	/**
	 * change court
	 * @throws InterruptedException 
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "changeCourt", author = "Thanh Phan", date = "5/15/2018")
	public CourtsideLogin changeCourt() throws InterruptedException {
		logger.debug("Logout to the system");
		this.synchronizeLongLoadingPage();
		BaseButton.tap(adminLocator);
		this.synchronizePage();
		BaseButton.tap(settingsLocator);
		this.synchronizePage();
		BaseLink.click(changeCourtTextLocator);
		this.synchronizePage();
		this.verifyLoginPopupTitle("Enter Court & Setup ID");
		
		return this;
	}
	
	/**
	 * Verify text when login with invalid data
	 * @param strText
	 * @return
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "verifyDetailPageTitle", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideLogin verifyErrorMsgInvalidLogin(String strText)
	{	 
		String actualValue = Core.getElementAttribute(invalidLoginTextLocator, "text", 1);
		logger.debug("Verifying the actual Invalid text when login as '" + actualValue + "'");
		assertEquals(strText, actualValue);
		
		return this;
	}
	
	/**
	 * Login in iOS platform
	 * @throws InterruptedException 
	 */
	@ActiveMethod(page = "CourtsideLogin", name = "login", author = "Thanh Phan", date = "6/21/2018")
	public CourtsideLogin loginIOSDevice(String courtsideID, String setupID) throws InterruptedException {
		logger.debug("Login to the system");
		this.synchronizeLongLoadingPage();
		this.verifyLoginPopupTitle("Enter Court & Setup ID");
		
		Core.pressEnter(courtsideID);
		Core.pressReturnFromKeyboard();
		Core.pressEnter(setupID);
		Core.pressEnterFromKeyboard();
		
		return this;
	}
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideLogin", name = "synchronizePage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideLogin synchronizePage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeSportsTG();
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideLogin", name = "synchronizeLongLoadingPage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideLogin synchronizeLongLoadingPage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeLongLoadingSportsTG(10,720);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideLogin", name = "synchronizeLongLoadingPage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideLogin synchronizeLongLoadingPageForLogin() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeLongLoadingSportsTG(10,36000);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideLogin", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideLogin synchronizeWait(By by, int visibleTimeOut, int invisibleTimeOut) {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeWait(by, visibleTimeOut, invisibleTimeOut);
        return this;
    }
}
