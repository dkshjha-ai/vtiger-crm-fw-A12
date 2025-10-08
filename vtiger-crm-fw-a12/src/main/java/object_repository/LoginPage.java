package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "user_name")
	private WebElement un;
	
	@FindBy(name = "user_password")
	private WebElement pwd;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;
	
	public WebElement getUserName() {
		return un;
	}
	
	public WebElement getPassword() {
		return pwd;
	}
	
	public WebElement getLoginBtn() {
		return loginbtn;
	}
	
	//Bussiness Utility
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
		un.sendKeys(USERNAME);
		pwd.sendKeys(PASSWORD);
		loginbtn.click();
	}

}
