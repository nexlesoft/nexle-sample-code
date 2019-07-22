package com.core.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.core.annotation.ActiveMethod;
import com.core.gurock.testrail.APIClient;
import com.core.gurock.testrail.APIException;
import com.core.test.BaseTest;

public class util_TestRail {
	
	static DateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static Date date =new Date();
	static String todayDate = dateFormat.format(date);
	private final static Logger logger = Logger.getLogger(util_TestRail.class.getName());
	
	
	/**
	 * This method is used to add a new Test Run to specific project in TestRail, get the Test Run ID and set it to BaseTest.runID
	 * @author Ming Yee
	 * @param projectID
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws APIException
	 */
	public static void addNewTestRun(String projectID) throws MalformedURLException, IOException, APIException
	{
		APIClient client = util_TestRail.testRailSetup();
		
		//Map<String, Comparable> data = new HashMap<String, Comparable>();
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("name", "Courtside Automation Test Run - " + todayDate);
		data.put("include_all", true);
		
		logger.debug("Adding a new Test Run to Project (ID: " + projectID + ") in TestRail");
		JSONObject r = (JSONObject) client.sendPost("add_run/" + projectID, data);
		
		//BaseTest.runID=(Long) r.get("id");
		//logger.debug("Test Run ID : " + BaseTest.runID );
		util_TestWatcher.runID=(Long) r.get("id");
		logger.debug("Test Run ID : " + util_TestWatcher.runID );

	}
	

	/**
	 * This method is used to update test result for specific Test Case in specific Test Run
	 * @author Ming Yee
	 * @param testRunID
	 * @param testCaseID
	 * @param testResult
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws APIException
	 */
	public static void updateTestResult(Long testRunID, String testCaseID, String testResult, String FailureMsg) throws MalformedURLException, IOException, APIException
	{
		APIClient client = util_TestRail.testRailSetup();		
	
		//Map<String, Comparable> data = new HashMap<String, Comparable>();	
		Map<String, Object> data = new HashMap<String, Object>();
		
		if(testResult.equalsIgnoreCase("Passed"))
		{
			data.put("status_id", new Integer(1));
			data.put("comment", "Worked as expected");
			logger.debug("Updating Test Result of Test Case(ID: " + testCaseID + ") in Test Run(ID: " + testRunID + ") as 'Passed'");
		}
		else
		{
			data.put("status_id", new Integer(5));
			//data.put("comment", "Test Failed");
			data.put("comment", "Failed with the following: " + '\n'+ FailureMsg);
			logger.debug("Updating Test Result of Test Case(ID: " + testCaseID + ") in Test Run(ID: " + testRunID + ") as 'Failed'");
		}
		
		JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + testRunID + "/" + testCaseID, data);
	}

	/**
	 * Common method to navigate to TestRail's url, set User & Password, then return APIClient
	 * @return
	 */
	private static APIClient testRailSetup()
	{
		APIClient client = new APIClient("https://sportstg.testrail.net/");
		client.setUser("jcho@sportstg.com");
		client.setPassword("Testing123");
		return client;
	}
	
}
