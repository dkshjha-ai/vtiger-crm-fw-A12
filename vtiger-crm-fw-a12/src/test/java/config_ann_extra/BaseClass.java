package config_ann_extra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	@BeforeClass
	public void openBro() {
		System.out.println("Browser Open");
		}
	
	@BeforeMethod
	public void login() {
		System.out.println("LogIn");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("LogOut");
		}
	
	@AfterClass
	public void closeBro() {
		System.out.println("Browser Close");
		
	}

}
