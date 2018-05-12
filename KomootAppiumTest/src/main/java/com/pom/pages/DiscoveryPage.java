package com.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DiscoveryPage {
	
	AppiumDriver<WebElement> driver;
	
	// Available elements on the page object
	
	@AndroidFindBy(xpath="//android.widget.TextView")
	private List<WebElement> titleTexts;
	
	@AndroidFindBy(id="de.komoot.android:id/imageViewTabHome")
	private WebElement discoverActivityButton;
	
	@AndroidFindBy(id="de.komoot.android:id/imageViewTabPlanning")
	private WebElement planActivityButton;
	
	@AndroidFindBy(id="de.komoot.android:id/imageViewTabMap")
	private WebElement mapActivityButton;
	
	@AndroidFindBy(id="de.komoot.android:id/imageViewTabProfile")
	private WebElement profileActivityButton;
	
	@AndroidFindBy(id="de.komoot.android:id/imageViewTabRegions")
	private WebElement regionsActivityButton;
	
	@AndroidFindBy(id="de.komoot.android:id/dsrli_image_riv")
	private List<WebElement> sportActivityButton;
	
	
	public DiscoveryPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	public void clickOnDiscoverActivityButton() {
		discoverActivityButton.click();
	}
	
	public PlanPage clickOnPlanActivityButton() {
		planActivityButton.click();
		return new PlanPage(driver);
	}
	
	public MapPage clickOnMapActivityButton() {
		mapActivityButton.click();
		return new MapPage(driver);
	}
	
	public void clickOnProfileActivityButton() {
		profileActivityButton.click();
	}
	
	public RegionPage clickOnRegionsActivityButton() {
		regionsActivityButton.click();
		return new RegionPage(driver);
	}
	
	public HikingActivityPage clickOnHikingActivityButton() {
		sportActivityButton.get(0).click();
		return new HikingActivityPage(driver);
	}
	
	public String getTextFromDiscoveryPage() {
		return titleTexts.get(0).getText();
	}
	
	public void scrollSportsHorizontal() {
		TouchAction actions = new TouchAction(driver);
		actions.press(sportActivityButton.get(2)).waitAction(Duration.ofSeconds(2)).moveTo(sportActivityButton.get(0)).release().perform();
	}
	
	public void scrollSportsHorizontalReverse() {
		TouchAction actions = new TouchAction(driver);
		actions.press(sportActivityButton.get(1)).waitAction(Duration.ofSeconds(2)).moveTo(sportActivityButton.get(3)).release().perform();
	}

}
