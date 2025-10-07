package pom_extra;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/v1/");
		
		LoginPage lp = new LoginPage(driver);
		
		//login
		//Declaration with initialization
		
		WebElement un  = lp.getUn();
		WebElement pwd = lp.getPwd();
		WebElement login = lp.getLogin();
		
		driver.navigate().refresh();
		
		//utilization
		un.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		login.click();
		
		//verify
		HomePage hp = new HomePage(driver);
		
		//Declaration & Initialization
		WebElement logo = hp.getLogo();
		
		//utilization
		if(logo.isDisplayed()) {
			System.out.println("Logged in successfully!!");
		} else {
			System.out.println("Could not log in..");
		}
		
		Thread.sleep(2000);
		
		CartPage cart = new CartPage(driver);
		//Add To Cart
		WebElement ct = cart.getCart();
		ct.click();
		
		//click on cart
		CheckOutOne cko= new CheckOutOne(driver);
		WebElement CO = cko.getShoppingCart();
		CO.click();
		
		Thread.sleep(2000);
		WebElement ck = cko.getCheckOut();
		ck.click();
		
		//Fill Details
		CheckOutTwo ckt = new CheckOutTwo(driver);
		
		//Declaration with initialization
		WebElement fn = ckt.getFn();
		WebElement ln = ckt.getLn();
		WebElement pc = ckt.getPc();
		WebElement btn = ckt.getBtn();
		
		//utilization
		fn.sendKeys("Diksha");
		ln.sendKeys("Jha");
		pc.sendKeys("110043");
		
		Thread.sleep(1000);
		btn.click();
		
		ConfirmationPage cnf = new ConfirmationPage(driver);
		WebElement fin = cnf.getFinish();
		
		fin.click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
