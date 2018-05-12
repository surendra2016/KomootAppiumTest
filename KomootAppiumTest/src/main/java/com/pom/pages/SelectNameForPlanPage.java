package com.pom.pages;

//import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectNameForPlanPage {
	
	AppiumDriver<WebElement> driver;
	@AndroidFindBy(id="de.komoot.android:id/edittext_name")
	private WebElement NameForPlanTextBox;
	
	@AndroidFindBy(id="de.komoot.android:id/textview_button_okay")
	private WebElement SaveNameForPlanButton;
	
	
	public SelectNameForPlanPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	
	public void typeNameForPlan(String name) {
		NameForPlanTextBox.sendKeys(name);
	}
	
	public SummeryForPlanPage saveNameForPlan() {
		SaveNameForPlanButton.click();
		//selectLocationTextBoxs.get(1).sendKeys(destination);
		return new SummeryForPlanPage(driver);
	}

}
