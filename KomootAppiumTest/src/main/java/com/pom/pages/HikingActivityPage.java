package com.pom.pages;

//import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HikingActivityPage {
	
	AppiumDriver<WebElement> driver;
	
	// Available elements on the page object
	@AndroidFindBy(id="de.komoot.android:id/itbv_back_button_container_fl")
	private WebElement backButton;
	
	@AndroidFindBy(id="de.komoot.android:id/dtsfbv_selected_sport_name_tv")
	private WebElement sportType;
	
	public HikingActivityPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	public String getTextFromSportType() {
		return sportType.getText();
	}
	
	public DiscoveryPage clickOnBackButton() {
		backButton.click();
		return new DiscoveryPage(driver);
	}
}
