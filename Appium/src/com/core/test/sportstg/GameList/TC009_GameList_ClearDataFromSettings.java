package com.core.test.sportstg.GameList;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideGameList;
import com.core.page.sportstg.CourtsideLogin;
import com.core.page.sportstg.CourtsideSettings;
import com.core.test.BaseTest;
import com.core.utilities.Category.Regression;

public class TC009_GameList_ClearDataFromSettings extends BaseTest {

	
	@Category({Regression.class})
	@Test
	public void TC009_GameList_ClearDataFrom_Settings() throws InterruptedException {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3232";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		
		CourtsideLogin login = new CourtsideLogin();
		CourtsideGameList gameList = new CourtsideGameList();
		CourtsideSettings settings = new CourtsideSettings();

		//clear old data
		login.synchronizeLongLoadingPage()
			 .logout();
				
		login.synchronizeLongLoadingPage()
			 .setCourtID(courtsideID)
		     .setSetupID(setupID)
		     .pressEnterKey()
			 .synchronizeLongLoadingPage()
			 .synchronizeLongLoadingPage();
		
		gameList.clickAdminButton()
		        .synchronizeLongLoadingPage()
		        .clickSettingsLink()
		        .synchronizeLongLoadingPage();
		
		settings.clickClearAllLink()
				.synchronizeLongLoadingPage()
		        .clickClearAllConfirmationBtn()
		        .synchronizeLongLoadingPage();
		
		login.synchronizePage()
			 .verifyLoginPopupTitle("Enter Court & Setup ID")
		     .synchronizePage();
		
		
		
	}
}
