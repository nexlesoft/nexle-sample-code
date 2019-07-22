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
import static org.junit.Assert.assertNotEquals;

public class CourtsideActionLog extends Page {
	
	private static CourtsideActionLog instance;
	public static CourtsideActionLog Instance = (instance != null) ? instance : new CourtsideActionLog();
    
	public CourtsideActionLog(){}
    
	MyElement myElement = new MyElement();
	
    /** UI Mappings */
	
    By actionLogHeaderLocator = myElement.getElement("actionLogHeaderLocator");
    By backActionLogBtnlocator = myElement.getElement("backActionLogBtnlocator");
    By editActionLogBtnLocator = myElement.getElement("editActionLogBtnLocator");
    By p2ActionLogBtnLocator = myElement.getElement("p2ActionLogBtnLocator");
    By saveActionLogBtnLocator = myElement.getElement("saveActionLogBtnLocator");
    By logStatusChangePeriodLocator = myElement.getElement("logStatusChangePeriodLocator");
    By twoPointsBtnActionLogLocator = myElement.getElement("twoPointsBtnActionLogLocator");
    By logStatusChangeScoreLocator = myElement.getElement("logStatusChangeScoreLocator");
    By diqualifyingFoulActionLogCheckboxLocator = myElement.getElement("diqualifyingFoulActionLogCheckboxLocator");
    By technicalFoulActionLogCheckboxLocator = myElement.getElement("technicalFoulActionLogCheckboxLocator");
    By unsportsFoulActionLogCheckboxLocator = myElement.getElement("unsportsFoulActionLogCheckboxLocator");
    By logStatusChangeToTechnicalLocator = myElement.getElement("logStatusChangeToTechnicalLocator");
    By reAssignActionLogBtnLocator = myElement.getElement("reAssignActionLogBtnLocator");
    By teamActionLogBtnLocator = myElement.getElement("teamActionLogBtnLocator");
    By firstPlayerNameActionLogLocator = myElement.getElement("firstPlayerNameActionLogLocator");
    By jerseyNumberFirstPlayerActionLogLocator = myElement.getElement("jerseyNumberFirstPlayerActionLogLocator");
    By teamNameLeftActionLogLocator = myElement.getElement("teamNameLeftActionLogLocator");
    By logStatusReassignLocator = myElement.getElement("logStatusReassignLocator");
    By anotherTeamTimeoutActionLogCheckboxLocator = myElement.getElement("anotherTeamTimeoutActionLogCheckboxLocator");
    By teamNameAnotherTimeoutActionLogLocator = myElement.getElement("teamNameAnotherTimeoutActionLogLocator");
    By pointsActionLogLocator = myElement.getElement("pointsActionLogLocator");
    
    /** Page Methods */
	
