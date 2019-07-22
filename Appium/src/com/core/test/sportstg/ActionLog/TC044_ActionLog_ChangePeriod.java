package com.core.test.sportstg.ActionLog;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideActionLog;
import com.core.page.sportstg.CourtsideGameList;
import com.core.page.sportstg.CourtsideGameTime;
import com.core.page.sportstg.CourtsideLogin;
import com.core.page.sportstg.CourtsideTeamSelection;
import com.core.test.BaseTest;
import com.core.utilities.util_Calendar;
import com.core.utilities.Category.Regression;

public class TC044_ActionLog_ChangePeriod extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC044_ActionLog_changePeriod() throws Exception {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3266";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		final int playersOfTeam1 = Integer.parseInt(xmlReader.getValue("playersOfTeam1"));
		final int playersOfTeam2 = Integer.parseInt(xmlReader.getValue("playersOfTeam2"));
		final String point = xmlReader.getValue("point");

		CourtsideLogin login = new CourtsideLogin();
		CourtsideGameList gameList = new CourtsideGameList();
		util_Calendar calendar = new util_Calendar();
		CourtsideTeamSelection teamSelection = new CourtsideTeamSelection();
		CourtsideGameTime gameTime = new CourtsideGameTime();
		CourtsideActionLog actionLog = new CourtsideActionLog();
		
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
		
		/**Verify court name in Game Time screen**/
		gameTime.verifyCourtName(courtName)
				.synchronizePage()
				.synchronizePage()
		/**Tap the first player of team in the left side**/
				.tappingFirstPlayerOfLeftTeam()
				.synchronizePage()
		/**Verify text displayed in notification bar**/
				.verifyTextNotificationBarClickAnyPlayer()
		/**Click add points (+1, +2, +3)**/
				.clickAddPointButton(point)
				.synchronizeLongLoadingPage()
		/**Verify total score in Game Time screen**/
				.verifyTotalScoreOfLeftTeam(point)
				.synchronizePage()
		/**Click Action Log button**/
				.clickActionLogButton()
				.synchronizeLongLoadingPage();
				
		actionLog.verifyActionLogScreenDisplayed()
		         .synchronizeLongLoadingPage()
		         .clickEditIconActionLogScreen()
		         .synchronizePage()
		         .clickP2PeriodButton()
		         .synchronizePage()
		         .clickSaveButtonActionLog()
		         .synchronizePage()
		         .verifyLogStatusChangePeriod()
		         .synchronizeLongLoadingPage()
		         .clickBackButton()
		         .synchronizeLongLoadingPage();
		
		gameTime.clickBackButton()
				.synchronizeLongLoadingPage();
		         
		
		//login.logout();
		
	}
}
