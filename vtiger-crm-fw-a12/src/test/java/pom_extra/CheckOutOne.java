package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOne {
	public CheckOutOne(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "shopping_cart_container")
	WebElement shoppingcart;
	
	public WebElement getShoppingCart() {
		return shoppingcart;
	}

	@FindBy(linkText = "CHECKOUT")
	WebElement checkout;
	
	public WebElement getCheckOut() {
		return checkout;
	}
}
 