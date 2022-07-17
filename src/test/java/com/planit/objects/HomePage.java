package com.planit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By homePageText = By.xpath("//h1['Jupiter Toys']");
	
	public void NavigateToHomePage() {
		try {
			String text= driver.findElement(homePageText).getText();
			Assert.assertEquals(text, "Jupiter Toys");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
