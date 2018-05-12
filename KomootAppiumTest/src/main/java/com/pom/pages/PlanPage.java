package com.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlanPage {
	
	AppiumDriver<WebElement> driver;
	@AndroidFindBy(id="de.komoot.android:id/psfb_base_row_container_ll")
	private WebElement planSportActivityButton;
	
	@AndroidFindBy(id="de.komoot.android:id/stlivh_container")
	private List<WebElement> selectSportActivityButtons;
	
	@AndroidFindBy(id="de.komoot.android:id/pwb_location_name_tatv")
	private List<WebElement> selectLocationTextBoxs;
	
	@AndroidFindBy(id="de.komoot.android:id/pnsrb_save_route_tb")
	private WebElement planSaveButton;
	
	public PlanPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	public void clickOnPlanSportActivityButton() {
		planSportActivityButton.click();
	}
	
	public void scrollSportsHorizontal() {
		TouchAction actions = new TouchAction(driver);
		actions.press(selectSportActivityButtons.get(3)).waitAction(Duration.ofSeconds(2)).moveTo(selectSportActivityButtons.get(1)).release().perform();
	}
	
	public void scrollSportsHorizontalReverse() {
		TouchAction actions = new TouchAction(driver);
		actions.press(selectSportActivityButtons.get(3)).waitAction(Duration.ofSeconds(2)).moveTo(selectSportActivityButtons.get(5)).release().perform();
	}
	
	public SelectLocationForPlanPage selectSourceLocation() {
		selectLocationTextBoxs.get(0).click();
		//selectLocationTextBoxs.get(1).sendKeys(destination);
		return new SelectLocationForPlanPage(driver);
		
	}
	
	public SelectLocationForPlanPage selectDestinationLocation() {
		selectLocationTextBoxs.get(1).click();
		//selectLocationTextBoxs.get(1).sendKeys(destination);
		return new SelectLocationForPlanPage(driver);
		
	}
	
	public SelectNameForPlanPage savePlan() {
		planSaveButton.click();
		return new SelectNameForPlanPage(driver);
	}

}
