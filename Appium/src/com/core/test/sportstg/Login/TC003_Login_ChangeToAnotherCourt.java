package com.core.test.sportstg.Login;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideLogin;
import com.core.test.BaseTest;
import com.core.utilities.Category.Regression;

public class TC003_Login_ChangeToAnotherCourt extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC003_Login_changeToAnotherCourt() throws InterruptedException {
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3226";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		final String newCourtsideID = xmlReader.getValue("newCourtsideID");
		final String newSetupID = xmlReader.getValue("newSetupID");
		final String newCourtName = xmlReader.getValue("newCourtName");
		
		CourtsideLogin login = new CourtsideLogin();

		login.synchronizeLongLoadingPage()
			 .setCourtID(courtsideID)
		     .setSetupID(setupID)
		     .clickChangeLink()
			 .synchronizeLongLoadingPage()
			 .synchronizeLongLoadingPage()
		     .verifyHeaderTitle(courtName)
		     .synchronizeLongLoadingPage()
		     .changeCourt()
		     .setCourtID(newCourtsideID)
		     .setSetupID(newSetupID)
		     .pressEnterKey()
		     .synchronizeLongLoadingPage()
		     .synchronizeLongLoadingPage()
		     .verifyHeaderTitle(newCourtName)
		     .synchronizeLongLoadingPage()
		     .logout();
		
	}
}
