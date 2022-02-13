package seleniumAutomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class ApsrtcAutomation
{
	public WebDriver driver;//null
	String name = "Ram"; //null

	public ApsrtcAutomation()
	{
		System.out.println("My name :" + name);
		System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver\\chromedriver.exe"); 
		driver = new ChromeDriver(); // a new empty chrome browser will be opened
	}	
	String expected = "APSRTC Official Website for Online Bus Ticket Booking - APSRTConline.in";
	@Before
	public void launchApplication()
	{
		System.out.println("Test Case : Launch Application");
		driver.get("https://www.apsrtconline.in/");
		Assert.assertEquals(expected, driver.getTitle());
	}
	@Test
	public void bookTicket() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='source']")).sendKeys("HYDERABAD");
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@name='destination']")).sendKeys("GUNTUR");
		Thread.sleep(1000);
		actions.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//input[@name='txtJourneyDate']")).click();
		//driver.findElement(By.xpath("//a[text()='29']")).click();
		selectDate("4");
		driver.findElement(By.xpath("//input[@name='searchBtn']")).click();
	}

	@Test
	public void allKeyBoardActions() throws InterruptedException
	{
		WebElement fromCity = driver.findElement(By.xpath("//input[@name='source']"));//.sendKeys("HYDERABAD");
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		//Move - Mouse hover
		actions.moveToElement(fromCity).click().sendKeys("HYDERABAD").doubleClick().contextClick().build().perform();
		//actions.sendKeys(Keys.ENTER).perform();
	}
	@Test
	public void multipleWindows()
	{
		driver.findElement(By.xpath("//a[@title='TimeTable / Track']")).click();
		driver.findElement(By.xpath("//a[text()='All services Time Table & Tracking']")).click();
	}
    @Test
	public void selectDate(String jDate)
	{
		driver.findElement(By.xpath("//a[text()='"+jDate+"']")).click();
	}
	@Test
	public void navigateOnEachTab() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Ticket Status']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Cancel Ticket']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Gallery']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Track Service']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Wallet']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Ticket Status']")).click();
	}
	public void navigateOnEachTabDynamic(String tabName) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='"+tabName+"']")).click();
	}
	@Test
	public void dynamicXpath() throws InterruptedException
	{
		navigateOnEachTabDynamic("Wallet");
	}

}