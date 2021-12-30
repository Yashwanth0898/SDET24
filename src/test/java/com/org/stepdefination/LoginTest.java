package com.org.stepdefination;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest {
	WebDriver driver;
	@Given("I will launch browser")
	public void i_will_launch_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("Enter the url")
	public void enter_the_url() {
	   driver.get("http://localhost:8888/");
	}

	@When("Login page is displayed enter the username and password")
	public void login_page_is_displayed_enter_the_username_and_password() {
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("manager");
	}

	@When("click on login")
	public void click_on_login() {
	   driver.findElement(By.id("submitButton")).click();
	}

	@Then("verify the home page and close the browser")
	public void verify_the_home_page_and_close_the_browser() {
	    String title=driver.getTitle();
	    Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM",
	    		"Home page title is not matching");
	}
	@Given("I will launch chrome browser")
	public void i_will_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	}

	@Given("Enter the url {string}")
	public void enter_the_url(String url) {
	    driver.get(url);
	}

	@Given("Login page is displayed enter the username {string} and password {string}")
	public void login_page_is_displayed_enter_the_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	}

	@When("Home page is displayed click on organization")
	public void home_page_is_displayed_click_on_organization() {
	    driver.findElement(By.linkText("Organizations")).click();
	}

	@When("click on create new organization")
	public void click_on_create_new_organization() {
	  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}

	@When("enter the organization name {string} and click on save button")
	public void enter_the_organization_name_and_click_on_save_button(String Organization) {
		Random ran=new Random();
		int random = ran.nextInt(200);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Organization+random);
	   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	}

	@When("verify organization {string} created or not")
	public void verify_organization_created_or_not(String Organization) throws Throwable {
	   Thread.sleep(2000);
	   String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   Assert.assertTrue(actOrgName.contains(Organization));
	   driver.close();
	}
	String orgName;
	String phone;
	String website;
	String emp;
	@When("Enter the organization name ,phone ,website and employees")
	public void enter_the_organization_name_phone_website_and_employees(io.cucumber.datatable.DataTable dataTable) {
	   List<Map<String, Object>> data = dataTable.asMaps(String.class,Object.class);
	    orgName = (String)data.get(0).get("organization name");
	    phone = (String)data.get(0).get("phone");
	    website = (String)data.get(0).get("website");
	    emp = (String)data.get(0).get("employees");
	    driver.findElement(By.name("accountname")).sendKeys(orgName);
	    driver.findElement(By.id("phone")).sendKeys(phone);
	    driver.findElement(By.name("website")).sendKeys(website);
	    driver.findElement(By.id("employees")).sendKeys(emp);
	    
	   
	   
	}
	@When("click on save Button")
	public void click_on_save_button() throws Throwable {
		 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 Thread.sleep(2000);
	}
	@Then("verify the organization Name,phone,website and employees")
	public void verify_the_organization_name_phone_website_and_employees() {
		 String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 Assert.assertTrue(actOrgName.contains(orgName));
		 String web = driver.findElement(By.xpath("//span[@id='dtlview_Website']")).getText();
		 String employees = driver.findElement(By.xpath("//span[@id='dtlview_Employees']")).getText();
		 String number = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		 SoftAssert softassert=new SoftAssert();
		 softassert.assertTrue(this.website.contains(web));
		 softassert.assertTrue(this.phone.contains(number));
		 softassert.assertTrue(this.emp.contains(employees));
		 driver.close();
		 
	}
}
