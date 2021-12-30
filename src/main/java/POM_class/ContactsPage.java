package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *this is pom class for ContactPage. this class contains methods for webelements present in ContactPage

 * @author lokes
 *
 */
public class ContactsPage {

	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	WebElement createContactButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateContactButton() {
		return createContactButton;
	}
	
	
	
	
}
