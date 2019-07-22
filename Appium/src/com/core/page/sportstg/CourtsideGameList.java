package com.core.page.sportstg;
import org.openqa.selenium.By;
import com.core.annotation.ActiveMethod;
import com.core.page.Page;
import com.core.support.Core;
import com.core.support.MyElement;
import com.core.support.commonLocator;
import com.core.support.base.BaseButton;
import com.core.support.base.BaseInput;
import com.core.support.base.BaseLink;
import com.core.utilities.KeyValue;

import static org.junit.Assert.assertEquals;

public class CourtsideGameList extends Page {
	
	private static CourtsideGameList instance;
	public static CourtsideGameList Instance = (instance != null) ? instance : new CourtsideGameList();
    
	public CourtsideGameList(){}
	
	MyElement myElement = new MyElement(); 
    
    /** UI Mappings */
	
    By dateDisplayedLocator = myElement.getElement("dateDisplayedLocator");
    By startTimeLocator = myElement.getElement("startTimeLocator");
    By teamsLocator = myElement.getElement("teamsLocator");
    By compLocator = myElement.getElement("compLocator");
    By statusLocator = myElement.getElement("statusLocator");
    By adminBtnLocator = myElement.getElement("adminBtnLocator");
    By onlineTxtLocator = myElement.getElement("onlineTxtLocator");
    By firstGameLocator = myElement.getElement("firstGameLocator");
    By adminLocator = myElement.getElement("adminLocator");
    By settingsLocator = myElement.getElement("settingsLocator");
    By manualSyncLocator = myElement.getElement("manualSyncLocator");
    By firstCheckbox = myElement.getElement("firstCheckbox");
    By syncBtnLocator = myElement.getElement("syncBtnLocator");
    By selectAllBtnLocator = myElement.getElement("selectAllBtnLocator");
    By exportGameFilesBtnLocator = myElement.getElement("exportGameFilesBtnLocator");
    By emailBtnLocator = myElement.getElement("emailBtnLocator");
    By noGameSyncWarningMsg = myElement.getElement("noGameSyncWarningMsg");
    By noGameExportWarningMsg = myElement.getElement("noGameExportWarningMsg");
    By cancelBtnLocator = myElement.getElement("cancelBtnLocator");
    
    /** Page Methods */
    
