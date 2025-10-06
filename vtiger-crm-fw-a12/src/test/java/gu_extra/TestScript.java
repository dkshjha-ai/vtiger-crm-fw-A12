package gu_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.WebDriverUtility;

public class TestScript {

	public static void main(String[] args) {
		String firstName="Binod";
		
		WebDriver driver = new ChromeDriver();
	
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		//wdUtil.congrats();
		//wdUtil.morning();
		wdUtil.openUrl();
		wdUtil.winMax();
		
		WebElement profilePic= driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		//Actions act = new Actions(driver);
		//act.moveToElement(profilePic).build().perform();
		
		wdUtil.hover(profilePic);

	}

}
