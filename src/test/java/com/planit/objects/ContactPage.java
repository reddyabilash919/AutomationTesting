package com.planit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactPage {
	WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By contact = By.xpath("//a[@href='#/contact']");
	By pageText = By.xpath("//div//strong[text()='We welcome your feedback']");
	By forename = By.name("forename");
	By surename = By.name("surname");
	By email = By.name("email");
	By message = By.name("message");
	By submit = By.xpath("//a[text()='Submit']");
	By verifyText = By.xpath("//strong[contains(text(),'Thanks')]");
	
	
	
	
	public void NavigateToContactPage() throws InterruptedException {
		driver.findElement(contact).click();
		String text =driver.findElement(pageText).getText();
		Assert.assertEquals(text, "We welcome your feedback");
		
	}
	
	public void EnterForename() {
		try {
			driver.findElement(forename).sendKeys("Abilash");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void EnterSurname() {
		try {
			driver.findElement(surename).sendKeys("D J");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void EnterEmail() {
		try {
			driver.findElement(email).sendKeys("abilash@planit.com.au");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void EnterMessage() {
		try {
			driver.findElement(message).sendKeys("Issue with my payment process");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Submit() {
		try {
			driver.findElement(submit).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VerifyContactSubmit() {
		try {
			driver.findElement(submit).click();
			String text = driver.findElement(verifyText).getText();
			Assert.assertTrue(text.contains("Thanks"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
