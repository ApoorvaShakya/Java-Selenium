package seleniumAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class gmailAutomation
{   //In Selenium we have a interface called Webdriver
	//Webdriver interface is implemented by different classes like Chrome,Firefox..... 
	//Web driver contains different functions to do a different operations on a web application.
	//WebDriver: get() to call any url on a open browser
	//The constructor of each class who implemented webdriver will open the respective browser automatically.
	//IllegalStateException: The path to the driver executable The path to the driver executable must be set by the webdriver.chrome.driver system property
	//driver version should be compatible with the version of chrome in your system else You'll get session not found exception.
	//WebDriver : get(),getTitle(),getUrl(),getWindowHandle,getWindowHandles,refresh,close,quit
	//findElement , findElements , switch  .......
	//Selenium WebDriver will use the HTML document [DOM] of the web page for its object identification.
	//How to open the HTML Doc : Open Developer tool in your browser [ F12 , or RightClick->Inspect -> Elements tab will have the Html page]
	//HTML Doc[DOM] will contain the attributes of each element present in the current web page we opened.
	//Test Case : Gmail Application Title validation
	//By : ID , Name , Class , Css , linkText , partialLinkText , tagName , xpath
	//NosuchElement exception: when u search an element in an empty browser
	//NullPointerException:if we create a variable and didn't assign any value to it and we're trying to use it
	//WebElement : click , clear , sendKeys , isDisplayed , isEnabled , getText , getAttribute , findElement , findElements
	
	String expectedtitle="Gmail"; //Test Data
	
	//Execution: All instance variables will be loaded->Default Constructor->Test Methods
	@Test
	public void launchApplication() throws InterruptedException
	{
		System.out.println("Test Case : Launch Application");
		System.setProperty("webdriver.chrome.driver", "D:\\softwares\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://gmail.com"); //We have to call URL of AUT 
		String actualTitle = driver.getTitle();
		System.out.println("My title :" + actualTitle);
		System.out.println("My url :" + driver.getCurrentUrl());
		System.out.println("My session ID :" + driver.getWindowHandle());
		if(expectedtitle.equals(actualTitle)) //Custom validation
		{
			System.out.println("Title Validation Passed"); //We will report it in a html file
		}
		else
		{
			System.out.println("Title Validation Failed");
		}
		Assert.assertEquals(expectedtitle, actualTitle);
		WebElement emailObj = driver.findElement(By.name("identifier"));
		if(emailObj.isDisplayed() && emailObj.isEnabled())
		{
			emailObj.click();
			emailObj.sendKeys("gfggfdgfg");
			Thread.sleep(2000);
			emailObj.clear();
			Thread.sleep(2000);
			emailObj.sendKeys("apoorvashakya.eta@gmail.com");
		}
		else
		{
			System.out.println("Email or phone number object is not displayed / not enabled");
		}

		driver.findElement(By.name("identifier")).sendKeys("22");

	}
	@Test
	public void loginToApplication()
	{
		System.out.println("Test Case : Login To Application");
	}
	}
