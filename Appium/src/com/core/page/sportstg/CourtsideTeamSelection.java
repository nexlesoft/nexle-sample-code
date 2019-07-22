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

public class CourtsideTeamSelection extends Page {
	
	private static CourtsideTeamSelection instance;
	public static CourtsideTeamSelection Instance = (instance != null) ? instance : new CourtsideTeamSelection();
    
	public CourtsideTeamSelection(){}
	
	MyElement myElement = new MyElement();
    
    /** UI Mappings */
	
    By addIconLocator = myElement.getElement("addIconLocator");
    By addSecondIconLocator = myElement.getElement("addSecondIconLocator");
    By nextTeamBtnLocator = myElement.getElement("nextTeamBtnLocator");
    By finishSetupBtnLocator = myElement.getElement("finishSetupBtnLocator");
    By teamListTxtLocator = myElement.getElement("teamListTxtLocator");
    By playingInThisGameTxtLocator = myElement.getElement("playingInThisGameTxtLocator");
    By coachTxtLocator = myElement.getElement("coachTxtLocator");
    By refreshTeamListTxtLocator = myElement.getElement("refreshTeamListTxtLocator");
    By findMembersTxtLocator = myElement.getElement("findMembersTxtLocator");
    By teamColoursTxtLocator = myElement.getElement("teamColoursTxtLocator");
    By addPlayersAndCoachToTxtLocator = myElement.getElement("addPlayersAndCoachToTxtLocator");
    By backBtnLocator = myElement.getElement("backBtnLocator");
    By removeIconLocator = myElement.getElement("removeIconLocator");
    By addCoachBtnLocator = myElement.getElement("addCoachBtnLocator");
    By firstNameTxtLocator = myElement.getElement("firstNameTxtLocator");
    By lastNameTxtLocator = myElement.getElement("lastNameTxtLocator");
    By DOBTxtLocator = myElement.getElement("DOBTxtLocator");
    By searchIconLocator = myElement.getElement("searchIconLocator");
    By OKBtnLocator = myElement.getElement("OKBtnLocator");
    By coachAddedEditLocator = myElement.getElement("coachAddedEditLocator");
    By removeCoachIconLocator = myElement.getElement("removeCoachIconLocator");
    By editTeamColorLocator = myElement.getElement("editTeamColorLocator");
    By editTeamColourPopupLocator = myElement.getElement("editTeamColourPopupLocator");
    By cancelBtnLocator = myElement.getElement("cancelBtnLocator");
    By blueTeamLocator = myElement.getElement("blueTeamLocator");
    By redTeamLocator = myElement.getElement("redTeamLocator");
    By isCoachLocator = myElement.getElement("isCoachLocator");
    By searchBtnLocator = myElement.getElement("searchBtnLocator");
    By addIconLocatorMemberSearch = myElement.getElement("addIconLocatorMemberSearch");
    By resultSearchLocatorMemberSearch = myElement.getElement("resultSearchLocatorMemberSearch");
    By closeIconLocatorMemberSearch = myElement.getElement("closeIconLocatorMemberSearch");
    By refreshBtnLocator = myElement.getElement("refreshBtnLocator");
    By editJerseyNumberBtnLocator = myElement.getElement("editJerseyNumberBtnLocator");
    By jerseyNumberBtnLocator = myElement.getElement("jerseyNumberBtnLocator");
    By conflictPlayerNotificationBarLocator = myElement.getElement("conflictPlayerNotificationBarLocator");
    
    /** Page Methods */
    
