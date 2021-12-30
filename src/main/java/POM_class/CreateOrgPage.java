package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is pom class for CreateOrgPage. this class contains methods for webelements present in CreateOrgPage
 * @author lokesh
 *
 */
public class CreateOrgPage {
	WebDriver driver;
	public CreateOrgPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(name="accountname")
private WebElement OrgName;

@FindBy(name="industry")
private WebElement industrySelectBox;

@FindBy(name="accounttype")
private WebElement typeSelectBox;



public WebDriver getDriver() {
	return driver;
}

public WebElement getOrgName() {
	return OrgName;
}

public WebElement getIndustrySelectBox() {
	return industrySelectBox;
}

public WebElement getTypeSelectBox() {
	return typeSelectBox;
}
		
}
