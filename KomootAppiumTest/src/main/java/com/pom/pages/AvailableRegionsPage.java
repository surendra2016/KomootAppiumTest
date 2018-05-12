package com.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AvailableRegionsPage {
	
	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(id="android:id/up")
	private WebElement backToRegionsButton;
	
	@AndroidFindBy(id="de.komoot.android:id/layout_region_teaser_item")
	private List<WebElement> selectLocationList;
	
	public AvailableRegionsPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	
	public GoToRegionsPage selectLocationFromList() {
		selectLocationList.get(0).click();
		return new GoToRegionsPage(driver);
		//selectLocationTextBoxs.get(1).sendKeys(destination);
		
	}
	
	public RegionPage goBackToRegionPage() {
		backToRegionsButton.click();
		return new RegionPage(driver);
	}
}
