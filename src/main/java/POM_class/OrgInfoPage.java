package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	WebDriver driver;
	public OrgInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgVerifyText;
	
	@FindBy(xpath = "//span[@id='dtlview_Industry']/font")
	private WebElement IndustryDropDownText;
	
	@FindBy(xpath = "//span[@id='dtlview_Type']/font")
	private WebElement TypeDropDownText;
	

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getIndustryDropDownText() {
		return IndustryDropDownText;
	}


	public WebElement getTypeDropDownText() {
		return TypeDropDownText;
	}


	public WebElement getOrgVerifyText() {
		return orgVerifyText;
	}
	

}
