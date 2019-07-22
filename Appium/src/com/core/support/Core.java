package com.core.support;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.core.utilities.KeyValue;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import com.core.Driver;

public class Core {
	
	protected static AppiumDriver<MobileElement> 				driver;
    public static final int STANDARD_WAIT = Integer.valueOf(KeyValue.getTimeoutProperty("StandardWait"));
    public static final int IFRAME_WAIT = 	Integer.valueOf(KeyValue.getTimeoutProperty("IframeWait"));
    public final Logger 					logger = Logger.getLogger(this.getClass());
    
    public static void setDriver(AppiumDriver<MobileElement> _driver) {
    	driver = _driver;
    }
    
    public Core() {}
    
    public Core(AppiumDriver<MobileElement> driver) {
        this();
    }

    
    /**
     * Go back (Browser back button functionality)
     */
    public void back() {
        driver.navigate().back();
    }
    
    /**
     * Find an element within the current page. Continue execution upon nothing found.
     * @param 	by Element to locate
     * @param 	wait How long to wait for the element to be located
     * @return 	List containing all elements located
     */
    public static WebElement findElementIgnoreError(By by, int... wait) {
       
    	int timeout = (wait.length < 1) ? STANDARD_WAIT : wait[0]; 
    	
    	try {
(			new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
            
            if(Boolean.parseBoolean(KeyValue.getGeneralProperty("HighlightElementFound"))) {
            	highlightElementSelected(by);
            }
            
            return driver.findElement(by);
        } catch (RuntimeException e) {}
    	
    	return null;
    }
    
   
    
    /**
     * Find all elements within the current page. Continue execution upon nothing found.
     * @param 	by Element to locate
     * @param 	wait How long to wait for presence of element before requesting attribute
     * @return 	List containing all elements located
     */
    public static List<MobileElement> findElementsIgnoreError(By by, int... wait) {
    	
    	int timeout = (wait.length < 1) ? STANDARD_WAIT : wait[0]; 
    	
        try {
            (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
           
            if(Boolean.parseBoolean(KeyValue.getGeneralProperty("HighlightElementFound"))) {
            	highlightElementSelected(by);
            }
            return driver.findElements(by);
        } catch (Exception e) {
        	return new ArrayList<MobileElement>();
        }
    }
    
    /**
     * Find an element within the page.
     * @param 	element By element to find.
     * @param 	wait How long to wait before returning an exception.
     * @return 	The element found
     */
    public static MobileElement findElement(By by, int... wait) {
    	
    	int timeout = (wait.length < 1) ? STANDARD_WAIT : wait[0]; 
    	
        try {
            (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
            
            return driver.findElement(by);
        } catch (Exception e) {
            throw new RuntimeException("Unable to locate the requested element: " + by);
        }
    }
    
  
    /**
     * Locate all elements within the current page
     * @param 	by Element to locate
     * @param 	wait How long to wait for visibility of element before requesting attribute
     * @return 	All elements as a list
     */
    public static List<MobileElement> findElements(By by, int... wait) {
    	
    	int timeout = (wait.length < 1) ? STANDARD_WAIT : wait[0]; 
    	
        try {
            /*(new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
            
            if(Boolean.parseBoolean(KeyValue.getGeneralProperty("HighlightElementFound"))) {
            	highlightElementSelected(by);
            }*/
            
            return driver.findElements(by);
        } catch (Exception e) {
            throw new RuntimeException("Unable to locate the requested element: " + by);
        }
    }
    
    /**
     * Get visibility of an element
     * @param 	by Element to find
     * @return 	boolean
     */
    public static boolean getVisibilityOfElement(By by) {
                
        try {
	        if(findElement(by).isDisplayed()) {
	        	return true;
	        }  
        } catch(Exception e) {} 
        
        return false;    
    }
    
  
    /**
     * Get presence of an element within the DOM
     * @param 	by Element to find
     * @return 	boolean
     */
    public boolean getPresenceOfElement(By by) {
                
        try {
	        if(findElements(by).size() > 0) {
	        	return true;
	        }  
        } catch(Exception e) {}  
        
        return false;
    }
    
   
    
    /**
     * Get the requested text of an element
     * @param 	wait How long to wait for visibility of element before requesting attribute
     * @return 	Text value associated with the element queried
     */
    public static String getElementText(By by, int... wait) {
	   
    	int timeout = (wait.length < 1) ? STANDARD_WAIT : wait[0];      
	   
        try {
            return findElement(by, timeout).getText();
        } catch (Exception e) {
            throw new RuntimeException("Unable to determine the requested element property: text");
        }
    }
    
   
    /**
     * Get the requested attribute of an element
     * @param 	attribute Element attribute to return
     * @param 	wait How long to wait for visibility of element before requesting attribute
     * @return 	Value of the attribute requested
     */
    public static String getElementAttribute(By by, String attribute, int... wait) {
            	
    	int timeout = (wait.length < 1) ? STANDARD_WAIT : wait[0];      
        
        try {
            return findElement(by, timeout).getAttribute(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Unable to determine the requested element attribute: " + attribute);
        }
    }
    
   
    
    /**
     * Get the page title
     */
    public static String getTitle() {
        return driver.getTitle();
    }
    
    public static void highlightElementSelected(By by) {
    	
    	JavascriptExecutor 		js = (JavascriptExecutor) driver;
    	WebElement 				element = driver.findElement(by);
    	
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
				element, "color: red; border: 3px solid red;");
    }
    
    /**
     * Maximize the browser window
     * Note: Same functionality as hitting the maximize button on the browser.
     */
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }
    
    /**
     * Navigate to a URL
     */
    public static void navigate(String url) {
        driver.get(url);
    }
    
    /**
     * Refresh the current page (Same has hitting browser reload button)
     */
    public static void refresh() {
        driver.navigate().refresh();
    }
    
    /**
     * Set browser size
     * @param 	width Width set in pixels
     * @param 	height Height set in pixels
     */
    public static void setBrowserSize(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
    }
    
    /**
     * Set driver content to parent page
     */
    public static void setContentToDefault() {
        driver.switchTo().defaultContent();
    }
    
    /**
     * Set browser context to a new window or tab
     * @param windowHandle id of the window to switch to
     */
    public void setWindowHandle(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }
    
    /**
     * Loading Sync Catch-All
     */
    public static void synchronizeSportsTG() {
		By loadingIndicator = By.xpath("//div[text()='Loading...']");
		
		try {
	        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(loadingIndicator));
		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, 40)).until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
		} catch(Exception e) {}
    }
    
    
    /**
     * Loading Sync Catch-All - Longer Timeout
     */
    public static void synchronizeLongLoadingSportsTG() {
		By loadingIndicator = By.xpath("//div[text()='Loading...']");
		
		try {
	        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(loadingIndicator));
		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, 180)).until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
		} catch(Exception e) {}
    }
    
    /**
     * Loading Sync Catch-All - Longer Timeout
     */
    public static void synchronizeLongLoadingSportsTG(int visibleWaitTimer, int invisibleWaitTimer) {
		By loadingIndicator = By.xpath("//div[text()='Loading...']");
		
		try {
	        (new WebDriverWait(driver, visibleWaitTimer)).until(ExpectedConditions.visibilityOfElementLocated(loadingIndicator));
		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, invisibleWaitTimer)).until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
		} catch(Exception e) {}
    }
    
    
    
    
    /**
     * SportsTG hide help popover
     */
    public static void hideHelpBottomRightSportsTG() {
		By 						helpPopover = By.xpath("//div[contains(@class, 'right_corner')]");
		JavascriptExecutor 		js = (JavascriptExecutor) driver;
		WebElement 				element;
		
		try {
			element = driver.findElement(helpPopover);
	        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(helpPopover));
			js.executeScript("arguments[0].setAttribute('style', 'display:none')", element);

		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, 30)).until(ExpectedConditions.invisibilityOfElementLocated(helpPopover));
		} catch(Exception e) {}
    }
    
    /**
     * SportsTG hide a specific element
     */
    public static void hideElement(By by) {
		//By 						helpPopover = By.xpath("//div[contains(@class, 'right_corner')]");
		JavascriptExecutor 		js = (JavascriptExecutor) driver;
		WebElement 				element;
		
		try {
			element = driver.findElement(by);
	        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(by));
			js.executeScript("arguments[0].setAttribute('style', 'display:none')", element);

		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, 30)).until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch(Exception e) {}
    }
       
    
    /**
     * Saving Sync Catch-All
     */
    public static void synchronizeSavingSportsTG() {
		By savingIndicator = By.xpath("//div[text()='Saving...']");
		
		try {
	        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(savingIndicator));
		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(savingIndicator));
		} catch(Exception e) {}
    }
    
    
    /**
     * Synchronize page for specific text
     */
    public static void synchronizePage(String strText, int waitVisibility, int waitInvisibility) {
		By textIndicator = By.xpath("//div[text()='" + strText + "']");
		
		try {
	        (new WebDriverWait(driver, waitVisibility)).until(ExpectedConditions.visibilityOfElementLocated(textIndicator));
		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, waitInvisibility)).until(ExpectedConditions.invisibilityOfElementLocated(textIndicator));
		} catch(Exception e) {}
    }
    
    
    /**
     * Please wait Sync Catch-All
     */
    public static void synchronizePleaseWaitSportsTG() {
		By pleaseWaitIndicator = By.xpath("//div[text()='Please wait...']");
		
		try {
	        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(pleaseWaitIndicator));
		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(pleaseWaitIndicator));
		} catch(Exception e) {}
    }
    
    
    /**
     * Please wait Sync Catch-All with specific wait timeout
     */
    public static void synchronizePleaseWaitSportsTG(int waitVisibility, int waitInvisibility) {
		By pleaseWaitIndicator = By.xpath("//div[text()='Please wait...']");
		
		try {
	        (new WebDriverWait(driver, waitVisibility)).until(ExpectedConditions.visibilityOfElementLocated(pleaseWaitIndicator));
		} catch(Exception e) {}
		
		try {
	        (new WebDriverWait(driver, waitInvisibility)).until(ExpectedConditions.invisibilityOfElementLocated(pleaseWaitIndicator));
		} catch(Exception e) {}
    }
    
    
    public static String getListOfElementsText(By by)
    {
    	List<MobileElement> list = Core.findElements(by, 10);
		
		String text = "";		
		for(WebElement element : list)
		{	
			text= text + element.getText() + ",";
		} 	
   	
    	return text;
    }
    
    
    /**
     * Scroll to a specific element when it is out of view
     * @param by
     */
    public static void scrollToElement(By by)
    {
       WebElement element = driver.findElement(by);
       //int elementPosition = element.getLocation().getY();
       //String js = String.format("window.scroll(0, %s)", elementPosition);
       //((JavascriptExecutor)driver).executeScript(js);
       //arun:27/04/18 Above code was not scrolling to element
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    
    /**
     * Get Page URL
     * @param by
     */
    public static String getCurrentPageURL()
    {
       String URL = driver.getCurrentUrl();
       return URL;
    }
    
    public static String getValueOfAttribute(By by, String strAttribute)
    {
    	String strValue = driver.findElement(by).getAttribute(strAttribute);
    	
    	return strValue;
    }
    
    /**
     * Switch to specific tab based on tabs order
     * @param i - Tab index which start from 0
     */
    public static void switchToTab(int i)
    {
    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(i));
    }
    
    /**
    * Get the number of same xpath in a traditional html table
    * @param by By element representing the select element.
    * @return Cell text
    * @author Thanh
    */
    public static int getElementsCount(By by) {

    int count = -1;
    List<MobileElement> elements = findElements(by);

    count = elements.size();

    return count;
    }
    
    
    /**
     * To remove 'readonly' attribute of an specific input element
     * @param by Element to remove 'readonly' attribute
     * @author Ming Yee
     */
     public static void removeReadOnlyAttribute(By by) {

    	 WebElement input = driver.findElement(by);
    	 ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].removeAttribute('readonly','readonly')",input);
     }
     
     
     /**
      * To press Enter key
      * @author Thanh Phan
      */
     public static void pressENTERKey(By by) {
    	
    	 driver.findElement(by).sendKeys(Keys.ENTER);

     }
     
     /**
      * To press key from keyboard for Android device
      * @author Thanh Phan
      */
     public static void pressKeyFromKeyboard(By by, String key) {
    	
    	switch (key) {
		case "1":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
			break;
		case "2":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2);
			break;
		case "3":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_3);
			break;
		case "4":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_4);
			break;
		case "5":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_5);
			break;
		case "6":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_6);
			break;
		case "7":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_7);
			break;
		case "8":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_8);
			break;
		case "9":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_9);
			break;
		case "0":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
			break;
		case "A":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
			break;
		case "B":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_B);
			break;
		case "C":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_C);
			break;
		case "D":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_D);
			break;
		case "E":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_E);
			break;
		case "F":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_F);
			break;
		case "G":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_G);
			break;
		case "H":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_H);
			break;
		case "I":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_I);
			break;
		case "J":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_J);
			break;
		case "K":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_K);
			break;
		case "M":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_M);
			break;
		case "N":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_N);
			break;
		case "L":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_L);
			break;
		case "O":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O);
			break;
		case "P":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_P);
			break;
		case "Q":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Q);
			break;
		case "R":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_R);
			break;
		case "S":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_S);
			break;
		case "T":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
			break;
		case "U":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
			break;
		case "V":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_V);
			break;
		case "W":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_W);
			break;
		case "X":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_X);
			break;
		case "Y":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Y);
			break;
		case "Z":
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Z);
			break;

		default:
			break;
		}

     }
     
     
     /**
      * To zoom out a page by specific times
      *@param strZoomPercentage
      * @author Ming Yee
      */
     public static void setPageZoom(String strZoomPercentage) {
    	 ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '" + strZoomPercentage + "';");
     
     }
     
     /** 
      * Wait for element to get visible on the page
      * @param element
      * @param visisbletimeout
      * @param invisibletimeout
      * @author Prabhdeep
      **/
    public static void synchronizeWait(By by, int visibleTimeOut, int invisibleTimeOut) {
    	  
    	    try {
    	    	  (new WebDriverWait(driver, visibleTimeOut)).until(ExpectedConditions.visibilityOfElementLocated(by));
    	    	} catch(Exception e) {}
    	    		
    	    	try {
    	    	       (new WebDriverWait(driver, invisibleTimeOut)).until(ExpectedConditions.invisibilityOfElementLocated(by));
    	    		} catch(Exception e) {}
    	        }
    	    
     
     /**
      * Method to swith between multiple windows
      * @author Arun
      * @date 01/04/2018
      */
     public static void switchWindow()
     {
     	String parentWindowHandle = driver.getWindowHandle();
     	Set<String> getAllWindowHandle = driver.getWindowHandles();
     	
     	for (String childWindowHandler : getAllWindowHandle) 
     	{    		
     		if(childWindowHandler!=parentWindowHandle){    			
     			driver.switchTo().window(childWindowHandler);
     		}
 		  }  
     }  
     
     /**
      * Get the number of same xpath in a traditional html table
      *
      */
      public static String getParentWindow() {

    	  String parent_Window = driver.getWindowHandle(); 

    	  return parent_Window;
      }
     
     /**
      * Method to back to parent window
      * @author Thanh Phan
      * @date 01/17/2018
      */
     public static void switchToParentWindow(String parentWindow)
     {
    	 driver.switchTo().window(parentWindow);
     }   
     
     /**
      * Method to close the current tab of the browser
      * @author Arun
      */
     public static void closeCurrentTab(){
    	 driver.close();
     }      
     /**
      * Method to wait for element to be available for selection
      * @author Arun
      * @param control
      */
     public static void clickOverlapElement(By control){
    	 	
    	 WebElement element =  findElement(control, 20);    	 
    	 JavascriptExecutor jse = (JavascriptExecutor)driver;    	    	 
    	 jse.executeScript("arguments[0].click();", element);     	     	
     }
     
     /**
      * Method to implement implicit wait used for AusKick registration
      * 
      */
     public static void implicitlyWait(int waitTime){
 	 	driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);     	     	
     } 
     /**
      * Method to click an element using Actions class
      * @author arun
      * @param control
      */
     public static void clickElementUsingActions(By control){
 	 	
    	 Actions action = new Actions(driver);    	 
    	 WebElement element =  findElement(control, 20);    	 
    	 action.moveToElement(element).click().build().perform();    	      	     
     }
     
     public static void pressEnterKey() {
    	 ((AndroidDriver<MobileElement>) driver).pressKeyCode(66);
     }
     
     public static void context(){
  	 	
    	Set<String> availableContexts = driver.getContextHandles();
 		System.out.println("Total No of Context Found After we reach to WebView = "+ availableContexts.size());
 		for(String context : availableContexts) {
 			if(context.contains("WEBVIEW")){
 				System.out.println("Context Name is " + context);
 				driver.context(context);
 				break;
 			}
 		}   	      	     
     }
     
     public static void pressEnter(String text) {
    	 driver.getKeyboard().sendKeys(text);
     }
     
     public static void pressEnterFromKeyboard() {
    	 driver.getKeyboard().sendKeys(Keys.ENTER);
     }
     
     public static void pressReturnFromKeyboard() {
    	 driver.getKeyboard().sendKeys(Keys.RETURN);
     }
}

