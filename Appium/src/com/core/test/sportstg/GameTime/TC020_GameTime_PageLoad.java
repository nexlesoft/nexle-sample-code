package com.core.test.sportstg.GameTime;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideGameList;
import com.core.page.sportstg.CourtsideGameTime;
import com.core.page.sportstg.CourtsideLogin;
import com.core.page.sportstg.CourtsideTeamSelection;
import com.core.test.BaseTest;
import com.core.utilities.util_Calendar;
import com.core.utilities.Category.Regression;

public class TC020_GameTime_PageLoad extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC020_GameTime_pageLoad() throws Exception {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3242";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		final int playersOfTeam1 = Integer.parseInt(xmlReader.getValue("playersOfTeam1"));
		final int playersOfTeam2 = Integer.parseInt(xmlReader.getValue("playersOfTeam2"));

		CourtsideLogin login = new CourtsideLogin();
		CourtsideGameList gameList = new CourtsideGameList();
		util_Calendar calendar = new util_Calendar();
		CourtsideTeamSelection teamSelection = new CourtsideTeamSelection();
		CourtsideGameTime gameTime = new CourtsideGameTime();
		
		String day = calendar.getCurrentDate("EEEE");
		String date = calendar.getCurrentDate("d");
		String suffix = calendar.getDaySuffix(Integer.parseInt(date));
		String month = calendar.getCurrentDate("MMMM");
		String year = calendar.getCurrentDate("YYYY");
		String displayedDate = day + " " + date+suffix+" " + month+", "+year;
				
		//clear old data
				login.synchronizeLongLoadingPage()
					 .logout();
				
		/**Login to the system**/
		login.synchronizeLongLoadingPage()
		/**Enter data for Court ID, Setup ID, then press Enter to login the system**/
			 .setCourtID(courtsideID)
		     .setSetupID(setupID)
		     .pressEnterKey()
			 .synchronizeLongLoadingPage()
			 .synchronizeLongLoadingPage()
		/**Verify the title in home page**/
		     .verifyHeaderTitle(courtName)
		     .synchronizePage();
		
		/**Verify the displayed date (as today by default) on game list screen**/
		gameList.verifyDateDisplayed(displayedDate)
				.synchronizeLongLoadingPage()
		/**Go into the first game on game list screen**/
				.selectFirstGame()
				.synchronizeLongLoadingPage();
		
		/**Move players from Team list to Playing in the game for team 1**/
		teamSelection.addPlayersToTeam(playersOfTeam1)
		/**Click Next Team button**/
					 .clickNextTeamButton()
		/**Move players from Team list to Playing in the game for team 2**/
					 .addPlayersToTeam(playersOfTeam2)
		/**Click Finish Setup button**/
					 .clickFinishSetupButton()
					 .synchronizeLongLoadingPage();
		
		/**Verify UI elements displayed properly in game time screen**/
		gameTime.verifyCourtName(courtName)
				.verifyStartP1ClockDisplayed()
		        .verifyEditClockDisplayed()
		        .verifyRefereeActionsDisplayed()
		        .verifyFoulsCountLeftSideDisplayed()
		        .verifytimeoutLeftLeftSideDisplayed()
		        .verifyTimeoutLeftRightSideDisplayed()
		        .verifyFoulsCountRightSideDisplayed()
		        .verifyAddOnePointsBtnDisplayed()
		        .verifyAddTwoPointsBtnDisplayed()
		        .verifyAddThreePointsBtnDisplayed()
		        .verifyTimeoutBtnDisplayed()
		        .verifyFoulBtnDisplayed()
		        .verifyTechFoulBtnDisplayed()
		        .verifyUnspFoulBtnDisplayed()
		        .verifyDisqFoulBtnDisplayed()
		        .verifyActionLogBtnDisplayed()
		       // .synchronizeLongLoadingPage()
		        .clickBackButton()
		        .synchronizeLongLoadingPage();
		
	//	login.logout();
		
	}
}
