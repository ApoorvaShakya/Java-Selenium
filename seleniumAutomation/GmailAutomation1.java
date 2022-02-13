package seleniumAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class GmailAutomation1 
{
	String expectedtitle="Gmail";
	public WebDriver driver;
	public GmailAutomation1()
    {
		System.setProperty("webdriver.chrome.driver", "D:\\softwares\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	 }
	@Test
	public void launchApplication() throws InterruptedException
	{
		System.out.println("Test Case : Launch Application");
		driver.get("https://gmail.com");  
		String actualTitle = driver.getTitle();
		System.out.println("My title :" + actualTitle);
		System.out.println("My url :" + driver.getCurrentUrl());
		System.out.println("My session ID :" + driver.getWindowHandle());
		if(expectedtitle.equals(actualTitle)) 
		{
			System.out.println("Title Validation Passed");
		}
		else
		{
			System.out.println("Title Validation Failed");
		}
		Assert.assertEquals(expectedtitle, actualTitle);
		
	}
	@Test
	public void loginToApplication() throws InterruptedException
	{
		launchApplication();
		System.out.println("Test Case : Login To Application");
		//driver.findElement(By.name("identifier")).sendKeys("apoorvashakya.eta@gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("apoorvashakya.eta@gmail.com");
		driver.findElement(By.className("VfPpkd-vQzf8d")).click();
	}
	@Test
	public void forgotEmail() throws InterruptedException
	{
		launchApplication();
		driver.findElement(By.tagName("button")).click();
		//button[@jsname='Cuz2Ue']
		//button[text()='Forgot email?']
		//*[text()='Forgot email?']
		//button[contains(text(),'Forgot ')]
		//driver.findElement(By.xpath("//button[text()='Forgot email?']")).click();
	}
	@Test
	public void help() throws InterruptedException
	{
		launchApplication();
		driver.findElement(By.linkText("Help")).click();
	}
	@Test
	public void privacy() throws InterruptedException
	{
		launchApplication();
		driver.findElement(By.linkText("Privacy")).click();
	}
	@Test
	public void terms() throws InterruptedException
	{
		launchApplication();
		driver.findElement(By.linkText("Terms")).click();
	}
	@Test
	public void createAccount() throws InterruptedException
	{
		launchApplication();
		//
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span")).click();
		//driver.findElement(By.xpath("//span[text()='Create account']")).click();
		//driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
		driver.findElement(By.xpath("//[contains(text(),'Create')  and @jsname='V67aGc']")).click();
		/*
		 * List<WebElement> elements =
		 * driver.findElements(By.className("VfPpkd-vQzf8d"));
		 * System.out.println("Length of collection :" + elements.size()); for(int
		 * i=0;i<elements.size();i++) { WebElement element = elements.get(i); String
		 * text = element.getText(); if(text.equals("Create account")) {
		 * System.out.println("My tagname :" + element.getTagName());
		 * System.out.println("My jsname :" + element.getAttribute("jsname"));
		 * element.click(); break; } }
		 */
	}
	public void learnMore() throws InterruptedException
	{
		launchApplication();
		driver.findElement(By.tagName("a")).click();
		//driver.findElement(By.linkText("Learn more")).click();
		//driver.findElement(By.partialLinkText("Learn")).click();
		//driver.findElement(By.xpath("//a[@jsname='JFyozc']")).click();
		/*
		 * List<WebElement> elements = driver.findElements(By.tagName("a"));
		 * System.out.println("Length of collection :" + elements.size()); 
		 * for(int i=0;i<elements.size();i++) 
		 *       { WebElement element = elements.get(i); String
		 * 		   text = element.getText(); 
		 *         if(text.equals("Learn more")) 
		 *         {
		 *          element.click();
		 *          break;
		 *          }
		 *       }
		 */
	}
	
	@Test
	public void loginApplication() throws InterruptedException
	{
		launchApplication();
		System.out.println("Test Case : Login To Application");
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
}
