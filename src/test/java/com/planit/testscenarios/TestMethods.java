package com.planit.testscenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.planit.objects.CartPage;
import com.planit.objects.CheckOutPage;
import com.planit.objects.ContactPage;
import com.planit.objects.HomePage;
import com.planit.objects.ShopPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods {
	private WebDriver driver;
	private ContactPage contact;
	private HomePage home;
	private ShopPage shop;
	private CartPage cart;
	private CheckOutPage check;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		
	}
	//Test case 1 to test user navigating to home page
	@Test(priority=0)
	public void NavigateToHomePage() {
		home = new HomePage(driver);
		home.NavigateToHomePage();
		
	}
	// Test case 2 to test user entering contact details and submitting the form
	@Test(priority=1)
	public void SubmitContactInfo() throws InterruptedException {
        contact = new ContactPage(driver);
        contact.NavigateToContactPage();
		contact.EnterForename();
		contact.EnterSurname();
		contact.EnterEmail();
		contact.EnterMessage();
		contact.VerifyContactSubmit();
	}
	
	// Test Case 3 to test user navigating to shop page 
	@Test(priority=2)
	public void NavigateToShopPage() {
		shop = new	ShopPage(driver);
		shop.NavigateToShopPage();
	}
	
	// Test case 4 to test user buying one product in shop page 
	@Test(priority=3)
	public void BuyOneProduct() {
	    shop = new	ShopPage(driver);
		shop.BuySingleProduct();
	}
	
	// Test Case 5 to test user buying multiple products in shop page 
	@Test(priority=4)
	public void BuyMultipleProducts() {
	    shop = new	ShopPage(driver);
		shop.BuyTwoProducts();
	}
	
	// Test case 6 to test user navigating to cart page 
	@Test(priority=5)
	public void NavigateToCartPage() {
	    cart = new CartPage(driver);
		cart.NavigateToCart();
				
	}
	
	// Test Case 7 to test user updating quantity of a product in cart page 
	@Test(priority=6)
	public void UpdateProductQuantity() {
		 cart = new CartPage(driver);
		 cart.ProductQuantityUpdated();
	}
	
	// Test Case 8 to test user clears all the products added to cart
	@Test(priority=7)
	public void ClearCart() {
		 cart = new CartPage(driver);
		 cart.EmptyCart();
	}
	
	// Test Case 9 to test user navigate to checkout page 
	@Test(priority=8)
	public void ProceedToCheckOut() {
		 shop = new ShopPage(driver);
		 cart = new CartPage(driver);
		 check = new CheckOutPage(driver);
		 shop.NavigateToShopPage();
		 shop.BuySingleProduct();
		 cart.NavigateToCart();
		 check.NavigateToCheckoutPage();
	}
	
	// Test case 10 to test user purchasing the order by entering all the details 
	@Test(priority=9)
	public void OrderPurchaseDetails() {
		 shop = new ShopPage(driver);
		 cart = new CartPage(driver);
		 check = new CheckOutPage(driver);
		 check.OrderPurchase();
	}
	
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
	

}
