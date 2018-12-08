package test;

import org.testng.annotations.Test;

import page.CheckoutPage;
import page.HomePage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class DemoStoreTest {

	public WebDriver driver;
	HomePage homePage;
	CheckoutPage checkoutPage;

	@Test
	public void testAddProductToCheckOut() /*throws InterruptedException*/ {
		String textToSearch = "tv";		
		homePage.searchForAProduct(textToSearch);
		assertTrue(homePage.isTextElementContains(textToSearch.toUpperCase()), "First search result did not returned the expected product.");
		String priceFirstProduct = homePage.getPriceFirstProduct();
		System.out.println("Price first product =" + priceFirstProduct);
		System.out.println("Before = " + homePage.getNumberOfItems());
		homePage.clickButtonAddToCartFirstProduct();
		System.out.println("After = " + homePage.getNumberOfItems());
		checkoutPage = homePage.clickCheckoutButton();
		String subtotal = checkoutPage.getSubTotal();
	    System.out.println("SUBTOTAL = " + subtotal);
		assertEquals(priceFirstProduct, subtotal, "Product price different from subtotal.");
		//Thread.sleep(5000);
	}

	@BeforeMethod
	public void beforeMethod() {
		String geckoDriver = "webdriver.gecko.driver";
		String geckoDriverLinuxLocation = "//home//marcelo//drivers//geckodriver";
		System.setProperty(geckoDriver, geckoDriverLinuxLocation);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		homePage = PageFactory.initElements(driver, HomePage.class);		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
