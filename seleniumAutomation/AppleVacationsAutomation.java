package seleniumAutomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class AppleVacationsAutomation //extends ApplicationUtilities
{
	public WebDriver driver;//null
	String name = "Ram"; //null
	Actions actions;
	JavascriptExecutor js;
	ApplicationUtilities appUtils;
	public AppleVacationsAutomation()
	{
	  System.out.println("My name :" + name);
	  System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe"); 
	  driver = new ChromeDriver(); // a new empty chrome browser will be opened
	  appUtils = new ApplicationUtilities(driver);
	  actions = new Actions(driver);
	  js = (JavascriptExecutor)driver ; 
	  driver.manage().window().maximize();
	}
	String expected = "AppleVacations.com | Caribbean, Mexico and Hawaii Vacation Packages - All Inclusive Resorts";
	@Before
	public void launchApplication()
	{
		System.out.println("Test Case : Launch Application");
		driver.get("https://www.applevacations.com/#");
		System.out.println("Expected Title : " + expected);
		System.out.println("Actaul Title : " + driver.getTitle());
		Assert.assertEquals(expected, driver.getTitle());
	}
	@Test
	public void planMyVacation()
	{
		appUtils.getElement("//ng-bind[text()='More Options']","More Options").click();
		WebElement rooms = appUtils.getElement("//select[contains(@name,'numrooms')]");
		Select mySelect = new Select(rooms);
		//mySelect.selectByIndex(2);
		mySelect.selectByVisibleText("4");
		//actions.moveToElement(null)
		
		new Select(rooms).selectByIndex(2);
		
		/*if(driver.findElement(By.xpath("//ng-bind[text()='More Options']")).isEnabled())
		{
			System.out.println("More Options is Enabled");
			driver.findElement(By.xpath("//ng-bind[text()='More Options']")).click();
		}
		else
		{
			System.out.println("More Options is not Enabled");
		}*/
		
	}
	
	//Assignment :
	//Write a program to know how many hyperlinks are there in a web page.
	//What is StaleElement Exception , demonstrate how to get StaleElement exception.
	//Write code to demonstrate exceptions like NullPointer , Index Out of Bounds , NoSuchSessionException ,
	  //NoSuchElement , UnhandledAlertException , IllegalStateException , Typemismatch Error
	// Demonstrate the difference between close and quit methods with example code.
	

}
