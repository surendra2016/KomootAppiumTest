package com.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MapViewPage {
	
	AppiumDriver<WebElement> driver;
	@AndroidFindBy(id="de.komoot.android:id/msb_stop_button_tb")
	private WebElement stopRecordingActivityButton;
	
	public MapViewPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	public MapPage clickOnStopRecordingActivityButton() {
		//stopRecordingActivityButton.click();
		TouchAction action = new TouchAction(driver);
		action.longPress(stopRecordingActivityButton).perform();
		return new MapPage(driver);
	}

}
