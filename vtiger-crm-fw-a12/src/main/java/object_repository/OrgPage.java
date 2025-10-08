package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="img[alt='Create Organization...']")
	private WebElement orgPlusIcon;
	
	
	@FindBy(name="accountname")
	private WebElement orgField;
	
	@FindBy(name="website")
	private WebElement website;
	
	@FindBy(id ="phone")
	private WebElement phone;
	
	@FindBy(id="employees")
	private WebElement emp;
	
	@FindBy(id="email1")
	private WebElement email;

	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="rating")
	private WebElement rating;
	
	@FindBy(name="accounttype")
	private WebElement acctype;
	
	@FindBy(name ="annual_revenue")
	private WebElement annualrev;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgPlusIcon() {
		return orgPlusIcon;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmp() {
		return emp;
	}
	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getAcctype() {
		return acctype;
	}

	public WebElement getAnnualrev() {
		return annualrev;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement orgPlusIcon() {
		return orgPlusIcon;
	}

	public WebElement getOrgField() {
		return orgField;
	}

}
