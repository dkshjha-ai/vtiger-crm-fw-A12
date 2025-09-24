package organiztion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationTest {

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
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//Filling data to the form
		WebElement orgField= driver.findElement(By.name("accountname"));
		String orgName= "automationwithDJ04";
		orgField.sendKeys(orgName);
		
		Thread.sleep(1000);
		WebElement websiteField= driver.findElement(By.name("website"));
		String WebS= "https://abccompany.com";
		websiteField.sendKeys(WebS);
		
		Thread.sleep(1000);
		WebElement phoneField = driver.findElement(By.id("phone"));
		String phone= "8766564533";
		phoneField.sendKeys(phone);
		
		Thread.sleep(1000);
		WebElement empField= driver.findElement(By.id("employees"));
		String emp = "50";
		empField.sendKeys(emp);
		
		Thread.sleep(1000);
		WebElement emailField = driver.findElement(By.id("email1"));
		String email= "dj@gmail.com";
		emailField.sendKeys(email);
		
		Thread.sleep(1000);
		WebElement industryDD= driver.findElement(By.name("industry"));
		Select sel = new Select(industryDD);
		sel.selectByVisibleText("Education");
		
		Thread.sleep(1000);
		WebElement ratingDD= driver.findElement(By.name("rating"));
		Select sel2 = new Select(ratingDD);
		sel2.selectByValue("Active");
		
		Thread.sleep(1000);
		WebElement typeDD = driver.findElement(By.name("accounttype"));
		Select sel3 = new Select(typeDD);
		sel3.selectByValue("Customer");
		
		Thread.sleep(1000);
		WebElement arField = driver.findElement(By.name("annual_revenue"));
		String ar="3000000";
		arField.sendKeys(ar);
		
		Thread.sleep(3000);
		
		//Save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		//Verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if(actOrgName.equals(orgName)) {
			System.out.println("Created Organization successfully");
		}
		
		else {
			System.out.println("Failed....");
			
		}
		
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
