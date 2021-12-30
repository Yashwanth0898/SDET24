package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *this is pom class for CommonElementsPage. this class contains methods for webelements present in CommonElementsPage

 * @author lokesh
 *
 */
public class CommonElementsPage {
	
  public CommonElementsPage(WebDriver driver) {
	  
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

}
