package com.planit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShopPage {
	WebDriver driver;
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	By shop = By.xpath("//a[@href='#/shop']");
	By shopText = By.xpath("(//a[text()='Buy'])[1]");
	By product1 = By.xpath("//li//div//h4[text()='Teddy Bear']/parent::*//a[text()='Buy']");
	By product2 = By.xpath("//li//div//h4[text()='Stuffed Frog']/parent::*//a[text()='Buy']");
	By cart = By.xpath("//a[@href='#/cart']/span");
	
	
	public void NavigateToShopPage() {
		try {
			driver.findElement(shop).click();
			String text = driver.findElement(shopText).getText();
			Assert.assertEquals(text, "Buy");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BuySingleProduct() {
		try {
			String initialCartValue = driver.findElement(cart).getText();
			driver.findElement(product1).click();
			String finalCartValue = driver.findElement(cart).getText();
			Assert.assertEquals(Integer.parseInt(initialCartValue)+1, Integer.parseInt(finalCartValue));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BuyTwoProducts() {
		try {
			String initialCartValue = driver.findElement(cart).getText();
			driver.findElement(product1).click();
			driver.findElement(product2).click();
			String finalCartValue = driver.findElement(cart).getText();
			Assert.assertEquals(Integer.parseInt(initialCartValue)+2, Integer.parseInt(finalCartValue));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
