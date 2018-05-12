package com.pom.pages;

//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GoToRegionsPage {
	
	AppiumDriver<WebElement> driver;
	@AndroidFindBy(id="android:id/up")
	private WebElement backToAvailableRegionsButton;
	
	@AndroidFindBy(id="de.komoot.android:id/button_buy")
	private WebElement getItNowRegionsButton;
	
	public GoToRegionsPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	
	
	public AvailableRegionsPage gobackToAvailableRegionsPage() {
		backToAvailableRegionsButton.click();
		return new AvailableRegionsPage(driver);
	}
	
	public boolean verifyGetItNowButtonPresent(){
		return getItNowRegionsButton.isDisplayed();
	}

}