    /**
	 * Verify Action Log screen displayed
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "verifyActionLogScreenDisplayed", author = "Thanh Phan", date = "8/06/2018")
	public CourtsideActionLog verifyActionLogScreenDisplayed()
	{	 
		String actualValue = Core.getElementAttribute(actionLogHeaderLocator, "text", 1);
		logger.debug("Verifying Action Log screen displayed");
		assertEquals("Action Log", actualValue);
		
		return this;
	}
	
	/**
	 * Click Back button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickBackButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickBackButton()
	{	 
		logger.debug("Tapping Back button");
		BaseButton.tap(backActionLogBtnlocator);
		
		return this;
	}
	
	/**
	 * Click Edit icon in Action Log screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickEditIconActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickEditIconActionLogScreen()
	{	 
		logger.debug("Tapping Edit icon Action Log screen");
		BaseButton.tap(editActionLogBtnLocator);
		
		return this;
	}
	
	/**
	 * Click P2 period at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickP2PeriodButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickP2PeriodButton()
	{	 
		logger.debug("Tapping P2 period button");
		BaseButton.tap(p2ActionLogBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Save button at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickSaveButtonActionLog", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickSaveButtonActionLog()
	{	 
		logger.debug("Tapping Save button at Edit Time & Action popup");
		BaseButton.tap(saveActionLogBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify log status when change period to P2
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "verifyLogStatusChangePeriod", author = "Thanh Phan", date = "8/06/2018")
	public CourtsideActionLog verifyLogStatusChangePeriod()
	{	 
		String expectedValue = "\nChanged Time: from \'(P1 - 20:00\') to \'(P2 - 20:00\')";
		String actualValue = Core.getElementAttribute(logStatusChangePeriodLocator, "text", 1);
		logger.debug("Verifying log status when change period to P2");

		assertEquals(expectedValue.replace("'", ""), actualValue);
		
		return this;
	}
	
	/**
	 * Click +2 point at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickTwoPointActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickTwoPointActionLogScreen()
	{	 
		logger.debug("Tapping +2 point at Edit Time & Action popup");
		BaseButton.tap(twoPointsBtnActionLogLocator);
		
		return this;
	}
	
	/**
	 * Verify log status when change score
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "verifyLogStatusChangeScore", author = "Thanh Phan", date = "8/06/2018")
	public CourtsideActionLog verifyLogStatusChangeScore()
	{	 
		String expectedValue = "Changed Action: from +1 Point to +2 Points at \'(P1 - 20:00\')";
		String actualValue = Core.getElementAttribute(logStatusChangeScoreLocator, "text", 1);
		logger.debug("Verifying log status when change score");

		assertEquals(expectedValue.replace("'", ""), actualValue);
		
		return this;
	}
	
	/**
	 * Click Disqualifying Foul at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickDisqualifyingFoulActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickDisqualifyingFoulActionLogScreen()
	{	 
		logger.debug("Tapping Disqualifying Foul at Edit Time & Action popup");
		BaseButton.tap(diqualifyingFoulActionLogCheckboxLocator);
		
		return this;
	}
	
	/**
	 * Click Technical Foul at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickTechnicalFoulActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickTechnicalFoulActionLogScreen()
	{	 
		logger.debug("Tapping Technical Foul at Edit Time & Action popup");
		BaseButton.tap(technicalFoulActionLogCheckboxLocator);
		
		return this;
	}
	
	/**
	 * Click Unsportmanlike Foul at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickUnsportFoulActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickUnsportFoulActionLogScreen()
	{	 
		logger.debug("Tapping Unsportsmanlike Foul at Edit Time & Action popup");
		BaseButton.tap(unsportsFoulActionLogCheckboxLocator);
		
		return this;
	}
	
	/**
	 * Verify log status when change foul to technical foul
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "verifyLogStatusChangeScore", author = "Thanh Phan", date = "8/06/2018")
	public CourtsideActionLog verifyLogStatusChangeToTechnicalFoul()
	{	 
		String expectedValue = "Changed Action: from +1 Foul to  +1 Technical Foul at \'(P1 - 20:00\')";
		String actualValue = Core.getElementAttribute(logStatusChangeToTechnicalLocator, "text", 1);
		
		logger.debug("Verifying log status when change to Technical foul");

		assertEquals(expectedValue.replace("'", ""), actualValue);
		
		return this;
	}
	
	/**
	 * Click Re-assign at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickReAssignActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickReAssignActionLogScreen()
	{	 
		logger.debug("Tapping Re-assing at Edit Time & Action popup");
		BaseButton.tap(reAssignActionLogBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Left team when clicking Re-assign at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickLeftTeamReassignActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickLeftTeamReassignActionLogScreen()
	{	 
		logger.debug("Tapping Left team when clicking Re-assign at Edit Time & Action popup");
		BaseButton.tap(teamActionLogBtnLocator);
		
		return this;
	}
	
	
	/**
	 * Get current player name  at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "getCurrentPlayerNameWhenReassign", author = "Thanh Phan", date = "6/08/2018")
	public String getCurrentPlayerNameWhenReassign()
	{	 
		logger.debug("Get current player name at Edit Time & Action popup");
		String playerName = Core.getElementAttribute(firstPlayerNameActionLogLocator, "text", 1);
		
		return playerName;
	}
	
	/**
	 * Get current jersey number  at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "getCurrentPlayerNameWhenReassign", author = "Thanh Phan", date = "6/08/2018")
	public String getCurrentJerseyNumberWhenReassign()
	{	 
		logger.debug("Get current jersey number at Edit Time & Action popup");
		String jerseyNumber = Core.getElementAttribute(jerseyNumberFirstPlayerActionLogLocator, "text", 1);
		
		return jerseyNumber;
	}
	
	/**
	 * Get current team name  at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "getCurrentPlayerNameWhenReassign", author = "Thanh Phan", date = "6/08/2018")
	public String getCurrentTeamNameWhenReassign()
	{	 
		logger.debug("Get current team name at Edit Time & Action popup");
		String teamName = Core.getElementAttribute(teamNameLeftActionLogLocator, "text", 1);
		
		return teamName;
	}
	
	/**
	 * Verify log status when Re-assign
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "verifyLogStatusReassign", author = "Thanh Phan", date = "8/06/2018")
	public CourtsideActionLog verifyLogStatusReassign(String jerseyNumber, String playerName, String teamName)
	{	 
		String expectedValue = "Re-assigned Action: from ["+jerseyNumber+"] "+playerName+" to [Team] "+teamName+" at \\(P1 - 20:00\\)";
		String actualValue = Core.getElementAttribute(logStatusReassignLocator, "text", 1);
		
		logger.debug("Verifying log status when Re-assign");

		assertEquals(expectedValue.replace("\\", ""), actualValue);
		
		return this;
	}
	
	/**
	 * Click another team when choosing timeout at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "clickAnotherTeamTimeoutActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideActionLog clickAnotherTeamTimeoutActionLogScreen()
	{	 
		logger.debug("Tapping another team when choosing timeout at Edit Time & Action popup");
		BaseButton.tap(anotherTeamTimeoutActionLogCheckboxLocator);
		
		return this;
	}
	
	/**
	 * Get current team name of timeout  at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "getTeamNameOfCurrentTeamTimeout", author = "Thanh Phan", date = "6/08/2018")
	public String getTeamNameOfCurrentTeamTimeout()
	{	 
		logger.debug("Get current team name at Edit Time & Action popup");
		String teamName = Core.getElementAttribute(teamNameLeftActionLogLocator, "text", 1);
		
		return teamName;
	}
	
	/**
	 * Get current team name of another team when clicking timeout at Edit Time & Action popup
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "getTeamNameOfAnotherTeamTimeout", author = "Thanh Phan", date = "6/08/2018")
	public String getTeamNameOfAnotherTeamTimeout()
	{	 
		logger.debug("Get team name of another team when clicking timeout at Edit Time & Action popup");
		String teamName = Core.getElementAttribute(teamNameAnotherTimeoutActionLogLocator, "text", 1);
		
		return teamName;
	}
	
	/**
	 * Verify log status when Re-assign timeout
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "verifyLogStatusReassign", author = "Thanh Phan", date = "8/06/2018")
	public CourtsideActionLog verifyLogStatusReassignTimeout(String currentTeamName, String anotherTeamName)
	{	 
		String expectedValue = "Re-assigned Action Time Out : from [Team] "+currentTeamName+" to [Team] "+anotherTeamName+" at \\(P1 - 20:00\\)";
		String actualValue = Core.getElementAttribute(logStatusReassignLocator, "text", 1);
		
		logger.debug("Verifying log status when Re-assign timeout from "+ currentTeamName +" to  "+anotherTeamName +"");

		assertEquals(expectedValue.replace("\\", ""), actualValue);
		
		return this;
	}
	
	/**
	 * Verify points in Action Log
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideActionLog", name = "verifyPointsActionLog", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideActionLog verifyPointsActionLog(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(pointsActionLogLocator, "text", 1);
		logger.debug("Verifying the actual points in Action Log as '" + actualValue + "'");
		
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideActionLog", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideActionLog synchronizeWait(By by, int visibleTimeOut, int invisibleTimeOut) {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeWait(by, visibleTimeOut, invisibleTimeOut);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideActionLog", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideActionLog synchronizePage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.implicitlyWait(5);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideActionLog", name = "synchronizeLongLoadingPage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideActionLog synchronizeLongLoadingPage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeLongLoadingSportsTG(10,360);
        return this;
    }
}
