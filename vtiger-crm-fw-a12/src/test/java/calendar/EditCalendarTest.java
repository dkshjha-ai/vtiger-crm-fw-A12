package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EditCalendarTest {

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
				
				//click on edit
				Thread.sleep(1000);
				driver.findElement(By.linkText("Follow-up call with ABC Corp")).click();
				
				//Thread.sleep(1000);
				//driver.findElement(By.linkText("edit")).click();
				
				Thread.sleep(1000);
				driver.findElement(By.name("Edit")).click();
				
				Thread.sleep(1000);
				WebElement compField = driver.findElement(By.name("subject"));
		        compField.clear();
		        compField.sendKeys("Follow-up call with XYZ Ltd");
		        
		        WebElement locationField = driver.findElement(By.name("location"));
		        locationField.clear();
		        locationField.sendKeys("Mumbai");
		        
		        Select statusDropdown = new Select(driver.findElement(By.id("eventstatus")));
		        statusDropdown.selectByValue("Planned");
		        
		        Thread.sleep(1000);
		        driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		        Thread.sleep(3000);

		        // Logout
		        WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		        Actions act = new Actions(driver);
		        act.moveToElement(profilePic).build().perform();

		        Thread.sleep(2000);
		        driver.findElement(By.linkText("Sign Out")).click();

		        Thread.sleep(3000);
		        driver.quit();
		    }
		}

