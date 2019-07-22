package com.core.support;

import org.openqa.selenium.By;

import com.core.annotation.ActiveMethod;

public class commonLocator {
	
	/**
	 * This method is used to get the input field element locator by passing in the Field Name
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By inputFieldLocator(String strFieldName)
	{
		By inputLocator= By.xpath("//div[text()='" + strFieldName + "']/following::div[1]/descendant::input[1]");	
		return inputLocator;	
	}
	
	/**
	 * This method is used to get the element locator of an input field in specific tab by passing in the Tab Name and Field Name
	 * @author Ming Yee
	 * @param strTab
	 * @param strFieldName
	 * @return
	 */
	public static By inputFieldInTabLocator(String strTab, String strFieldName)
	{
		By inputLocator= By.xpath("//div[text()='" + strTab + "']/ancestor::ul[@role='tablist']/following::div/descendant::div[text()='" + strFieldName + "']/../following::div[1]/descendant::input[1]");	
		return inputLocator;	
	}
	
	
	/**
	 * This method is used to get the element locator for text field in Read Only mode
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By editorFieldLocator(String strFieldName)
	{
		By editorFieldLocator= By.xpath ("//div[@class='nx-basicfieldeditor-item']/descendant::div[text()='" + strFieldName + "']/../div/following::div[1]/div[1]");		
		return editorFieldLocator;	
	}
	
	/**
	 * This method is used to get the element locator for Read Only text field with hyperlink
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By linkEditorFieldLocator(String strFieldName)
	{
		By editorFieldLocator= By.xpath ("//div[@class='nx-basicfieldeditor-item']/descendant::div[text()='" + strFieldName + "']/../following::div[1]/div/a");		
		return editorFieldLocator;	
	}
	
	
	/**
	 * This method is used to get the element locator for Read Only text field in wizard
	 * @author Ming Yee
	 * @param strStep - The step number in the wizard
	 * @param strFieldName
	 * @return
	 */
	public static By dialogEditorFieldLocator(String strStep, String strFieldName)
	{
		By editorFieldLocator= By.xpath ("//div[@data-stepid='"+ strStep + "']/descendant::div[text()='" + strFieldName + "']/../div/following::div[1]/div[1]");		
		return editorFieldLocator;	
	}
	
	/**
	 * This method is used to get the element locator for Read Only text field with hyperlink in a Tab
	 * @author Ming Yee
	 * @param strTabName
	 * @param strFieldName
	 * @return
	 */
	public static By linkEditorFieldInTabLocator(String strTabName, String strFieldName)
	{
		By editorFieldLocator=By.xpath("//div[text()='" + strTabName + "']/ancestor::ul[@role='tablist']/following::div/descendant::div[text()='" + strFieldName + "']/../following::div[1]/div/a");
		return editorFieldLocator;
	}
	
	/**
	 * This method is used to get the element locator for Read Only text field in Tab
	 * @author Ming Yee
	 * @param strTabName
	 * @param strFieldName
	 * @return
	 */
	public static By editorFieldInTabLocator(String strTabName, String strFieldName)
	{
		//By editorFieldLocator=By.xpath("//div[text()='" + strTabName + "']/ancestor::ul[@role='tablist']/following::div/descendant::div[text()='" + strFieldName + "']/../following::div[1]/div");
		By editorFieldLocator=By.xpath("//div[text()='" + strTabName + "']/ancestor::ul[@role='tablist']/following::div/descendant::div[text()='" + strFieldName + "']/../following-sibling::div[1]/div");
		return editorFieldLocator;
	}
	
		
	/**
	 * This method is used to get the picklist field element locator by passing in the Field Name
	 * @author Ming Yee
	 * @param strFieldName 
	 * @return
	 */
	public static By picklistFieldLocator (String strFieldName)
	{
		By picklistLocator= By.xpath("//div[text()='" + strFieldName + "']/following::div[1]/descendant::select[1]");
		return picklistLocator;
	}
	
	
	/**
	 * This method is used to get the element locator for button on dialog window by passing in the step number and button label
	 * @author Ming Yee
	 * @param strStep - The step of Dialog window e.g. First page of the dialog window will be step1
	 * @param strBtnLabel - The label of the button
	 * @return
	 */
	public static By dialogButtonLocator (String strStep, String strBtnLabel)
	{
		By buttonLocator= By.xpath("//div[@data-stepid='"+ strStep + "']/descendant::span[text()='"+ strBtnLabel + "']");
		return buttonLocator;	
	}
	
	/**
	 * This method is used to get the element locator for button on single step dialog window
	 * @author Ming Yee
	 * @param strBtnLabel
	 * @return
	 */
	public static By dialogButtonLocator (String strBtnLabel)
	{
		//By buttonLocator= By.xpath("//div[@data-stepid='"+ strStep + "']/descendant::span[text()='"+ strBtnLabel + "']");
		By buttonLocator= By.xpath("//div[contains(@class, 'ui-dialog-content')]/descendant::span[text()='"+ strBtnLabel + "']");
		return buttonLocator;	
	}
	
