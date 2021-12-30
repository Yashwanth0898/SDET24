package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.WebDriverUtility;
/**
 * this is pom class for CreateContactPage. this class contains methods for webelements present in CreateContactPage
 * @author lokesh
 *
 */
public class CreateContactPage {
	WebDriver driver;

	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getCreateContactbutton() {
		return createContactbutton;
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactbutton;

	@FindBy(name = "lastname")
	WebElement lastnameTextBox;

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	WebElement OrgLookUpButton;

	private Object getcreateContactbutton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastnameTextBox() {
		return lastnameTextBox;
	}

	public WebElement getOrgLookUpButton() {
		return OrgLookUpButton;
	}

	public void createContact(String lastName, String orgName) {
		HomePage hp = new HomePage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		WebDriverUtility wlib = new WebDriverUtility();
		OrgLookUpPage olp = new OrgLookUpPage(driver);
		CommonElementsPage cep = new CommonElementsPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);

		
		ccp.getLastnameTextBox().sendKeys(lastName);
		ccp.getOrgLookUpButton().click();
		wlib.getSwitchToWindow(driver, "Accounts&action");
		olp.getSearchBox().sendKeys(orgName);
		olp.getSearchButton().click();
		olp.getOrgName(orgName).click();
		wlib.getSwitchToWindow(driver, "Contacts&action");
		cep.getSaveButton().click();

		String contactVerifyText = cip.getContactVerifyText().getText();
		if (contactVerifyText.contains(lastName)) {
		System.out.println(lastName + " contact name was created");
		} else {
			System.out.println(lastName + " contact name was not created");
		}

	}

}
