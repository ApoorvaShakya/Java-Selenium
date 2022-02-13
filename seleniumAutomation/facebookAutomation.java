package seleniumAutomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class facebookAutomation 
{
	public WebDriver driver;//null
	String name = "Ram"; //null

	public facebookAutomation()
	{
	  System.out.println("My name :" + name);
	  System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe"); 
	  driver = new ChromeDriver(); // a new empty chrome browser will be opened
	}	
	String expected = "Facebook – log in or sign up";
	@Before
	public void launchApplication()
	{
		System.out.println("Test Case : Launch Application");
		driver.get("https://www.facebook.com/");
		Assert.assertEquals(expected, driver.getTitle());
	}
	@Test
	public void FacebookLogin()
	{
		driver.findElement(By.id("email")).sendKeys("Apoorva");
		driver.findElement(By.id("pass")).sendKeys("***********");
		//driver.findElement(By.className("inputtext _55r1 _6luy _9npi")).click();
		driver.findElement(By.xpath("//button[@name='login']")).click();
		//System.out.println("Test Case: Language For Facebook");
		//driver.findElement(By.tagName("Hindi")).click();
		//driver.findElement(By.className("_sv4"));
	}

}
