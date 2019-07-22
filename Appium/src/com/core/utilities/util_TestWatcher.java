package com.core.utilities;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runners.model.Statement;

import com.core.gurock.testrail.APIException;
import com.core.test.BaseTest;

public class util_TestWatcher {
	
	public static String testCaseID ="";
    public static Long runID;
	private final static Logger logger = Logger.getLogger(util_TestWatcher.class.getName());

    @Rule
    public TestRule testWatcher = new TestWatcher() {

        @Override
        protected void succeeded(Description description) {
                  	
        	logger.debug("Test " + description.getDisplayName() + " passed");
        	if(runID!=null & !testCaseID.equalsIgnoreCase("") )
        	{
            //logger.debug("Test Case(ID: " + BaseTest.testCaseID + ") in Test Run(ID: " + BaseTest.runID + ") is Passed ");
            try {
				util_TestRail.updateTestResult(runID, testCaseID, "Passed", "");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (APIException e) {
				e.printStackTrace();
			}
            
           // BaseTest.testCaseID="";
        	}
        }

        @Override
        protected void failed(Throwable e, Description description) {
            logger.debug("Test " + description.getDisplayName() + " failed");
            
            Failure failure = new Failure(description, e);
            String failuremsg = failure.getTrace();
            logger.debug("Failed with : " +  failuremsg);
            
            if(runID!=null & !testCaseID.equalsIgnoreCase("") )
        	{
            //logger.debug("Test Case(ID: " + BaseTest.testCaseID + ") in Test Run(ID: " + BaseTest.runID+ " is Failed");
    		try {
				util_TestRail.updateTestResult(runID, testCaseID, "Failed",failuremsg);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (APIException e1) {
				e1.printStackTrace();
			}
        	}
        }

    };

}


	
	
	


