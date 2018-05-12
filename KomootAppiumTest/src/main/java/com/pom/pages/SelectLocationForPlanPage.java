package com.pom.pages;

//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectLocationForPlanPage {
	
	AppiumDriver<WebElement> driver;
	@AndroidFindBy(id="android:id/search_src_text")
	private WebElement searchLocationTextBox;
	
	@AndroidFindBy(id="de.komoot.android:id/layout_spot_item")
	private List<WebElement> selectLocationList;
	
	
	public SelectLocationForPlanPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	
	public void searchLocationForPlan(String destination) {
		searchLocationTextBox.sendKeys(destination);
	}
	
	public void selectLocationFromList() {
		selectLocationList.get(0).click();
		//selectLocationTextBoxs.get(1).sendKeys(destination);
		
	}

}
