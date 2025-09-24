package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarTest {

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
		
		//click on AddButton
		driver.findElement(By.className("calAddButton")).click();
		
		//click on call
		driver.findElement(By.id("addcall")).click();
		
		//Filling the calendar
		WebElement eventnameField = driver.findElement(By.name("subject"));
		eventnameField.sendKeys("Follow-up call with ABC Corp");
		
		Thread.sleep(1000);
		
		WebElement locField = driver.findElement(By.name("location"));
		locField.sendKeys("Bengaluru");
		
		WebElement statusDD = driver.findElement(By.id("eventstatus"));
		Select sel = new Select(statusDD);
		sel.selectByValue("Held");
		
		Thread.sleep(1000);
		WebElement startshrDD = driver.findElement(By.id("starthr"));
		Select sel2 = new Select(startshrDD);
		sel2.selectByValue("04");
		
		Thread.sleep(1000);
		WebElement startsminDD = driver.findElement(By.id("startmin"));
		Select sel3 = new Select(startsminDD);
		sel3.selectByValue("00");
		
		Thread.sleep(1000);
		WebElement stDD = driver.findElement(By.id("startfmt"));
		Select sel4 = new Select(stDD);
		sel4.selectByValue("pm");
		
		Thread.sleep(1000);
		WebElement endshrDD = driver.findElement(By.id("endhr"));
		Select sel5 = new Select(endshrDD);
		sel5.selectByValue("05");
		
		Thread.sleep(1000);
		WebElement endsminDD = driver.findElement(By.id("endmin"));
		Select sel6 = new Select(endsminDD);
		sel6.selectByValue("00");
		
		Thread.sleep(1000);
		WebElement endDD = driver.findElement(By.id("endfmt"));
		Select sel7 = new Select(endDD);
		sel7.selectByValue("pm");

		Thread.sleep(1000);
		WebElement cal = driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Calendar.gif']"));
		cal.click();
		
		Thread.sleep(1000);
		WebElement day = driver.findElement(By.xpath("//td[contains(@class, 'day') and text()='25']"));
		day.click();
		
		//save
		driver.findElement(By.name("eventsave")).click();
		
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