	/**
	 * Verify displayed date at home page
	 * @param strText
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyDateDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyDateDisplayed(String strText)
	{	 
		String actualValue = Core.getElementAttribute(dateDisplayedLocator, "text", 1);
		logger.debug("Verifying the actual displayed date by today as '" + actualValue + "'");
		assertEquals(strText, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Start Time displayed at home page
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyStartTimeDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyStartTimeDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(startTimeLocator);
		logger.debug("Verifying the start time displayed on home page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Teams displayed at home page
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyTeamsDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyTeamsDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(teamsLocator);
		logger.debug("Verifying the teams displayed on home page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Comp/Assoc displayed at home page
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyCompsDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyCompsDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(compLocator);
		logger.debug("Verifying the comps/assoc displayed on home page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Status displayed at home page
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyStatusDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyStatusDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(statusLocator);
		logger.debug("Verifying the status displayed on home page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Admin button displayed at home page
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyAdminBtnDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyAdminBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(adminBtnLocator);
		logger.debug("Verifying the admin button displayed on home page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Online status displayed at home page
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyOnlineDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyOnlineDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(onlineTxtLocator);
		logger.debug("Verifying the online displayed on home page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Select another date from date dropdownlist
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "selectAnotherDate", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList selectAnotherDate(String anotherDate)
	{	 
		By anotherDateLocator = By.xpath("//android.widget.TextView[contains(@text,'"+anotherDate+"')]");
		logger.debug("Tapping date from calendar");
		BaseButton.tap(dateDisplayedLocator);
		this.synchronizeLongLoadingPage();
		logger.debug("Tapping another date: " + anotherDate);
		BaseButton.tap(anotherDateLocator);
		this.synchronizeLongLoadingPage();
		BaseButton.tap(dateDisplayedLocator);
		this.synchronizePage();
		BaseButton.tap(cancelBtnLocator);
		this.synchronizePage();
		
		
		return this;
	}
	
	/**
	 * Select first game of game list screen
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "selectFirstGame", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameList clickDatePicker()
	{	 
		logger.debug("Tapping date from calendar");
		BaseButton.tap(dateDisplayedLocator);
		
		return this;
	}
	
	/**
	 * Select first game of game list screen
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "selectFirstGame", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameList selectFirstGame()
	{	 
		logger.debug("Selecting first game of game list screen");
		BaseButton.tap(firstGameLocator);
		
		return this;
	}
	
	/**
	 * Click Manual Sync from Admin
	 * @throws InterruptedException 
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "clickManualSync", author = "Thanh Phan", date = "5/15/2018")
	public CourtsideGameList clickManualSync() throws InterruptedException {
		logger.debug("Click Admin button");
		this.synchronizeLongLoadingPage();
		BaseButton.tap(adminLocator);
		this.synchronizeLongLoadingPage();
		logger.debug("Click Manual sync button from Admin");
		BaseButton.tap(manualSyncLocator);
		this.synchronizePage();
		
		return this;
	}
	
	/**
	 * Tagging first checkbox of gamelist
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "checkFirstCheckboxOfGameList", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameList checkFirstCheckboxOfGameList()
	{	 
		logger.debug("Selecting first checkbox of game list screen");
		BaseButton.tap(firstCheckbox);
		
		return this;
	}
	
	/**
	 * Tagging Select All button of game list screen
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "tagSelectAll", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameList tagSelectAll()
	{	 
		logger.debug("Tagging Select All of game list screen");
		BaseButton.tap(selectAllBtnLocator);
		
		return this;
	}
	
	/**
	 * Tagging Sync button of game list screen
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "tagSync", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameList tagSync()
	{	 
		logger.debug("Tagging Sync of game list screen");
		BaseButton.tap(syncBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Export Game Files from Admin
	 * @throws InterruptedException 
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "clickExportGameFile", author = "Thanh Phan", date = "5/15/2018")
	public CourtsideGameList clickExportGameFile() throws InterruptedException {
		logger.debug("Click Admin button");
		this.synchronizePage();
		BaseButton.tap(adminLocator);
		this.synchronizeLongLoadingPage();
		logger.debug("Click Export Game File button from Admin");
		BaseButton.tap(exportGameFilesBtnLocator);
		this.synchronizePage();
		
		return this;
	}
	
	
	/**
	 * Tagging Email button of game list screen
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "tagEmail", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameList tagEmail()
	{	 
		logger.debug("Tagging Email of game list screen");
		BaseButton.tap(emailBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify message when there's no game to sync
	 * @param strText
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyMsgNoGameToSync", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyMsgNoGameToSync()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(noGameSyncWarningMsg);
		logger.debug("Verifying message when there is no game to sync");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify message when there's no game to export
	 * @param strText
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "verifyMsgNoGameToExport", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideGameList verifyMsgNoGameToExport()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(noGameExportWarningMsg);
		logger.debug("Verifying message when there is no game to export");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Click Cancel button at Edit Team Colours screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "clickCancelBtn", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameList clickCancelBtn()
	{	 
		logger.debug("Click Cancel button Change Date popup");
		BaseButton.tap(cancelBtnLocator);
		
		return this;
	}
	
	/**
	 * Click 'Settings' link under Admin 
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "clickSettingsLink", author = "Prabhdeep", date = "8/06/2018")
	public CourtsideGameList clickSettingsLink() {
		logger.debug("Clicking 'Settings' link ");
		BaseButton.tap(settingsLocator);
		return this;
	}
	
	/**
	 * Click Admin button displayed at home page
	 */
	@ActiveMethod(page = "CourtsideGameList", name = "clickAdminButton", author = "Prabhdeep", date = "8/06/2018")
	public CourtsideGameList clickAdminButton()
	{	 
		logger.debug("Clicking 'Admin' button ");
		BaseButton.tap(adminBtnLocator);
		return this;
	}
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideGameList", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideGameList synchronizeWait(By by, int visibleTimeOut, int invisibleTimeOut) {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeWait(by, visibleTimeOut, invisibleTimeOut);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideGameList", name = "synchronizeLongLoadingPage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideGameList synchronizeLongLoadingPage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeLongLoadingSportsTG();
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideGameList", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideGameList synchronizePage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.implicitlyWait(15);
        return this;
    }
	
}
