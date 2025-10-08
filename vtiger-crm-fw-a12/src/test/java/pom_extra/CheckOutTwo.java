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
	private WebElement fn;
	
	@FindBy(id = "last-name")
	private WebElement ln;
	
	@FindBy(id = "postal-code")
	private WebElement pc;
	
	@FindBy(className ="cart_button")
	private WebElement btn;
	
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

