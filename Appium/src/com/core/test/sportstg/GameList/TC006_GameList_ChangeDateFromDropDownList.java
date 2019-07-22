package com.core.test.sportstg.GameList;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideGameList;
import com.core.page.sportstg.CourtsideLogin;
import com.core.test.BaseTest;
import com.core.utilities.util_Calendar;
import com.core.utilities.Category.Regression;

public class TC006_GameList_ChangeDateFromDropDownList extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC006_GameList_changeDateFromDropDownList() throws Exception {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3229";
		
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
		String futureDay = calendar.getFutureDate_withDaysAddedToCurrentDate("EEEE", 1);
		String futureDate = calendar.getFutureDate_withDaysAddedToCurrentDate("d", 1);
		String futureSuffix = calendar.getDaySuffix(Integer.parseInt(futureDate));
		String futureMonth = calendar.getFutureDate_withDaysAddedToCurrentDate("MMMM", 1);
		String futureYear = calendar.getFutureDate_withDaysAddedToCurrentDate("YYYY", 1);
		String displayedFutureDate = futureDay + " " + futureDate+futureSuffix+" " + futureMonth+", "+futureYear;
			
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
				.synchronizePage()
				.selectAnotherDate(futureDate)
				.synchronizePage();
				//.verifyDateDisplayed(displayedFutureDate);
	
	}
}
