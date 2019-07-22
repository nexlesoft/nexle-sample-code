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

public class TC048_ActionLog_ReassignFoul extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC048_ActionLog_reassignFoul() throws Exception {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3270";
		
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
				.synchronizeLongLoadingPage()
		/**Tap the first player of team in the left side**/
				.tappingFirstPlayerOfLeftTeam()
				.synchronizePage()
		/**Verify text displayed in notification bar**/
				.verifyTextNotificationBarClickAnyPlayer()
		/**Click Foul button**/
				.clickTechnicalFoulButton()
				.synchronizeLongLoadingPage()
		/**Verify foul count in Game Time screen**/
				.verifyFoulCountInLeftTeam("1")
				.synchronizePage()
				/**Click Action Log button**/
				.clickActionLogButton()
				.synchronizeLongLoadingPage();
				
		actionLog.verifyActionLogScreenDisplayed()
		         .synchronizeLongLoadingPage()
		         .clickEditIconActionLogScreen()
		         .synchronizePage()
		         .clickReAssignActionLogScreen()
		         .synchronizeLongLoadingPage();
		
		String jerseyNumber = actionLog.getCurrentJerseyNumberWhenReassign();
		String playerName = actionLog.getCurrentPlayerNameWhenReassign();
		String teamName = actionLog.getCurrentTeamNameWhenReassign();
		
		actionLog.clickLeftTeamReassignActionLogScreen()
		         .synchronizePage()
		         .clickSaveButtonActionLog()
		         .synchronizeLongLoadingPage()
		         .verifyLogStatusReassign(jerseyNumber, playerName, teamName)
		         .synchronizeLongLoadingPage()
		         .clickBackButton()
		         .synchronizeLongLoadingPage();
		
		gameTime.clickBackButton()
		        .synchronizeLongLoadingPage();
		
		//login.logout();
		
	}
}
