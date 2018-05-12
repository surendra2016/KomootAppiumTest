package com.pom.testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pom.pages.DiscoveryPage;
import com.pom.pages.HikingActivityPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class KomootTest {
	
	AppiumDriver<WebElement> driver = null;
	DiscoveryPage discoveryPage;
	HikingActivityPage hikingActivityPage;
	
	@BeforeClass
	public void setUp() {
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "ECAZFG305028"); //Give Device ID of your mobile phone
		//caps.setCapability("udid", "192.168.1.3:5555"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4.2");
		caps.setCapability("appPackage", "de.komoot.android");
		caps.setCapability("appActivity", "de.komoot.android.app.InspirationActivity");
		caps.setCapability("noReset", "true");
		//caps.setCapability("clearSystemFiles", "true");
		
		//Instantiate Appium Driver
		try {
				driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:5000/wd/hub"), caps);
					
			} 
		catch (MalformedURLException e) 
			{
				System.out.println(e.getMessage());
			}
	}
	
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
	
	@Test
	public void komootAppTest1_VerifySportType() {
		
		String expected_sport = "Hiking";
		String expected_discovery_page_title = "Find your perfect Tour";
		discoveryPage = new DiscoveryPage(driver);
		hikingActivityPage = discoveryPage.clickOnHikingActivityButton();
		String actual_sport = hikingActivityPage.getTextFromSportType();
		System.out.println("Actual sport: "+actual_sport);
		Assert.assertEquals(expected_sport, actual_sport);
		boolean chk = false;
		if(actual_sport.contains(expected_sport)) {
			chk = true;
		}
		Assert.assertTrue(chk);
		
		discoveryPage = hikingActivityPage.clickOnBackButton();
		String actual_discovery_page_title = discoveryPage.getTextFromDiscoveryPage();
		System.out.println("Actual sport: "+actual_discovery_page_title);
	}
}
