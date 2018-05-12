package com.pom.pages;

//import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SummeryForPlanPage {
	
	AppiumDriver<WebElement> driver;
	
	
	@AndroidFindBy(className="android.widget.ImageButton")
	private WebElement BackButtonOnSummeryPlan;
	
	public SummeryForPlanPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
		
	public PlanPage clickBackButtonOnSummeryPlan() {
		BackButtonOnSummeryPlan.click();
		//selectLocationTextBoxs.get(1).sendKeys(destination);
		return new PlanPage(driver);
		
	}

}
