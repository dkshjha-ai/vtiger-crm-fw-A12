package organiztion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EditOrganizationTest {
	
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
		
		// After login and navigating to Organizations module:
		driver.findElement(By.linkText("Organizations")).click();

		// Wait for page to load (replace Thread.sleep with better waits if possible)
		Thread.sleep(2000);

		// Locate the organization to edit
		//driver.findElement(By.linkText("automationwithPiyush04")).click();

		//Thread.sleep(2000);
		
		//click on edit
		WebElement ele = driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=EditView&record=130&return_module=Accounts&return_action=index&parenttab=Marketing&return_viewname=4']"));
		ele.click();


		// Update the fields

		WebElement phoneField = driver.findElement(By.id("phone"));
		phoneField.clear();
		phoneField.sendKeys("99988877566");  // new phone number

		WebElement empField= driver.findElement(By.id("employees"));
		empField.clear();
		empField.sendKeys("105");  // new employee count

		WebElement industryDD= driver.findElement(By.name("industry"));
		Select sel = new Select(industryDD);
		sel.selectByVisibleText("Engineering");  // new industry

		WebElement arField = driver.findElement(By.name("annual_revenue"));
		arField.clear();
		arField.sendKeys("5000000");  // new annual revenue

		Thread.sleep(1000);

		// Save the changes
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		Thread.sleep(5000);

		// Verification
		String expectedPhone = "99988877566";
		String updatedPhone = driver.findElement(By.xpath("//td[span[@vtfieldname='phone']]")).getText();
		
		if (updatedPhone.equals(expectedPhone)) {
            System.out.println("Organization updated successfully.");
        } else {
            System.out.println("Update failed! Expected: " + expectedPhone + ", Found: " + updatedPhone);
        }
		
		Thread.sleep(3000);
		WebElement profilePic= driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
			
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
			
		Thread.sleep(3000);
		driver.quit();
			
		}

	}