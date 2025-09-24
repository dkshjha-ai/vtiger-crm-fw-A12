package organiztion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchOrganizationTest {
	
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
		
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.name("search_text"));
		search.clear();
		
		String orgToSearch= "automationwithPiyush03";
		search.sendKeys(orgToSearch);
		
		Thread.sleep(2000);
		WebElement searchIn= driver.findElement(By.id("bas_searchfield"));
		Select sel= new Select(searchIn);
		sel.selectByValue("accountname");
		
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(5000);
		driver.quit();
		 
	}
	
}
		
		