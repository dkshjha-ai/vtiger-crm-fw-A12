package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SearchCalendarTest {

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
		
		//click on calendar
		driver.findElement(By.linkText("Calendar")).click();
		
		//click all event
		driver.findElement(By.linkText("All Events & Todos")).click();
		
		//click search
	
		WebElement search = driver.findElement(By.name("search_text"));
		search.click();
		
		String orgToSearch= "Follow-up call with ABC Corp";
		search.sendKeys(orgToSearch);
		
		Thread.sleep(2000);
		WebElement searchIn= driver.findElement(By.id("bas_searchfield"));
		Select sel= new Select(searchIn);
		sel.selectByValue("subject");
		
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		WebElement profilePic= driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		}

}
