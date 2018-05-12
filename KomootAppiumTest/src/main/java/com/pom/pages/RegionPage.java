package com.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegionPage {
	
	AppiumDriver<WebElement> driver;
	@AndroidFindBy(id="de.komoot.android:id/textview_title")
	private WebElement titleSelectARegionOption;
	
	@AndroidFindBy(id="de.komoot.android:id/button_voucher")
	private WebElement viewVouchersButton;
	
	@AndroidFindBy(id="de.komoot.android:id/button_menu_search")
	private WebElement searchRegionButton;
	
	public RegionPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		// initialize all element on the page using driver which will find elements for us
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	// Available actions on the elements
	public boolean verifySelectARegionOptionText() {
		return titleSelectARegionOption.isDisplayed();
	}
	
	public SelectLocationForRegionPage selectLocationForRegion() {
		searchRegionButton.click();
		return new SelectLocationForRegionPage(driver);
	}
	
	public ViewVouchersPage viewVouchers() {
		viewVouchersButton.click();
		return new ViewVouchersPage(driver);
	}
}
