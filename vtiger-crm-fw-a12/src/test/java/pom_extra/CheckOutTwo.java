package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutTwo {
	public CheckOutTwo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	WebElement fn;
	
	@FindBy(id = "last-name")
	WebElement ln;
	
	@FindBy(id = "postal-code")
	WebElement pc;
	
	@FindBy(className ="cart_button")
	WebElement btn;
	
	public WebElement getFn() {
		return fn;
	}
	
	public WebElement getLn() {
		return ln;
		
	}
	
	public WebElement getPc() {
		return pc;
	}
	
	public WebElement getBtn() {
		return btn;
	}

}
