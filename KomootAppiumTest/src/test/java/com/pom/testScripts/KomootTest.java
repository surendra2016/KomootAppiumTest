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
import com.pom.pages.PlanPage;
import com.pom.pages.SelectLocationForPlanPage;
import com.pom.pages.SelectNameForPlanPage;
import com.pom.pages.SummeryForPlanPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class KomootTest {
	
	AppiumDriver<WebElement> driver = null;
	DiscoveryPage discoveryPage;
	HikingActivityPage hikingActivityPage;
	PlanPage planPage;
	SelectLocationForPlanPage selectLocationForPlanPage;
	SelectNameForPlanPage selectNameForPlanPage;
	SummeryForPlanPage summeryForPlanPage;
	
	public int generateRandomNumber() {
		
		/*
		 Method to generate the random number 
		 */
		int max = 100;
		int min = 1;
		int diff = max - min;
		Random rn = new Random();
		int number = rn.nextInt(diff + 1);
		number += min;
		//System.out.print("The Random Number is " + number);
		
		return number;
	}
	
	@BeforeClass
	public void setUp() {
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "ECAZFG305028"); //Give Device ID of your mobile phone
		//caps.setCapability("udid", "192.168.1.3:5555"); //Give ip address of your mobile phone in case connection is over wifi
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
		
		/*
		 This test case simulates following test steps
		 1. Open the Komooth app.
		 2. By default user can see the 'Discovery' page as a landing page.
		 3. There are few other sports listed in a row under title 'Find your perfect Tour'.
		 4. click on the first sport, i.e. Hiking.
		 5. Verify whether the correct page is opened by verifying the text 'Hiking' on HikingActivityPage.
		 6. Click on 'back' button to navigate back to the 'Discovery' page.
		 */
		
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
	
	@Test
	public void komootAppTest2_HorizontalSportType() {
		/*
		 This test case simulates following test steps
		 1. Open the Komooth app.
		 2. By default user can see the 'Discovery' page as a landing page.
		 3. There are few other sports listed in a row under title 'Find your perfect Tour'.
		 4. Scroll horizontally to right to see all sports.
		 5. Scroll back to the original position.  
		 */
		String expected_sport = "Hiking";
		discoveryPage = new DiscoveryPage(driver);
		discoveryPage.scrollSportsHorizontal();
		discoveryPage.scrollSportsHorizontalReverse();
	}
	
	@Test
	public void komootAppTest3_verifyPlanPage() {
		
		/*
		 This test case simulates following test steps
		 1. Open the Komooth app.
		 2. By default user can see the 'Discovery' page as a landing page.
		 3. Click on the 'Plan' button to plan a trip.
		 4. Provide details like 'Sport type', 'Start location', 'Destination location'.
		 5. Save the trip.
		 6. Click 'back' button on the page object 'SummeryForPlanPage' to navigate back to 'PlanPage'.  
		 */
		
		String source = "Paderborn";
		String destination = "Hamm";
		discoveryPage = new DiscoveryPage(driver);
		planPage = discoveryPage.clickOnPlanActivityButton();
		planPage.clickOnPlanSportActivityButton();
		planPage.scrollSportsHorizontal();
		planPage.scrollSportsHorizontalReverse();
		planPage.clickOnPlanSportActivityButton();
		selectLocationForPlanPage = planPage.selectSourceLocation();
		selectLocationForPlanPage.searchLocationForPlan(source);
		selectLocationForPlanPage.selectLocationFromList();
		selectLocationForPlanPage = planPage.selectDestinationLocation();
		selectLocationForPlanPage.searchLocationForPlan(destination);
		selectLocationForPlanPage.selectLocationFromList();
		
		System.out.println("We'll wait for three seconds..");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Wait for three seconds is over..");
		selectNameForPlanPage = planPage.savePlan();
		selectNameForPlanPage.typeNameForPlan(source+"To"+destination+"_"+this.generateRandomNumber());
		
		summeryForPlanPage = selectNameForPlanPage.saveNameForPlan();
		
		System.out.println("We'll wait for three seconds..");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Wait for three seconds is over..");
		
		summeryForPlanPage.clickBackButtonOnSummeryPlan();
	}
}
