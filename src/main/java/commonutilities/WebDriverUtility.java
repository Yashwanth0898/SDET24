package commonutilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author lokesh
 *
 */
public class WebDriverUtility {

	/**
	 * @description implicitilywait is example for methodoverding(it can be seconds,day..etc)
	 * 
	 * @param driver
	 * @param TimeDuration in seconds
	 * @return
	 */
	public Timeouts ImplicitilyWait(WebDriver driver, int TimeDuration ) {
		Timeouts wait = driver.manage().timeouts().implicitlyWait(TimeDuration, TimeUnit.SECONDS);
		return wait;
	
	}

	/**
	 * this method is used to synchronize program upto element enabled in webpage
	 * @param driver
	 * @param Timeduration
	 * @param element
	 * @return
	 */
	public WebElement ExplicitlyWait(WebDriver driver, int Timeduration, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Timeduration);
		WebElement ewait = wait.until(ExpectedConditions.visibilityOf(element));
		return ewait;

	}
	/**
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param driver
	 * @param ExpectedTitleOfPage
	 */

	public void getSwitchToWindow(WebDriver driver, String ExpectedTitleOfPage) {
		Set<String> allID = driver.getWindowHandles();
		Iterator<String> itr = allID.iterator();
		while (itr.hasNext()) {
			String id = itr.next();
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if (title.contains(ExpectedTitleOfPage)) {
				break;
			}

		}

	}

	/**
	 * Actions is example for methodOverloading
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();	
	}
	
	/**
	 * its used to select dropdown option by using  optionsText
	 * its only applicable for the html tag should be <select>
	 * @param dropDownboxElement
	 * @param visibleText
	 */
	public void selectByVisibleText(WebElement dropDownboxElement, String visibleText) {
		Select s = new Select(dropDownboxElement);
		 s.selectByVisibleText(visibleText);			
	}
	/**
	 * its used to switch to specific frame
	 * @param driver
	 * @param frameElement
	 */
	public void getSwitchToFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * its used to take a screenshot
	 * @param driver
	 * @param destinationPath
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des= new File("./screenshot/"+screenshotName+".png");
		FileUtils.copyFile(src, des);
			
	}
	/**
	 * this method will used to scrolldown a scrollbar upto element
	 * @param driver
	 * @param element 
	 */
	public void scrollDown(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int elementPixcel=element.getLocation().getY();
		js.executeScript("window.scrollTo(0,"+elementPixcel+")");
		
	}
	/**
	 * this method will print current pc date
	 * @return
	 */
	public String getSystemdate() {
	Date  date = new Date();
	String sysDate = date.toString();
	return sysDate;
		
	}
	/**
	 * this method will click on perticular element through javascriptExecutor so thar you have to pass WebDriver object and webelement	
	 * @param driver
	 * @param element
	 */
	public void clickThroughJavascript(WebDriver driver,WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	

}
