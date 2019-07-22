package com.core.test.sportstg.GameList;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideGameList;
import com.core.page.sportstg.CourtsideGameTime;
import com.core.page.sportstg.CourtsideLogin;
import com.core.page.sportstg.CourtsideTeamSelection;
import com.core.test.BaseTest;
import com.core.utilities.util_Calendar;
import com.core.utilities.Category.Regression;

public class TC007_GameList_ManualSyncOfAdmin extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC007_GameList_manualSyncOfAdmin() throws Exception {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3230";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		final int playersOfTeam1 = Integer.parseInt(xmlReader.getValue("playersOfTeam1"));
		final int playersOfTeam2 = Integer.parseInt(xmlReader.getValue("playersOfTeam1"));
		
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
				.synchronizePage()
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
		
		/**Click Referee Action button**/
		gameTime.clickRefereeActionsButton()
		        .synchronizePage()
		/**Click Confirm Game button**/
		        .clickConfirmGameButton()
		        .synchronizePage()
		/**Input data for Umpire Code Confirm Game field**/
		        .enterUmpireCodeConfirmGame()
		        .synchronizeLongLoadingPage()
		/**Click OK button**/
		        .clickOKButton()
		        .synchronizeLongLoadingPage()
		        .clickBackButton()
		        .synchronizeLongLoadingPage();
		
		gameList.synchronizeLongLoadingPage()
		/**Click Manual Sync button from Admin**/
				.clickManualSync()
		        .synchronizeLongLoadingPage()
		/**Check Select All  to select all available checkbox**/
		        .tagSelectAll()
		        .synchronizeLongLoadingPage()
		/**Click Sync button from notification bar**/
		        .tagSync()
		        .synchronizeLongLoadingPage();
		     
		/**Clear the data to logout the system**/
		//login.logout();
		
	}
}
