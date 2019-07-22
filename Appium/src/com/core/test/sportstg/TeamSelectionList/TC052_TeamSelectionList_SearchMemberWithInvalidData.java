package com.core.test.sportstg.TeamSelectionList;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideGameList;
import com.core.page.sportstg.CourtsideGameTime;
import com.core.page.sportstg.CourtsideLogin;
import com.core.page.sportstg.CourtsideTeamSelection;
import com.core.test.BaseTest;
import com.core.utilities.util_Calendar;
import com.core.utilities.Category.Regression;

public class TC052_TeamSelectionList_SearchMemberWithInvalidData extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC052_TeamSelectionList_searchMemberWithInvalidData() throws Exception {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3403";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		final String firstName = xmlReader.getValue("firstName");
		final String lastName = xmlReader.getValue("lastName");
		final String DOBMemberSearch = xmlReader.getValue("DOBMemberSearch");
		
		CourtsideLogin login = new CourtsideLogin();
		CourtsideGameList gameList = new CourtsideGameList();
		util_Calendar calendar = new util_Calendar();
		CourtsideTeamSelection teamSelection = new CourtsideTeamSelection();
		
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
			 .synchronizeLongLoadingPage()
		/**Verify the title in home page**/
		     .verifyHeaderTitle(courtName)
		     .synchronizeLongLoadingPage();
		
		/**Verify the displayed date (as today by default) on game list screen**/
		gameList.verifyDateDisplayed(displayedDate)
				.synchronizeLongLoadingPage()
		/**Go into the first game on game list screen**/
				.selectFirstGame()
				.synchronizeLongLoadingPage();
		
		/**Change team button**/
		teamSelection.clickSearchButton()
		             .synchronizePage()
		             .enterFirstNameMemberSearch(firstName)
		             .enterLastNameMemberSearch(lastName)
		             .enterDOBMemberSearch(DOBMemberSearch)
		             .synchronizePage()
		             .tapSearchIconMemberSearch()
		             .synchronizeLongLoadingPage()
		             .verifySearchedResultMemberSearch("0 MEMBERS FOUND")
		             .synchronizeLongLoadingPage()
		             .tapCloseIconMemberSearch()
		             .synchronizePage()
		             .clickBackButton()
		             .synchronizeLongLoadingPage();
		             
		
		/**Verify back to game list successfully**/
		gameList.verifyDateDisplayed(displayedDate)
			    .synchronizePage();
		
		/**Clear the data to logout the system**/
		//login.logout();
		
	}
}