	/**
	 * This method is used to get the element locator of a lookup icon for a specific field in Add New Competition Wizard > Basic Information
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By LookupIconLocator (String strFieldName)
	{
		//By lookupLocator = By.xpath("//div[text()='"+ strFieldName +"']/../following::div[1]/descendant::div[@style='cursor: pointer;']");
		By lookupLocator = By.xpath("//div[text()='"+ strFieldName +"']/following::div[1]/descendant::div[contains(@class, 'icon-search')]");
		return lookupLocator;
	}

	/**
	 * This method is used to get the element location for item selection icon in Lookup page
	 * @author Ming Yee
	 * @param strValue
	 * @return
	 */
	public static By LookupSelectionLocator (String strValue) 
	{
		By lookupSelectionLocator = By.xpath("//div[text()='" + strValue + "']/ancestor::tr[1]/td[1]/descendant::div[@role='button']");
		return lookupSelectionLocator;
	}
	
	
	/**
	 * This method is used to get the Checkbox element locator for specific field
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By checkboxLocator(String strFieldName)
	{
		By checkboxLocator=By.xpath("//div[text()='" + strFieldName + "']/../following::div[1]/input[@type='checkbox']");
		return checkboxLocator;
	}
	
	/**
	 * This method is used to get the element locator for Checkbox in Read Only mode
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By editorCheckboxLocator(String strFieldName)
	{
		By editorLocator= By.xpath ("//div[@class='nx-basicfieldeditor-item']/descendant::div[text()='" + strFieldName + "']/../div/following::div[1]/div[1]/input[@type='checkbox']");		
		return editorLocator;	
	}
	

	/**
	 * This method is used to get element locator for Tab on Detail page
	 * @author Ming Yee
	 * @param strTabName
	 * @return
	 */
	public static By pageTabLocator(String strTabName)
	{
		By tabLocator=By.xpath("//li[@role='tab']/descendant::div[text()='"+ strTabName + "']");
		return tabLocator;
	}
	
	/**
	 * This method is used to get the page title element locator on Detail page
	 * @author Ming Yee
	 * @return
	 */
	public static By detailPageTitleLocator()
	{
		By titleLocator=By.xpath("//div[@class='nx-pagetitle-maintitle']/descendant::div[@class='nx-fieldtext']");
		return titleLocator;
	}
	
	/**
	 * This method is used to get the text area input field element locator by passing in the Field Name
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By textAreaInputFieldLocator(String strFieldName)
	{
		By inputLocator= By.xpath("//div[text()='" + strFieldName + "']/following::div[1]/descendant::textarea[1]");	
		return inputLocator;	
	}
	
	/**
	 * This method is used to get the text area input field element locator by passing in the Field Name and Tab Name
	 * @author Ming Yee
	 * @param tabName
	 * @param strFieldName
	 * @return
	 */
	public static By textAreaInputFieldLocator(String tabName, String strFieldName)
	{
		By inputLocator= By.xpath("//div[text()='" + tabName + "']/ancestor::ul[@role='tablist']/following::div/descendant::div[text()='" + strFieldName + "']/following::div[1]/descendant::textarea[1]");	
		return inputLocator;	
	}
	
	/**
	 * This method is used to get the Search Filter field element locator by passing in the Search field name
	 * @param strSearchField
	 * @return
	 */
	public static By searchFilterFieldLocator(String strSearchField)
	{
		By searchFieldLocator = By.xpath("//input[@class='searchbox' and @placeholder='"+ strSearchField + "']");
		return searchFieldLocator;
	}
	
	/**
	 * This method is used to get the input field element locator by passing in the Field Name on Membership Form
	 * @author Ming Yee
	 * @param strFieldName
	 * @return
	 */
	public static By formInputFieldLocator(String strFieldName)
	{
		By inputLocator= By.xpath("//label[text()='" + strFieldName + "']/following-sibling::input");	
		return inputLocator;	
	}
	
	/**
	 * This method is used to get the picklist field element locator by passing in the Field Name on Membership Form
	 * @author Ming Yee
	 * @param strFieldName 
	 * @return
	 */
	public static By formPicklistFieldLocator (String strFieldName)
	{
		By picklistLocator= By.xpath("//label[text()='" + strFieldName + "']/following-sibling::select");
		return picklistLocator;
	}
	
	
	
	/**
	 * This method is used to get action Button element locator on List page
	 * @author Ming Yee
	 * @param strButtonLabel 
	 * @return
	 */
	public static By actionButtonLocator(String strButtonLabel)
	{
		By actionButtonLocator = By.xpath("//div[@class='nx-actionselect-dropdown-item' and text()='" + strButtonLabel + "']");
		return actionButtonLocator;
	}
	
	/**
	 * This method is used to get Button element locator on Detail page
	 * @author Ming Yee
	 * @param strButtonLabel 
	 * @return
	 */
	public static By pageButtonLocator(String strButtonLabel)
	{
		By pageButtonLocator = By.xpath("//span[@class='ui-button-text' and text()='" + strButtonLabel + "']");
		return pageButtonLocator;
	}
	
}
