package com.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MapPage {
	
	AppiumDriver<WebElement> driver;
	@AndroidFindBy(id="de.komoot.android:id/button_tracking_start")
	private WebElement startRecordingActivityButton;
	
	@AndroidFindBy(id="de.komoot.android:id/textview_start_recording")
	private WebElement startRecordingText;
	
	public MapPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	public MapViewPage clickOnStartRecordingActivityButton() {
		startRecordingActivityButton.click();
		return new MapViewPage(driver);
	}
	
	public boolean verifyStartRecordingText() {
		return startRecordingText.isDisplayed();
	}

}
