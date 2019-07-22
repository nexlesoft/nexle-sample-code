package com.core.test.sportstg.Login;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideLogin;
import com.core.test.BaseTest;
import com.core.utilities.Category.Regression;

public class TC001_Login_ClickChangeLink extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC001_login_ClickChangeLink() throws InterruptedException {
		
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3224";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String courtName = xmlReader.getValue("courtName");
		
		CourtsideLogin login = new CourtsideLogin();

		login.synchronizeLongLoadingPage()
			 .setCourtID(courtsideID)
		     .setSetupID(setupID)
		     .clickChangeLink()
			 .synchronizeLongLoadingPage()
			 .synchronizeLongLoadingPage()
		     .verifyHeaderTitle(courtName)
		     .synchronizeLongLoadingPage()
		     .logout();
		
		
	}
}
