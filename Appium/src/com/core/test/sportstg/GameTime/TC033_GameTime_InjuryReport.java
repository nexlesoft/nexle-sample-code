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

public class TC033_GameTime_InjuryReport extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC033_GameTime_injuryReport() throws Exception {
		
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3255";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		final String injuryType = xmlReader.getValue("injuryType");
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
		     .synchronizeLongLoadingPage();
		
		/**Verify the displayed date (as today by default) on game list screen**/
		gameList.verifyDateDisplayed(displayedDate)
				.synchronizeLongLoadingPage()
				.selectFirstGame()
				.synchronizeLongLoadingPage();
		/**Add players to both teams**/
		teamSelection.addPlayersToTeam(playersOfTeam1)
		             .clickNextTeamButton()
		             .addPlayersToTeam(playersOfTeam2)
		/**Click Finish Setup button to go to Game Time screen**/
		             .clickFinishSetupButton()
		             .synchronizeLongLoadingPage();
		
		/**Click Referee Action button**/
		gameTime.clickRefereeActionsButton()
		        .synchronizePage()
		 /**Click Injury button**/
		        .clickInjuryButton()
		        .synchronizeLongLoadingPage()
		        .verifyInjuryReportScreenDisplayed()
		 /**Select player and injury type**/
		        /**Select first player**/
		        .clickFirstPlayerInjuryReport()
		        .synchronizeLongLoadingPage()
		        /**Select Refused Treatment option**/
		        .clickInjuryType(injuryType)
		        .synchronizeLongLoadingPage()
		        /**Click Continue button**/
		        .clickContinueButton()
		        .synchronizeLongLoadingPage()
		        /**Enter Umpire Code**/
		        .enterUmpireCodeConfirmGame()
		        .synchronizeLongLoadingPage()
		        /**Click Confirm Injury link**/
		        .clickConfirmInjuryButton()
		        .synchronizeLongLoadingPage()
		        .clickBackButton()
		        .synchronizeLongLoadingPage();
		     
		//login.logout();
		
	}
}
