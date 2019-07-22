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

public class CourtsideGameTime extends Page {
	
	private static CourtsideGameTime instance;
	public static CourtsideGameTime Instance = (instance != null) ? instance : new CourtsideGameTime();
    
	public CourtsideGameTime(){}
    
	MyElement myElement = new MyElement();
	
    /** UI Mappings */
	
    By refereeActionsBtnLocator = myElement.getElement("refereeActionsBtnLocator");
    By confirmGameBtnLocator = myElement.getElement("confirmGameBtnLocator");
    By enterUmpireCodeEditText = myElement.getElement("enterUmpireCodeEditText");
    By okBtnGameTimeLocator = myElement.getElement("okBtnGameTimeLocator");
    By backBtnlocator = myElement.getElement("backBtnlocator");
    By startP1ClockBtnLocator = myElement.getElement("startP1ClockBtnLocator");
    By editClockBtnLocator = myElement.getElement("editClockBtnLocator");
    By onePointBtnLocator = myElement.getElement("onePointBtnLocator");
    By twoPointsBtnLocator = myElement.getElement("twoPointsBtnLocator");
    By threePointsBtnLocator = myElement.getElement("threePointsBtnLocator");
    By timeoutBtnLocator = myElement.getElement("timeoutBtnLocator");
    By foulBtnLocator = myElement.getElement("foulBtnLocator");
    By techFoulBtnLocator = myElement.getElement("techFoulBtnLocator");
    By unspFoulBtnLocator = myElement.getElement("unspFoulBtnLocator");
    By disqFoulBtnLocator = myElement.getElement("disqFoulBtnLocator");
    By actionLogBtnLocator = myElement.getElement("actionLogBtnLocator");
    By foulCountBtnLeftSideLocator = myElement.getElement("foulCountBtnLeftSideLocator");
    By foulCountBtnRightSideLocator = myElement.getElement("foulCountBtnRightSideLocator");
    By timeoutLeftBtnLeftSideLocator = myElement.getElement("timeoutLeftBtnLeftSideLocator");
    By timeoutLeftBtnRightSideLocator = myElement.getElement("timeoutLeftBtnRightSideLocator");
    By firstPlayerLeftTeamLocator = myElement.getElement("firstPlayerLeftTeamLocator");
    By notificationBarMsgLocator = myElement.getElement("notificationBarMsgLocator");
    By teamLeftNameLocator = myElement.getElement("teamLeftNameLocator");
    By teamRightNameLocator = myElement.getElement("teamRightNameLocator");
    By timeoutCountLeftTeam = myElement.getElement("timeoutCountLeftTeam");
    By foulCountLeftTeam = myElement.getElement("foulCountLeftTeam");
    By technicalFoulTeamLeftTeam = myElement.getElement("technicalFoulTeamLeftTeam");
    By coachLeftNameLocator = myElement.getElement("coachLeftNameLocator");
    By technicalFoulCoachLeftTeam = myElement.getElement("technicalFoulCoachLeftTeam");
    By technicalFoulSinBinLocator = myElement.getElement("technicalFoulSinBinLocator");
    By technicalFoulPlayerLeftTeam = myElement.getElement("technicalFoulPlayerLeftTeam");
    By unsportmanlikeFoulLocator = myElement.getElement("unsportmanlikeFoulLocator");
    By disqualifiedFoulLocator = myElement.getElement("disqualifiedFoulLocator");
    By timeCountLocator = myElement.getElement("timeCountLocator");
    By setToZeroLocator = myElement.getElement("setToZeroLocator");
    By doneBtnLocator = myElement.getElement("doneBtnLocator");
    By injuryBtnLocator = myElement.getElement("injuryBtnLocator");
    By incidentBtnLocator = myElement.getElement("incidentBtnLocator");
    By forfeitBtnLocator = myElement.getElement("forfeitBtnLocator");
    By injuryHeaderLocator = myElement.getElement("injuryHeaderLocator");
    By firstPlayerInjuryReportLocator = myElement.getElement("firstPlayerInjuryReportLocator");
    By refusedTreatmentBtnLocator = myElement.getElement("refusedTreatmentBtnLocator");
    By continueBtnLocator = myElement.getElement("continueBtnLocator");
    By confirmInjuryBtnLocator = myElement.getElement("confirmInjuryBtnLocator");
    By incidentHeaderLocator = myElement.getElement("incidentHeaderLocator");
    By firstPlayerIncidentReportLocator = myElement.getElement("firstPlayerIncidentReportLocator");
    By confirmIncidentHeaderLocator = myElement.getElement("confirmIncidentHeaderLocator");
    By confirmIncidentBtnLocator = myElement.getElement("confirmIncidentBtnLocator");
    By forfeitHeaderLocator = myElement.getElement("forfeitHeaderLocator");
    By firstTeamForfeitLocator = myElement.getElement("firstTeamForfeitLocator");
    By confirmForfeitHeaderLocator = myElement.getElement("confirmForfeitHeaderLocator");
    By statusGameListLocator = myElement.getElement("statusGameListLocator");
    By editLeftTeamBtnLocator = myElement.getElement("editLeftTeamBtnLocator");
    By undoLastBtnLocator = myElement.getElement("undoLastBtnLocator");
    By redoBtnLocator = myElement.getElement("redoBtnLocator");
    By disqualifiedCoachLocator = myElement.getElement("disqualifiedCoachLocator");
    By editActionLogBtnLocator = myElement.getElement("editActionLogBtnLocator");
    By timeoutCountRightTeam = myElement.getElement("timeoutCountRightTeam");
    
