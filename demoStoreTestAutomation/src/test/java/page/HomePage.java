package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	private final WebDriver driver;

	@FindBy(name = "s")
	WebElement Search_Input;

	WebElement FirstProduct_Link;

	WebElement AddToCartFirst_Button;

	// @FindBy(css = "div.product_grid_item:nth-child(1) > div:nth-child(2) >
	// h2:nth-child(1) > a:nth-child(1)")

	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.get("http://store.demoqa.com/");
		String expectedPageTitle = "ONLINE STORE | Toolsqa Dummy Test site";
		assertEquals(driver.getTitle(), expectedPageTitle, "The page title is different from the expected.");
	}

	public HomePage searchForAProduct(String text) {
		Search_Input.sendKeys(text);
		Search_Input.sendKeys(Keys.RETURN);

		FirstProduct_Link = driver.findElement(By.cssSelector(
				"div.product_grid_item:nth-child(1) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)"));
		System.out.println("FP = " + FirstProduct_Link.getText());
		return this;
	}

	public boolean isTextElementContains(String text) {
		return FirstProduct_Link.getText().contains(text);
	}

	public HomePage clickButtonAddToCartFirstProduct() {
		AddToCartFirst_Button = driver.findElement(By.cssSelector(
				"div.product_grid_item:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(3) > div:nth-child(1) > span:nth-child(1) > input:nth-child(1)"));
		AddToCartFirst_Button.click();
		return this;
	}

	public String getNumberOfItems() {
		// NumberOfItems_Link = driver.findElement(By.cssSelector(".count"));
		WebElement NumberOfItems_Link = driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div[1]/a/em[1]"));

		// return Integer.parseInt(NumberOfItems_Link.getText());
		return NumberOfItems_Link.getText();
	}

	public CheckoutPage clickCheckoutButton() {
		WebElement Checkout_Button = driver.findElement(By.cssSelector("span.icon:nth-child(3)"));
		Checkout_Button.click();
		return new CheckoutPage(driver);
	}

	public String getPriceFirstProduct() {
		WebElement PriceFirstProduct_Text = driver
				.findElement(By.cssSelector("p.\\38 9:nth-child(2) > span:nth-child(1)"));
		return PriceFirstProduct_Text.getText();
	}

}
