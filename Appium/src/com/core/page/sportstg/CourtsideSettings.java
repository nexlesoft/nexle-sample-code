package com.core.page.sportstg;

import org.openqa.selenium.By;

import com.core.annotation.ActiveMethod;
import com.core.page.Page;
import com.core.support.Core;
import com.core.support.MyElement;
import com.core.support.base.BaseButton;

public class CourtsideSettings extends Page {
	
	private static CourtsideSettings instance;
	public static CourtsideSettings Instance = (instance != null) ? instance : new CourtsideSettings();
    
	public CourtsideSettings(){}
    
	MyElement myElement = new MyElement();
	
    /** UI Mappings */
	
    //By ClearAllLinkLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView");
    //By ClearAllConfirmationBtnLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[2]/android.widget.TextView");
    
    By CLEARALLLinkLocator = myElement.getElement("CLEARALLLinkLocator");
    By ClearAllConfirmationBtnLocator = myElement.getElement("ClearAllConfirmationBtnLocator");
    
    
    /** Page Methods */
    
    /**
	 * Click 'Clear ALL' link on the page
	 */
	@ActiveMethod(page = "CourtsideSettings", name = "clickClearAllLink", author = "Prabhdeep", date = "8/06/2018")
	public CourtsideSettings clickClearAllLink() {
		logger.debug("Clicking 'CLEAR All ' link ");
		BaseButton.tap(CLEARALLLinkLocator);
		return this;
	}
	
	/**
	 * Click 'Clear ALL' link on the page
	 */
	@ActiveMethod(page = "CourtsideSettings", name = "clickClearAllBtn", author = "Prabhdeep", date = "8/06/2018")
	public CourtsideSettings clickClearAllConfirmationBtn() {
		logger.debug("Clicking 'Clear All' button ");
		BaseButton.tap(ClearAllConfirmationBtnLocator);
		return this;
	}
    
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideSettings", name = "synchronizePage", author = "Thanh Phan", date = "6/05/2018")
    public CourtsideSettings synchronizePage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.implicitlyWait(5);
        return this;
    }
	
	 /**
     * Verify no state change overlay prevents webdriver interaction with the page
     */
	@ActiveMethod(page = "CourtsideSettings", name = "synchronizeLongLoadingPage", author = "Thanh Phan", date = "5/15/2018")
    public CourtsideSettings synchronizeLongLoadingPage() {		
        logger.debug("Verifying invisibility of squid block overlay before continuing...");
        Core.synchronizeLongLoadingSportsTG(10,360);
        return this;
    }
}