    /** Page Methods */
	
	/**
	 * Click Referee Actions button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickRefereeActionsButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickRefereeActionsButton()
	{	 
		logger.debug("Tagging Referee Actions button");
		BaseButton.tap(refereeActionsBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Confirm Game button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickConfirmGameButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickConfirmGameButton()
	{	 
		logger.debug("Tagging Confirm Game button");
		BaseButton.tap(confirmGameBtnLocator);
		
		return this;
	}
	
	/**
	 * Enter Umpire Code at Confirm Game screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickConfirmGameButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime enterUmpireCodeConfirmGame()
	{	 
		logger.debug("Enter umpire code at Confirm Game screen: ");
		this.synchronizeLongLoadingPage();
		Core.pressKeyFromKeyboard(enterUmpireCodeEditText, "6");
		Core.pressKeyFromKeyboard(enterUmpireCodeEditText, "8");
		Core.pressKeyFromKeyboard(enterUmpireCodeEditText, "1");
		Core.pressKeyFromKeyboard(enterUmpireCodeEditText, "B");
		Core.pressKeyFromKeyboard(enterUmpireCodeEditText, "J");
		Core.pressKeyFromKeyboard(enterUmpireCodeEditText, "8");
		this.synchronizePage();
		Core.pressEnterKey();
		
		return this;
	}
	
	/**
	 * Click OK button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickOKButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickOKButton()
	{	 
		logger.debug("Tagging OK button");
		BaseButton.tap(okBtnGameTimeLocator);
		
		return this;
	}
	
	/**
	 * Click Back button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickBackButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickBackButton()
	{	 
		logger.debug("Tagging Back button");
		BaseButton.tap(backBtnlocator);
		
		return this;
	}
	
	/**
	 * Verify Court Name on Game Time page
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyCourtName", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyCourtName(String strTitle)
	{	 
		By headerLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView");
		String actualValue = Core.getElementAttribute(headerLocator, "text", 1);
		logger.debug("Verifying the actual Court Name in Game Time page as '" + actualValue + "'");
		strTitle = strTitle.substring(strTitle.length()-8, strTitle.length()-1);
		assertEquals(strTitle, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Start P1 Clock displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyStartP1ClockDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyStartP1ClockDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(startP1ClockBtnLocator);
		logger.debug("Verifying the Start P1 Clock displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Edit Clock displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyEditClockDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyEditClockDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(editClockBtnLocator);
		logger.debug("Verifying the Edit Clock displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Referee Actions displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyRefereeActionsDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyRefereeActionsDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(refereeActionsBtnLocator);
		logger.debug("Verifying the Referee Actions displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify +1 button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyAddOnePointsBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyAddOnePointsBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(onePointBtnLocator);
		logger.debug("Verifying the Add +1 button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify +2 button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyAddTwoPointsBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyAddTwoPointsBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(twoPointsBtnLocator);
		logger.debug("Verifying the Add +2 button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify +2 button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyAddThreePointsBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyAddThreePointsBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(threePointsBtnLocator);
		logger.debug("Verifying the Add +3 button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Timeout button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTimeoutBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyTimeoutBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(timeoutBtnLocator);
		logger.debug("Verifying the Timeout button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Foul button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyFoulBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyFoulBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(foulBtnLocator);
		logger.debug("Verifying the Foul button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Tech. Foul button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTechFoulBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyTechFoulBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(techFoulBtnLocator);
		logger.debug("Verifying the Tech Foul button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Unsp. Foul button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyUnspFoulBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyUnspFoulBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(unspFoulBtnLocator);
		logger.debug("Verifying the Unsp Foul button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Disq. Foul button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyDisqFoulBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyDisqFoulBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(disqFoulBtnLocator);
		logger.debug("Verifying the Disq Foul button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Ation Log button displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyActionLogBtnDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyActionLogBtnDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(actionLogBtnLocator);
		logger.debug("Verifying the Action Log button displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Fouls Count Left side displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyFoulsCountLeftSideDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyFoulsCountLeftSideDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(foulCountBtnLeftSideLocator);
		logger.debug("Verifying the Fouls Count Left side displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Fouls Count Right side displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyFoulsCountRightSideDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyFoulsCountRightSideDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(foulCountBtnRightSideLocator);
		logger.debug("Verifying the Fouls Count Right side displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Timeouts Left Count Left side displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTimeoutLeftLeftSideDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifytimeoutLeftLeftSideDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(timeoutLeftBtnLeftSideLocator);
		logger.debug("Verifying the Timeout Left Left side displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Timeout Left Right side displayed at Game Time page
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTimeoutLeftRightSideDisplayed", author = "Thanh Phan", date = "6/18/2018")
	public CourtsideGameTime verifyTimeoutLeftRightSideDisplayed()
	{	 
		Boolean actualValue = Core.getVisibilityOfElement(timeoutLeftBtnRightSideLocator);
		logger.debug("Verifying the Timeout Left Right side displayed on Game Time page");
		assertEquals(true, actualValue);
		
		return this;
	}
	
	/**
	 * Click +1 point button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickAddPointButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickAddPointButton(String point)
	{	 
		logger.debug("Click +"+point+" point button");
		if(point.equals("1")) {
			BaseButton.tap(onePointBtnLocator);
		}else if(point.equals("2")) {
			BaseButton.tap(twoPointsBtnLocator);
		}else {
			BaseButton.tap(threePointsBtnLocator);
		}

		return this;
	}
	
	/**
	 * Verify Total Score of left side team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTotalScoreOfLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTotalScoreOfLeftTeam(String strValue)
	{	 
		By itemLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[1]");
		String actualValue = Core.getElementAttribute(itemLocator, "text", 1);
		logger.debug("Verifying the actual Total Score of left side team as '" + actualValue + "'");
		if(strValue.equals("1")||strValue.equals("2")||strValue.equals("3")) {
			strValue = "0"+strValue;
		}
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Notification bar text when click add one point team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTextNotificationBarAddOnePoint", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTextNotificationBarAddOnePoint()
	{	 
		String actualValue = Core.getElementAttribute(notificationBarMsgLocator, "text", 1);
		logger.debug("Verifying the actual text of Notification bar when click add one point as '" + actualValue + "'");
		assertEquals("Select player or team to attribute +1 points to", actualValue);
		
		return this;
	}
	
	/**
	 * Verify Notification bar text when click any player in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTextNotificationBarClickAnyPlayer", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTextNotificationBarClickAnyPlayer()
	{	 
		String actualValue = Core.getElementAttribute(notificationBarMsgLocator, "text", 1);
		logger.debug("Verifying the actual text of Notification bar when click any player as '" + actualValue + "'");
		assertEquals("Select points or foul to add to player", actualValue);
		
		return this;
	}
	
	/**
	 * Tapping team name of left side team
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "tappingTeamNameOfLeftSide", author = "Thanh Phan", date = "6/19/2018")
	public CourtsideGameTime tappingTeamNameOfLeftSide()
	{	 
		logger.debug("Tagging team name of left side");
		BaseButton.tap(teamLeftNameLocator);
		
		return this;
	}
	
	/**
	 * Tapping team name of right side team
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "tappingTeamNameOfRightSide", author = "Thanh Phan", date = "6/19/2018")
	public CourtsideGameTime tappingTeamNameOfRightSide()
	{	 
		logger.debug("Tagging team name of right side");
		BaseButton.tap(teamRightNameLocator);
		
		return this;
	}
	
	/**
	 * Verify Notification bar text when click team name in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTextNotificationBarClickAnyTeamName", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTextNotificationBarClickAnyTeamName()
	{	 
		String actualValue = Core.getElementAttribute(notificationBarMsgLocator, "text", 1);
		logger.debug("Verifying the actual text of Notification bar when click any team as '" + actualValue + "'");
		assertEquals("Select points or foul or timeout to add to team", actualValue);
		
		return this;
	}
	
	/**
	 * Tapping first player of left side team
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "tappingFirstPlayerOfLeftTeam", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime tappingFirstPlayerOfLeftTeam()
	{	 
		logger.debug("Tapping first player of left team");
		BaseButton.tap(firstPlayerLeftTeamLocator);
		
		return this;
	}
	
	/**
	 * Tapping timeout button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "tappingTimeoutBtn", author = "Thanh Phan", date = "6/19/2018")
	public CourtsideGameTime tappingTimeoutBtn()
	{	 
		logger.debug("Tapping timeout button");
		BaseButton.tap(timeoutBtnLocator);
		
		return this;
	}
	
	/**
	 * Get timeout in left team
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "getTimeoutCountOfLeftTeam", author = "Thanh Phan", date = "6/19/2018")
	public String getTimeoutCountOfLeftTeam()
	{	 
		String timeout;
		
		logger.debug("Getting timeout count of left team");
		timeout = Core.getElementAttribute(timeoutCountLeftTeam, "text", 10);
		
		return timeout;
	}
	
	/**
	 * Verify timeout Count of left team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTimeoutCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTimeoutCountInLeftTeam(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(timeoutCountLeftTeam, "text", 1);
		logger.debug("Verifying the actual text of Timeout count of left team as '" + actualValue + "'");
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Get timeout in right team
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "getTimeoutCountOfRightTeam", author = "Thanh Phan", date = "6/19/2018")
	public String getTimeoutCountOfRightTeam()
	{	 
		String timeout;
		
		logger.debug("Getting timeout count of right team");
		timeout = Core.getElementAttribute(timeoutCountRightTeam, "text", 10);
		
		return timeout;
	}
	
	/**
	 * Verify timeout Count of right team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTimeoutCountInRightTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTimeoutCountInRightTeam(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(timeoutCountRightTeam, "text", 1);
		logger.debug("Verifying the actual text of Timeout count of right team as '" + actualValue + "'");
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Click Foul button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickFoulButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickFoulButton()
	{	 
		logger.debug("Tagging Foul button");
		BaseButton.tap(foulBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Technical Foul button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickTechnicalFoulButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickTechnicalFoulButton()
	{	 
		logger.debug("Tagging Technical Foul button");
		BaseButton.tap(techFoulBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Unsportmanlike Foul button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickUnsportmanlikeFoulButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickUnsportmanlikeFoulButton()
	{	 
		logger.debug("Tagging Unsportmanlike Foul button");
		BaseButton.tap(unspFoulBtnLocator);
		
		return this;
	}
	/**
	 * Verify Foul Count of left team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyFoulCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyFoulCountInLeftTeam(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(foulCountLeftTeam, "text", 1);
		logger.debug("Verifying the actual text of foul count of left team as '" + actualValue + "'");
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Technical Foul Count of left team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTechnicalFoulCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTechnicalFoulCountInLeftTeamForTeam(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(technicalFoulTeamLeftTeam, "text", 1);
		logger.debug("Verifying the actual text of technical foul count of left team as '" + actualValue + "'");
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Tap coach of left team
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "tapCoachLeftTeam", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime tapCoachLeftTeam()
	{	 
		logger.debug("Tagging Coach of left team");
		BaseButton.tap(coachLeftNameLocator);
		
		return this;
	}
	
	/**
	 * Verify Notification bar text when click coach of left team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTextNotificationBarClickCoachOfLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTextNotificationBarClickCoachOfLeftTeam()
	{	 
		String actualValue = Core.getElementAttribute(notificationBarMsgLocator, "text", 1);
		logger.debug("Verifying the actual text of Notification bar when click coach as '" + actualValue + "'");
		assertEquals("Select foul to add to coach", actualValue);
		
		return this;
	}
	
	/**
	 * Verify Technical Foul Count of coach of left team in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTechnicalFoulCountOfCoachInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTechnicalFoulCountOfCoachInLeftTeam(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(technicalFoulCoachLeftTeam, "text", 1);
		logger.debug("Verifying the actual text of technical foul count of coach of left team as '" + actualValue + "'");
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Technical Foul Count of left team for player in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyTechnicalFoulCountInLeftTeamForPlayer", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTechnicalFoulCountInLeftTeamForPlayer(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(technicalFoulPlayerLeftTeam, "text", 1);
		logger.debug("Verifying the actual text of technical foul count of left team for player as '" + actualValue + "'");
		assertEquals("T"+strValue, actualValue);
		
		String sinBinActualValue = Core.getElementAttribute(technicalFoulSinBinLocator, "text", 1);
		logger.debug("Verifying the actual text of technical foul for sinbin as Sin Bin time remaining 05:00");
		//assertEquals("Sin Bin time remaining 05:00", sinBinActualValue);
		return this;
	}
	
	/**
	 * Verify Unsportmanlike Foul Count of left team for player in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyUnsportmanlikeFoulCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyUnsportmanlikeFoulCountInLeftTeam(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(unsportmanlikeFoulLocator, "text", 1);
		logger.debug("Verifying the actual text of unsportmanlike foul count of left team for player as '" + actualValue + "'");
		assertEquals("U"+strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Click Disqualified Foul button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickDisqualifiedFoulButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickDisqualifiedFoulButton()
	{	 
		logger.debug("Tagging Disqualified Foul button");
		BaseButton.tap(disqFoulBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify Disqualified Foul Count of left team for player in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyUnsportmanlikeFoulCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyDisqualifiedFoulCountInLeftTeam()
	{	 
		String actualValue = Core.getElementAttribute(disqualifiedFoulLocator, "text", 1);
		logger.debug("Verifying the actual text of Disqualified foul count of left team for player as Disqualified");
		assertEquals("Disqualified", actualValue);
		
		return this;
	}
	
	/**
	 * Click Start P1 Clock button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickStartP1ClockButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickStartP1ClockButton()
	{	 
		logger.debug("Tagging Start P1 Clock button");
		BaseButton.tap(startP1ClockBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify Time count decrease when click Start P1 Clock button in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyFoulCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTimeCountWhenClickStartP1Clock(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(timeCountLocator, "text", 1);
		logger.debug("Verifying Time count decrease when click Start P1 Clock button as '" + actualValue + "'");
		assertNotEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Verify Time count when click Edit Clock button in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyFoulCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyTimeCountWhenClickEditClock(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(timeCountLocator, "text", 1);
		logger.debug("Verifying Time count decrease when click Edit Clock button as '" + actualValue + "'");
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Get time count in Game Time screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "getTimeCount", author = "Thanh Phan", date = "7/19/2018")
	public String getTimeCount()
	{	 
		String timeCount;
		
		logger.debug("Getting time count in Game Time screen");
		timeCount = Core.getElementAttribute(timeCountLocator, "text", 10);
		
		return timeCount;
	}
	
	/**
	 * Click Edit Clock button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickEditClockButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickEditClockButton()
	{	 
		logger.debug("Tagging Edit Clock button");
		BaseButton.tap(editClockBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Set to 0 button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickSetToZeroButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickSetToZeroButton()
	{	 
		logger.debug("Tagging Set To 0 button");
		BaseButton.tap(setToZeroLocator);
		
		return this;
	}
	
	/**
	 * Click Done button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickDoneButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickDoneButton()
	{	 
		logger.debug("Tagging Done button");
		BaseButton.tap(doneBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Injury button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickInjuryButton", author = "Thanh Phan", date = "7/26/2018")
	public CourtsideGameTime clickInjuryButton()
	{	 
		logger.debug("Tagging Injury button");
		BaseButton.tap(injuryBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Incident button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickIncidentButton", author = "Thanh Phan", date = "7/26/2018")
	public CourtsideGameTime clickIncidentButton()
	{	 
		logger.debug("Tagging Incident button");
		BaseButton.tap(incidentBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Forfeit button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickForfeitButton", author = "Thanh Phan", date = "7/26/2018")
	public CourtsideGameTime clickForfeitButton()
	{	 
		logger.debug("Tagging Forfeit button");
		BaseButton.tap(forfeitBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify Injury Report screen displayed
	 * @param 
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyInjuryReportScreenDisplayed", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyInjuryReportScreenDisplayed()
	{	 
		String actualValue = Core.getElementAttribute(injuryHeaderLocator, "text", 1);
		logger.debug("Verifying the actual text of Injury Report screen as '" + actualValue + "'");
		assertEquals("Select player & injury report", actualValue);
		
		return this;
	}
	
	/**
	 * Click first player at Injury Report screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickFirstPlayerInjuryReport", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickFirstPlayerInjuryReport()
	{	 
		logger.debug("Tagging first player at injury report screen");
		BaseButton.tap(firstPlayerInjuryReportLocator);
		
		return this;
	}
	
	/**
	 * Click Injury Type button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickRefusedTreatmentButton", author = "Thanh Phan", date = "7/26/2018")
	public CourtsideGameTime clickInjuryType(String injuryType)
	{	 
		By injuryTypeLocator = By.xpath("//android.widget.TextView[contains(@text,'"+injuryType+"')]");
		logger.debug("Tagging "+injuryTypeLocator+" button");
		BaseButton.tap(injuryTypeLocator);
		
		return this;
	}
	
	/**
	 * Click Continue button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickContinueButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickContinueButton()
	{	 
		logger.debug("Tagging Continue button");
		BaseButton.tap(continueBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Confirm Injury button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickConfirmInjuryButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickConfirmInjuryButton()
	{	 
		logger.debug("Tagging Confirm Injury button");
		BaseButton.tap(confirmInjuryBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify Incident report screen displayed
	 * @param 
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyIncidentReportScreenDisplayed", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyIncidentReportScreenDisplayed()
	{	 
		String actualValue = Core.getElementAttribute(incidentHeaderLocator, "text", 1);
		logger.debug("Verifying the actual text of Incident Report screen as '" + actualValue + "'");
		assertEquals("Select player to report incident", actualValue);
		
		return this;
	}
	
	/**
	 * Click first player at Incident Report screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickFirstPlayerIncidentReport", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickFirstPlayerIncidentReport()
	{	 
		logger.debug("Tagging first player at incident report screen");
		BaseButton.tap(firstPlayerIncidentReportLocator);
		
		return this;
	}
	
	/**
	 * Verify Confirm of Incident report screen displayed
	 * @param 
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyConfirmIncidentReportScreenDisplayed", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyConfirmIncidentReportScreenDisplayed()
	{	 
		String actualValue = Core.getElementAttribute(confirmIncidentHeaderLocator, "text", 1);
		logger.debug("Verifying the actual text of Incident Report Confirm screen as '" + actualValue + "'");
		assertEquals("Enter your umpire code to confirm incident", actualValue);
		
		return this;
	}
	
	/**
	 * Click Confirm Incident button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickConfirmIncidentButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickConfirmIncidentButton()
	{	 
		logger.debug("Tagging Confirm Incident button");
		BaseButton.tap(confirmIncidentBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify Forfeit screen displayed
	 * @param 
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyForfeitScreenDisplayed", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyForfeitScreenDisplayed()
	{	 
		String actualValue = Core.getElementAttribute(forfeitHeaderLocator, "text", 1);
		logger.debug("Verifying the actual text of Forfeit screen as '" + actualValue + "'");
		assertEquals("Select winning team", actualValue);
		
		return this;
	}
	
	/**
	 * Click first team at Forfeit screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickFirstTeamOfForfeit", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickFirstTeamOfForfeit()
	{	 
		logger.debug("Tagging first team at forfeit screen");
		BaseButton.tap(firstTeamForfeitLocator);
		
		return this;
	}
	
	/**
	 * Verify Confirm of Forfeit screen displayed
	 * @param 
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyConfirmForfeitScreenDisplayed", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyConfirmForfeitScreenDisplayed()
	{	 
		String actualValue = Core.getElementAttribute(confirmForfeitHeaderLocator, "text", 1);
		logger.debug("Verifying the actual text of Forfeit Confirm screen as '" + actualValue + "'");
		assertEquals("Enter your Umpire code to confirm the Score and the Game", actualValue);
		
		return this;
	}
	
	/**
	 * Verify Status in Game List screen after set forfeit
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyUnsportmanlikeFoulCountInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyStatusGameListScreen(String strValue)
	{	 
		String actualValue = Core.getElementAttribute(statusGameListLocator, "text", 1);
		logger.debug("Verifying the actual text of Status in Game List screen: "+ strValue);
		assertEquals(strValue, actualValue);
		
		return this;
	}
	
	/**
	 * Click edit button of left team
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickRefereeActionsButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickEditIconOfLeftTeam()
	{	 
		logger.debug("Tagging Edit button of left team");
		BaseButton.tap(editLeftTeamBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Undo Last button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickUndoLastButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickUndoLastButton()
	{	 
		logger.debug("Tagging Undo Last button");
		BaseButton.tap(undoLastBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Redo button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickRedoButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickRedoButton()
	{	 
		logger.debug("Tagging Redo button");
		BaseButton.tap(redoBtnLocator);
		
		return this;
	}
	
	/**
	 * Verify Coach is disqualified in Game Time screen
	 * @param strTitle
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "verifyCoachIsDisqualifiedInLeftTeam", author = "Thanh Phan", date = "5/18/2018")
	public CourtsideGameTime verifyCoachIsDisqualifiedInLeftTeam()
	{	 
		String actualValue = Core.getElementAttribute(disqualifiedCoachLocator, "text", 1);
		logger.debug("Verifying the actual text of Disqualified coach of left team for player as Disqualified");
		assertEquals("Disqualified", actualValue);
		
		return this;
	}
	
	/**
	 * Click Action Log button
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickActionLogButton", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickActionLogButton()
	{	 
		logger.debug("Tagging Action Log button");
		BaseButton.tap(actionLogBtnLocator);
		
		return this;
	}
	
	/**
	 * Click Edit icon in Action Log screen
	 * @return
	 */
	@ActiveMethod(page = "CourtsideGameTime", name = "clickEditIconActionLogScreen", author = "Thanh Phan", date = "6/08/2018")
	public CourtsideGameTime clickEditIconActionLogScreen()
	{	 
		logger.debug("Tagging Edit icon Action Log screen");
		BaseButton.tap(editActionLogBtnLocator);
		
		return this;
	}
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideGameTime", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideGameTime synchronizeWait(By by, int visibleTimeOut, int invisibleTimeOut) {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeWait(by, visibleTimeOut, invisibleTimeOut);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideGameTime", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideGameTime synchronizePage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.implicitlyWait(5);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideGameTime", name = "synchronizeLongLoadingPage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideGameTime synchronizeLongLoadingPage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeLongLoadingSportsTG(10,360);
        return this;
    }
}
