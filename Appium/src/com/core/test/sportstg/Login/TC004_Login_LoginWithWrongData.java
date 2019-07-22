package com.core.test.sportstg.Login;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.core.page.sportstg.CourtsideLogin;
import com.core.test.BaseTest;
import com.core.utilities.Category.Regression;

public class TC004_Login_LoginWithWrongData extends BaseTest {

	@Category({Regression.class})
	@Test
	public void TC004_Login_loginWithWrongData() throws InterruptedException {
		
		/*********************************************
		 * Assign Test Case ID from TestRail 
		 *********************************************/	
		
		testCaseID="3227";
		
		/*********************************************
		 * Initialize Test Data 
		 *********************************************/
		final String courtsideID = xmlReader.getValue("courtsideID");
		final String setupID = xmlReader.getValue("setupID");
		final String invalidLoginTxt = xmlReader.getValue("invalidLoginTxt");
		
		CourtsideLogin login = new CourtsideLogin();

		login.synchronizeLongLoadingPage()
			 .setCourtID(courtsideID)
		     .setSetupID(setupID)
		     .clickChangeLink()
			 .synchronizeLongLoadingPage()
			 .verifyErrorMsgInvalidLogin(invalidLoginTxt)
			 .synchronizePage();
		
	}
}