	/**
	 * Add number of players to team
	 * @param numberOfPlayers
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "addPlayersToTeam", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection addPlayersToTeam(int numberOfPlayers)
	{	 
		for (int i = 0; i < numberOfPlayers; i++) {
			logger.debug("Add player to team at: " + i);
			this.synchronizePage();
			BaseButton.tap(addIconLocator);
			String jerseyNumber = Core.getElementAttribute(jerseyNumberBtnLocator, "text", 1);
			
			if(Core.getVisibilityOfElement(isCoachLocator)) {
				//this.addNewCoachButton();
				//this.synchronizeLongLoadingPage();
				if(Core.getVisibilityOfElement(conflictPlayerNotificationBarLocator)) {
					this.synchronizeLongLoadingPage();
					BaseButton.tap(editJerseyNumberBtnLocator);
					this.synchronizePage();
					Core.pressEnter(jerseyNumber);
					this.synchronizePage();
					Core.pressEnterFromKeyboard();
					this.synchronizePage();
					BaseButton.tap(removeIconLocator);
					this.synchronizePage();
					BaseButton.tap(addIconLocator);
					this.synchronizePage();
				}
				
				if(jerseyNumber.equals("")) {
					this.synchronizeLongLoadingPage();
					BaseButton.tap(editJerseyNumberBtnLocator);
					this.synchronizePage();
					Core.pressEnter(jerseyNumber+1);
					this.synchronizePage();
					Core.pressEnterFromKeyboard();
					this.synchronizePage();
				}
				
				//solve issue when there is 2 coaches in the selection list screen
				if(Core.getVisibilityOfElement(isCoachLocator)) {
					BaseButton.tap(addSecondIconLocator);
				}else {
					BaseButton.tap(addIconLocator);
				}
				this.synchronizeLongLoadingPage();
			}
			
			
			
			
			
		}
		
		return this;
	}
	
	/**
	 * Click Next Team button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickNextTeamButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickNextTeamButton()
	{	 
		logger.debug("Tagging Next Team button");
		BaseButton.tap(nextTeamBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Finish setup button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickFinishSetupButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickFinishSetupButton()
	{	 
		logger.debug("Tagging Finish Setup button");
		BaseButton.tap(finishSetupBtnLocator);
		
		return this;
	}
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideTeamSelection synchronizeWait(By by, int visibleTimeOut, int invisibleTimeOut) {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeWait(by, visibleTimeOut, invisibleTimeOut);
        return this;
    }
	
	/**
	 * Verify Team List displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyTeamListDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyTeamListDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(teamListTxtLocator);
		logger.debug("Verifying the team list displayed on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Playing in this game displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyPlayingInThisGameDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyPlayingInThisGameDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(playingInThisGameTxtLocator);
		logger.debug("Verifying the Playing in this game displayed on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Coach displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyCoachDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyCoachDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(coachTxtLocator);
		logger.debug("Verifying the Coach displayed on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Refresh Team List displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyRefreshTeamListDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyRefreshTeamListDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(refreshTeamListTxtLocator);
		logger.debug("Verifying the Refresh Team List displayed on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Find Members displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyFindMembersDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyFindMembersDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(findMembersTxtLocator);
		logger.debug("Verifying the Find Members displayed on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Team Colours displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyTeamColoursDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyTeamColoursDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(teamColoursTxtLocator);
		logger.debug("Verifying the Team Colours displayed on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Add players and coach to displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyAddPlayersAndCoachToDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyAddPlayersAndCoachToDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(addPlayersAndCoachToTxtLocator);
		logger.debug("Verifying the Add Players and coach to displayed on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Click Back button to go Game List screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickBackButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickBackButton()
	{	 
		logger.debug("Tagging Back button");
		BaseButton.tap(backBtnLocator);
		
		return this;
	}
	
	/**
	 * Remove number of players to team
	 * @param numberOfPlayers
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "removePlayersToTeam", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection removePlayersToTeam(int numberOfPlayers)
	{	 
		for (int i = 0; i < numberOfPlayers; i++) {
			logger.debug("Remove player to team at: " + i);
			BaseButton.tap(removeIconLocator);
		}
		
		return this;
	}
	
	/**
	 * Add New Player or Coach button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "addNewCoachButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection addNewCoachButton()
	{	 
		logger.debug("Click Add newcoach button");
		BaseButton.tap(addCoachBtnLocator);
		
		return this;
	}
	
	/**
	 * Enter First name field of Add New Player or Coach screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "enterFirstNameMemberSearch", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection enterFirstNameMemberSearch(String value)
	{	 
		logger.debug("Enter First name field at Member Search screen");
		BaseInput.setText(firstNameTxtLocator, value);
		
		return this;
	}
	
	/**
	 * Enter Last name field of Add New Player or Coach screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "enterLastNameMemberSearch", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection enterLastNameMemberSearch(String value)
	{	 
		logger.debug("Enter Last name field at Member Search screen");
		BaseInput.setText(lastNameTxtLocator, value);
		
		return this;
	}
	
	/**
	 * Enter DOB field of Add New Player or Coach screen
	 * @return
	 * @throws Exception 
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "enterDOBMemberSearch", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection enterDOBMemberSearch(String value) throws Exception
	{	 
		logger.debug("Enter DOB field at Member Search screen");
		
		BaseButton.tap(DOBTxtLocator);
		this.synchronizeLongLoadingPage();
		BaseButton.tap(OKBtnLocator);
		
		return this;
	}
	
	
	/**
	 * Click Search icon at Member Search screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "tapSearchIconMemberSearch", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection tapSearchIconMemberSearch()
	{	 
		logger.debug("Tapping Search icon at Member Search screen");
		BaseButton.tap(searchIconLocator);
		
		return this;
	}
	
	/**
	 * Click Add icon at Member Search screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "tapAddIconMemberSearch", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection tapAddIconMemberSearch()
	{	 
		logger.debug("Tapping add icon at Member Search screen");
		BaseButton.tap(addIconLocatorMemberSearch);
		
		return this;
	}
	
	/**
	 * Verify New coach is added to team
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyCoachAddedToTeam", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyCoachAddedToTeam(boolean isDisplayed)
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(coachAddedEditLocator);
		logger.debug("Verifying coach is added to team on team selection page");
		assertEquals(isDisplayed, actualValue);
		
		return this;
	}
	
	/**
	 * Click Remove Coach Icon Locator
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickRemoveCoachIcon", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickRemoveCoachIcon()
	{	 
		logger.debug("Click Remove Coach Icon");
		BaseButton.tap(removeCoachIconLocator);
		
		return this;
	}
	
	/**
	 * Click Edit Team Colours
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickEditTeamColours", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickEditTeamColours()
	{	 
		logger.debug("Click Edit Team Colours");
		BaseButton.tap(editTeamColorLocator);
		
		return this;
	}
	
	/**
	 * Verify Edit Team Colours displayed at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyEditTeamColoursPopupDisplayed", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyEditTeamColoursPopupDisplayed()
	{	 
		String actualValue = Core.getElementAttribute(editTeamColourPopupLocator, "text", 1);
		logger.debug("Verifying the actual Detail Page Title as '" + actualValue + "'");
		assertEquals("Edit Team Colours", actualValue);
		
		return this;
	}
	
	/**
	 * Verify Coach displayed in Team List at team selection page
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifyCoachDisplayedInTeamList", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifyCoachDisplayedInTeamList()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(isCoachLocator);
		logger.debug("Verifying the Coach displayed in Team List on team selection page");
		assertEquals(true, actualValue);
		
		return this;
	}
	/**
	 * Click Cancel button at Edit Team Colours screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickCancelBtn", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickCancelBtn()
	{	 
		logger.debug("Click Cancel button at Edit Team Colours");
		BaseButton.tap(cancelBtnLocator);
		
		return this;
	}
	
	/**
	 * Click blue team Locator
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickBlueTeamHeader", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickBlueTeamHeader()
	{	 
		logger.debug("Click Header to move Blue team");
		BaseButton.tap(blueTeamLocator);
		
		return this;
	}
	
	/**
	 * Click red team Locator
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickRedTeamHeader", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickRedTeamHeader()
	{	 
		logger.debug("Click Header to move Red team");
		BaseButton.tap(redTeamLocator);
		
		return this;
	}
	
	/**
	 * Click Search button at Team Selection screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "clickBackButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection clickSearchButton()
	{	 
		logger.debug("Tagging Search button");
		BaseButton.tap(searchBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify search result at Member Search page
	 * @param strText
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "verifySearchedResultMemberSearch", author = "Thanh Phan", date = "6/05/2018")
	public CourtsideTeamSelection verifySearchedResultMemberSearch(String strText)
	{	 
		String actualValue = Core.getElementAttribute(resultSearchLocatorMemberSearch, "text", 1);
		logger.debug("Verifying search result at Member Search page as '" + actualValue + "'");
		assertEquals(strText, actualValue);
		
		return this;
	}
	
	/**
	 * Click Close icon at Member Search screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "tapCloseIconMemberSearch", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection tapCloseIconMemberSearch()
	{	 
		logger.debug("Tagging Close Icon at member search screen");
		BaseButton.tap(closeIconLocatorMemberSearch);
		
		return this;
	}
	
	/**
	 * Click Refresh button at team selection screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "tapRefreshButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideTeamSelection tapRefreshButton()
	{	 
		logger.debug("Tagging Refresh button at team selection screen");
		BaseButton.tap(refreshBtnLocator);
		
		return this;
	}
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideTeamSelection synchronizePage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.implicitlyWait(5);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideTeamSelection", name = "synchronizeLongLoadingPage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideTeamSelection synchronizeLongLoadingPage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeLongLoadingSportsTG();
        return this;
    }
}
