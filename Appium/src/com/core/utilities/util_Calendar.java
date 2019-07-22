package com.core.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

public class util_Calendar {
	protected Logger logger;
	private RemoteWebDriver driver;
	
	
	public util_Calendar(){
		logger = Logger.getLogger(this.getClass().getName() + "]");
	}
	
	public util_Calendar(RemoteWebDriver driver){
		this.driver = driver;
		logger = Logger.getLogger(this.getClass().getName() + "],[" + driver);
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------
	// Return current date as string in MM/dd/yyyy format.
	public String getCurrentDate() throws Exception {
		
		String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());		
		logger.info("        Returned Current Date: " + currentDate);
	    return currentDate;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------------
	public String getCurrentDate(String format) throws Exception {
		
		String currentDate = new SimpleDateFormat(format).format(Calendar.getInstance().getTime());		
		logger.info("        Returned Current Date: " + currentDate);
	    return currentDate;
	}
	
	public String getFutureDate_withDaysAddedToCurrentDate(String format, int days) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);		
		String futureDate = new SimpleDateFormat(format).format(cal.getTime());		
		logger.info("        Returned Future Date: " + futureDate);
	    return futureDate;
	}
	
	/**
	 * Get the date with specific number of years added to today's date in specific format
	 * @author Ming Yee
	 * @param format
	 * @param numberOfyears
	 * @return
	 */
	public String getFutureDate_withYearsAddedToCurrentDate(String format, int numberOfyears)
	{
		DateFormat dateFormat =new SimpleDateFormat(format);
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());	
		date.add(Calendar.YEAR, numberOfyears);		
		String futureDate  = dateFormat.format(date.getTime());	
		return futureDate;
	}
		
	/**
	 * Get current day of the week
	 * @author Ming Yee
	 * @return
	 */
	public String getCurrentDayOfWeek(){
		
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		switch (dayOfWeek) {
	    case Calendar.SUNDAY:
	    	return "Sunday";
	    case Calendar.MONDAY:
	    	return "Monday";
	    case Calendar.TUESDAY:
	    	return "Tuesday";	        
	    case Calendar.WEDNESDAY:
	    	return "Wednesday";	    
	    case Calendar.THURSDAY:
	        return "Thursday";	     
	    case Calendar.FRIDAY:
	        return "Friday";	        
	    case Calendar.SATURDAY:
	        return "Saturday";
	    default:
	    	return "Others";
		}

	}
	
	/**
	 * Get day of the week for date with days added to current date
	 * @author Ming Yee
	 * @return
	 */
	public String getDayOfWeek_withDaysAddedToCurrentDate(int days){
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);		
		
		switch (dayOfWeek) {
	    case Calendar.SUNDAY:
	    	return "Sunday";
	    case Calendar.MONDAY:
	    	return "Monday";
	    case Calendar.TUESDAY:
	    	return "Tuesday";	        
	    case Calendar.WEDNESDAY:
	    	return "Wednesday";	    
	    case Calendar.THURSDAY:
	        return "Thursday";	     
	    case Calendar.FRIDAY:
	        return "Friday";	        
	    case Calendar.SATURDAY:
	        return "Saturday";
	    default:
	    	return "Others";
		}

	}
	
	public String getDaySuffix(int inDay)
	{
	  String s = String.valueOf(inDay);

	  if (s.equals("1")||s.equals("21")||s.equals("31"))
	  {
	    return "st";
	  }
	  else if (s.equals("2")||s.equals("22"))
	  {
	    return "nd";
	  }
	  else if (s.equals("3")||s.equals("23"))
	  {
	    return "rd";
	  }
	  else
	  {
	    return "th";
	  }
	}
	
}
