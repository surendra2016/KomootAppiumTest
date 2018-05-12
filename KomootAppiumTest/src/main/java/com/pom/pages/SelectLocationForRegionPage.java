package com.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectLocationForRegionPage {
	
	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(id="de.komoot.android:id/textview_empty_state")
	private WebElement selectLocation;
	
	@AndroidFindBy(id="android:id/search_src_text")
	private WebElement searchLocationTextbox;
	
	public SelectLocationForRegionPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	public void searchLocationForRegion(String regionName) {
		searchLocationTextbox.sendKeys(regionName);
	}
	
	public AvailableRegionsPage selectLocationFromList() {
		selectLocation.click();
		return new AvailableRegionsPage(driver);
		//return new AvailableRegionsPage(driver);
		//selectLocationTextBoxs.get(1).sendKeys(destination);	
	}
}
