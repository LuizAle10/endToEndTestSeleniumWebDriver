package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	private final WebDriver driver;
	
	WebElement Subtotal_Text;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;				
	}
	
	public String getSubTotal() {
		Subtotal_Text = driver.findElement(By.cssSelector(".yourtotal > span:nth-child(1)"));
		return Subtotal_Text.getText();		
	}
	
}
