package POM_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.WebDriverUtility;
/**
 * this class contains methods of webEelements present in organization page
 * @author lokesh
 *
 */
public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgButton;
	
	public WebElement getCreateOrgButton() {
		return createOrgButton;
	}

	/**
	 * this method is used to create organization with selecting industry and type so you should pass industry name and typeList name 
	 as argument that should be in the form of String
	 * @param orgName
	 * @param IndustryList
	 * @param TypeList
	 */
	public void createOrganization(String orgName,String IndustryList,String TypeList) {
		HomePage hp = new HomePage(driver);
		OrganizationsPage op= new OrganizationsPage(driver);
		CreateOrgPage cop= new CreateOrgPage(driver);
		CommonElementsPage cep=new CommonElementsPage(driver);
		OrgInfoPage oip= new OrgInfoPage(driver);
		WebDriverUtility wlib= new WebDriverUtility();
		
		
		cop.getOrgName().sendKeys(orgName);
		
		WebElement industryBox = cop.getIndustrySelectBox();
		wlib.selectByVisibleText(industryBox, IndustryList);

		WebElement typeBox = cop.getTypeSelectBox();
		wlib.selectByVisibleText(typeBox, TypeList);
		cep.getSaveButton().click();

		String IndustryText = oip.getIndustryDropDownText().getText();
		if(IndustryText.contains(IndustryList))
		{
			System.out.println(IndustryList +" was selected in Industry dropdown box");
		}else
		{
			System.out.println(IndustryList +" was not selected in Industry dropdown box");
		}
		
		String TypeText = oip.getTypeDropDownText().getText();
		
		if(TypeText.contains(TypeList))
		{
			System.out.println(TypeList +" was selected in Type dropdown box");
		}else
		{
			System.out.println(TypeList +" was not selected in Type dropdown box");
		}

		String verifyText = oip.getOrgVerifyText().getText();
		if (verifyText.contains(orgName)) {
			System.out.println(orgName + " organaization  was created");
		} else {
			System.out.println(orgName + " organaization  was created");
		}
	
	}
	/**
	 * this method is used to create organization so that pass organization name as an argument
	 * @param orgName means organization name
	 */
	public void createOrganization(String orgName) {
		
		CreateOrgPage cop= new CreateOrgPage(driver);
		CommonElementsPage cep=new CommonElementsPage(driver);
		OrgInfoPage oip= new OrgInfoPage(driver);
		WebDriverUtility wlib= new WebDriverUtility();
		
		cop.getOrgName().sendKeys(orgName);
		cep.getSaveButton().click();

		String verifyText = oip.getOrgVerifyText().getText();
		if (verifyText.contains(orgName)) {
			System.out.println(orgName + " organaization  was created");
		} else {
			System.out.println(orgName + " organaization  was created");
		}
	
	}
	
}
