package organiztion;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileUtility fUtil = new FileUtility();
		
		//Get Data From Property File
		String Browser = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
		//Get Data From Excel File
		String orgName = fUtil.getStringDataFromExcelFile("org", 6, 0);
		
		//FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		
		//Workbook wb = WorkbookFactory.create(fisExcel);
		
		//Sheet sh = wb.getSheet("org");
		
		//Row row = sh.getRow(6);
		
		//Cell cell = row.getCell(0);
		
		//String orgName = cell.getStringCellValue() + (int)(Math.random()*10000);
		
		//open browswer
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Login
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		
		//Enter UserName
		//WebElement un= driver.findElement(By.name("user_name"));
		//un.sendKeys("admin");
		
		//Enter Password
		//WebElement pwd = driver.findElement(By.name("user_password"));
		//pwd.sendKeys("manager");
		
		//Click LogIn
		//driver.findElement(By.id("submitButton")).click();
		
		lp.login();
		
		
		//Create organization
		//driver.findElement(By.linkText("Organizations")).click();
		
		HomePage hp = new HomePage(driver);
		hp.getorgLink().click();
		
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//Filling data to the form
		
		OrgPage op = new OrgPage(driver);
		
		op.getOrgPlusIcon().click();
		
		//WebElement orgField= driver.findElement(By.name("accountname"));
		//String orgName= "automationwithDJ04";
		
		WebElement orgField= op.getOrgField();
		orgField.sendKeys(orgName);
		
		Thread.sleep(1000);
		//WebElement websiteField= driver.findElement(By.name("website"));
		String WebS= "https://abcdecompany.com";
		
		WebElement websiteField= op.getWebsite();
		websiteField.sendKeys(WebS);
		
		Thread.sleep(1000);
		//WebElement phoneField = driver.findElement(By.id("phone"));
		String phone= "8766564533";
		
		WebElement phoneField = op.getPhone();
		phoneField.sendKeys(phone);
		
		Thread.sleep(1000);
		//WebElement empField= driver.findElement(By.id("employees"));
		String emp = "50";
		
		WebElement empField= op.getEmp();
		empField.sendKeys(emp);
		
		Thread.sleep(1000);
		//WebElement emailField = driver.findElement(By.id("email1"));
		String email= "dj@gmail.com";
		
		WebElement emailField = op.getEmail();
		emailField.sendKeys(email);
		
		Thread.sleep(1000);
		
		WebElement industryDD= op.getIndustry();
		//WebElement industryDD= driver.findElement(By.name("industry"));
		Select sel = new Select(industryDD);
		sel.selectByVisibleText("Education");
		
		Thread.sleep(1000);
		WebElement ratingDD = op.getRating();
		//WebElement ratingDD= driver.findElement(By.name("rating"));
		Select sel2 = new Select(ratingDD);
		sel2.selectByValue("Active");
		
		Thread.sleep(1000);
		WebElement typeDD = op.getAcctype();
		//WebElement typeDD = driver.findElement(By.name("accounttype"));
		Select sel3 = new Select(typeDD);
		sel3.selectByValue("Customer");
		
		Thread.sleep(1000);
		WebElement arField= op.getAnnualrev();
		
		//WebElement arField = driver.findElement(By.name("annual_revenue"));
		String ar="3000000";
		arField.sendKeys(ar);
		
		Thread.sleep(3000);
		
		//Save
		op.getSaveBtn().click();
		//driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		//Verification
		//String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actOrgName = vop.getActOrgName().getText();
		
		if(actOrgName.equals(orgName)) {
			System.out.println("Created Organization successfully");
		}
		
		else {
			System.out.println("Failed....");
			
		}
		
		Thread.sleep(1000);
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		WebElement profilePic= hp.getprofilepic();
		profilePic.click();
		//WebElement profilePic= driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		//Actions act = new Actions(driver);
		//act.moveToElement(profilePic).build().perform();
		
		wdUtil.hover(profilePic);
		Thread.sleep(2000);
		
		hp.getsignOutLink().click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
