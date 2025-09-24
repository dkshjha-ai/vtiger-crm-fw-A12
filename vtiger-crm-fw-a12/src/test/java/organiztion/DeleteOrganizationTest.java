package organiztion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DeleteOrganizationTest {

	public static void main(String[] args) throws InterruptedException {
		//open browswer
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Login
		driver.get("http://localhost:8888/");
		
		//Enter UserName
		WebElement un= driver.findElement(By.name("user_name"));
		un.sendKeys("admin");
		
		//Enter Password
		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys("manager");
		
		//Click LogIn
		driver.findElement(By.id("submitButton")).click();
		
		//Create organization
		driver.findElement(By.linkText("Organizations")).click();
		
		Thread.sleep(2000);
		//click on edit
		WebElement ele = driver.findElement(By.linkText("del"));
		ele.click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(1000);
		WebElement profilePic= driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}

