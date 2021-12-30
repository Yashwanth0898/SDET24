package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.WebDriverUtility;
/**
 * this is pom class for Homepage. this class contains methods for webelements present in homepage 

 * @author lokesh
 *
 */
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationButton;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsButton;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOut;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIcon;


	public void getSignOut() {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.mouseOver(driver, signOutIcon);
	
		signOut.click();
	}


	public WebElement getSignOutIcon() {
		return signOutIcon;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getContactsButton() {
		return contactsButton;
	}


	public WebElement getOrganizationButton() {
		return organizationButton;
	}
}
	
	
