package POM_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpPage {
	
	WebDriver driver;
	String orgName;
private final static String xpath =null;
	
	public OrgLookUpPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="search_txt")
	private WebElement searchBox;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	@FindBy(xpath = "xpath")
	private WebElement OrgName;

	public WebDriver getDriver() {
		return driver;
	}

	public String getOrgName() {
		return orgName;
	}

	public static String getXpath() {
		return xpath;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
/**
 * this method is used to click on specific Organization name 
 * pass organization name as argument
 * @param orgName
 * @return
 */
	public WebElement getOrgName(String orgName) {
		
		return driver.findElement(By.xpath("//a[.='"+orgName+"']"));
	}
	


}
