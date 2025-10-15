package contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import generic_utility.WebDriverUtility;

public class CreateContactTestBeforeBaseClass {
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		//Get The Data From The Property File
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
			
		//Get Data From Excel File
			
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
			
		Workbook wb = WorkbookFactory.create(fisExcel);
			
		Sheet sh = wb.getSheet("contact");
			
		Row row = sh.getRow(9);
			
		Cell cell = row.getCell(0);
			
		String lastName = cell.getStringCellValue();
			
		wb.close();
		
		//open browswer
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//login
		driver.get(URL);
		
		//enter username
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);
		
		//enter password
		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys(PASSWORD);
		
		//click login 
		driver.findElement(By.id("submitButton")).click();
		
		// After login and navigating to Contact module:
		driver.findElement(By.linkText("Contacts")).click();
		
		// Wait for page to load
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Filling data to the form
		WebElement salutationDD= driver.findElement(By.name("salutationtype"));
		Select sel = new Select(salutationDD);
		sel.selectByValue("Ms.");
		
		//first name
		WebElement ele = driver.findElement(By.name("firstname"));
		String fname = "Diksha";
		ele.sendKeys(fname);
		
		//last name
		WebElement LastName = driver.findElement(By.name("lastname"));
		//String lname= "Jha";
		LastName.sendKeys(lastName);
		
		//organization name 
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// Store parent window ID
		String parentWindow = driver.getWindowHandle();

		// Switch to the child popup window
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window);
		        break;
		    }
		}

		// Wait for organization list to load
		Thread.sleep(2000);

		// Select the organization (make sure it exists)
		driver.findElement(By.linkText("yahoo_1785")).click();

		// Switch back to the parent window
		driver.switchTo().window(parentWindow);
		
		//office phone
		Thread.sleep(1000);
		WebElement phone = driver.findElement(By.id("phone"));
		String offPhn = "9976564433";
		phone.sendKeys(offPhn);
		
		//title
		WebElement title = driver.findElement(By.id("title"));
		String tl = "Manager";
		title.sendKeys(tl);
		
		//email
		WebElement Email = driver.findElement(By.id("email"));
		String eMl = "dj@gmail.com";
		Email.sendKeys(eMl);
		
		//birthday
		WebElement bday = driver.findElement(By.name("birthday"));
		String BirthDay = "2000/12/15";
		bday.sendKeys(BirthDay);
		
		
		//save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		Thread.sleep(1000);
		
		WebElement profilePic= driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		
		//Actions act = new Actions(driver);
		//act.moveToElement(profilePic).build().perform();
		
		wdUtil.hover(profilePic);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
