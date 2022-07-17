package com.planit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By cart = By.xpath("//a[@href='#/cart']");
	By cartPageText = By.xpath("//a[text()='Shopping']");
	By productText = By.xpath("//tr//td[contains(text(),' Teddy Bear')]");
	By productSubTotal = By.xpath("(//tbody/tr/td[contains(text(),' Teddy Bear')]/parent::*/td)[4]");
	By productQuantity = By.xpath("//tbody/tr/td[contains(text(),' Teddy Bear')]/parent::*/td/input[@name='quantity']");
	By emptyCart = By.xpath("//a[text()='Empty Cart']");
	By emptyCartYes = By.xpath("//a[text()='Yes']");
	By emptyCartConfirmation = By.xpath("//Strong[text()='Your cart is empty']");
	
	public void NavigateToCart() {
		try {
			driver.findElement(cart).click();
			String text = driver.findElement(cartPageText).getText();
			Assert.assertEquals(text, "Shopping");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void ProductQuantityUpdated() {
		try {
			
			driver.findElement(productQuantity).click();
			driver.findElement(productQuantity).clear();
			driver.findElement(productQuantity).sendKeys("3");
			String subTotal = driver.findElement(productSubTotal).getText();
			Assert.assertEquals(subTotal, "$38.97");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void EmptyCart() {
		try {
			driver.findElement(emptyCart).click();
			driver.findElement(emptyCartYes).click();
			String text = driver.findElement(emptyCartConfirmation).getText();
			Assert.assertEquals(text, "Your cart is empty");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	
}
