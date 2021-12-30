package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.FileUtility;
import commonutilities.WebDriverUtility;
/**
 * this is pom class for LoginPage. this class contains methods for webelements present in login page
 * @author lokesh
 *
 */
public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "user_name")
	private WebElement usernameTextBox;

	@FindBy(name = "user_password")
	private WebElement passwordTextBox;

	@FindBy(id = "submitButton")
	private WebElement loginButton;



	public WebElement getUsernameTextBox() {
		return usernameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * this method is used to login application without enter username and password
	 * @throws Throwable
	 */

	public void loginToAPP() throws Throwable {
		
		FileUtility flib= new FileUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		String url = flib.getDataFromPropertyFile("url");
		String username=flib.getDataFromPropertyFile("username");
		String password=flib.getDataFromPropertyFile("password");
		
		driver.get(url);
		wlib.maximizeBrowser(driver);
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}
	
	/**
	 * this mehod is used to login application by pass username and password as arguments
	 * @param Username
	 * @param Password
	 * @throws Throwable
	 */
public void loginToAPP(String Username, String Password) throws Throwable {
		
		FileUtility flib= new FileUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		String url = flib.getDataFromPropertyFile("url");
		String username=flib.getDataFromPropertyFile(Username);
		String password=flib.getDataFromPropertyFile(Password);
		
		driver.get(url);
		wlib.maximizeBrowser(driver);
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}


}
