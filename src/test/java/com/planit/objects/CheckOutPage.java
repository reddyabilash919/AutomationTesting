package com.planit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckOutPage {
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkOutBtn = By.xpath("//a[text()='Check Out']");
	By checkOutText = By.xpath("//strong[text()='Almost there']");
	By forename = By.name("forename");
	By surename = By.name("surname");
	By email = By.name("email");
	By address = By.name("address");
	By submit = By.xpath("//button[text()='Submit']");
	By cardType = By.id("cardType");
	By cardNum = By.id("card");
	By orderConfirmation = By.xpath("//Strong[contains(text(),'Thanks')]");
	
	
	public void NavigateToCheckoutPage() {
		try {
			driver.findElement(checkOutBtn).click();
			String text = driver.findElement(checkOutText).getText();
			Assert.assertEquals(text, "Almost there");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void OrderPurchase() {
		try {
		  driver.findElement(forename).sendKeys("Abi");
		  driver.findElement(email).sendKeys("Abi@google.com");
		  driver.findElement(address).sendKeys("Melbourne, Australia");
		  Actions builder = new Actions(driver);
		  WebElement element = driver.findElement(cardType);
		  Action dragAndDrop = builder.clickAndHold(element).moveToElement(element).release(element).build();
		  dragAndDrop.perform();
		  Select card = new Select(driver.findElement(cardType));
		  card.selectByValue("Visa");
		  driver.findElement(cardNum).sendKeys("123456789023");
		  driver.findElement(submit).click();
		  Thread.sleep(3000);
		  String orderConfirm = driver.findElement(orderConfirmation).getText();
		  Assert.assertEquals(orderConfirm, "Thanks Abi");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
