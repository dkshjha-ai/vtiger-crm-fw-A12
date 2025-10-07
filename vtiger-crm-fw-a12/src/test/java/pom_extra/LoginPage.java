package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(id="user-name")
	WebElement un;
	
	@FindBy(id ="password")
	WebElement pwd;
	
	@FindBy(id = "login-button")
	WebElement login;
	
	//Getters
	public WebElement getUn() {
		return un;
	}
	
	public WebElement getPwd() {
		return pwd;
	}
	
	public WebElement getLogin() {
		return login;
	}

}
