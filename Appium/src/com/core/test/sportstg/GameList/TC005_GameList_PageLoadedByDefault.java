package com.core.test.sportstg.GameList;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideGameList;
import com.core.page.sportstg.CourtsideLogin;
import com.core.test.BaseTest;
import com.core.utilities.util_Calendar;
import com.core.utilities.Category.Regression;

public class TC005_GameList_PageLoadedByDefault extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC005_GameList_pageLoadedByDefault() throws Exception {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3228";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		
		CourtsideLogin login = new CourtsideLogin();
		CourtsideGameList gameList = new CourtsideGameList();
		util_Calendar calendar = new util_Calendar();
		
		String day = calendar.getCurrentDate("EEEE");
		String date = calendar.getCurrentDate("d");
		String suffix = calendar.getDaySuffix(Integer.parseInt(date));
		String month = calendar.getCurrentDate("MMMM");
		String year = calendar.getCurrentDate("YYYY");
		String displayedDate = day + " " + date+suffix+" " + month+", "+year;
				
		/**Login to the system**/
		login.synchronizeLongLoadingPage()
		/**Enter data for Court ID, Setup ID, then press Enter to login the system**/
			 .setCourtID(courtsideID)
		     .setSetupID(setupID)
		     .clickChangeLink()
			 .synchronizeLongLoadingPage()
		/**Verify the title in home page**/
		     .verifyHeaderTitle(courtName)
		     .synchronizePage();
		
		/**Verify the displayed date (as today by default), UI elements displayed properly
		 *  on game list screen**/
		gameList.verifyDateDisplayed(displayedDate)
				.synchronizePage()
				.verifyStartTimeDisplayed()
				.synchronizePage()
				.verifyTeamsDisplayed()
				.synchronizePage()
				.verifyCompsDisplayed()
				.synchronizePage()
				.verifyStatusDisplayed()
				.synchronizePage()
				.verifyAdminBtnDisplayed()
				.synchronizePage()
				.verifyOnlineDisplayed()
				.synchronizePage();
		     
		//login.logout();
		
	}
}
