package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	
	public WebElement getorgLink() {
		return orgLink;
		
	}
	
	@FindBy(css ="img[src='themes/softed/images/user.PNG']")
	private WebElement profilepic;
	
	public WebElement getprofilepic() {
		return profilepic;
	}
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
    
	
	public WebElement getsignOutLink() {
		return signOutLink;
	}

}
