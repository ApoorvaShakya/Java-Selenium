package seleniumAutomation;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class RedbusAutomation
{
	public WebDriver driver;//null
	String name = "Ram"; //null
	Actions actions;
	public RedbusAutomation()
	{
	  System.out.println("My name :" + name);
	  System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe"); 
	  driver = new ChromeDriver(); // a new empty chrome browser will be opened
	  actions = new Actions(driver);
	  driver.manage().window().maximize();
	}	
	String expected = "APSRTC Official Website for Online Bus Ticket Booking - APSRTConline.in";
	@Before
	public void launchApplication()
	{
		System.out.println("Test Case : Launch Application");
		driver.get("https://www.redbus.in/");
		//Assert.assertEquals(expected, driver.getTitle());
	}
	@Test
	public void loginToApplication()
	{
		driver.findElement(By.xpath("//i[@id='i-icon-profile']")).click();
		driver.findElement(By.xpath("//li[@id='signInLink']")).click();
		WebElement loginFrame = driver.findElement(By.xpath("//div[@class='modal']//iframe[@class='modalIframe']"));
		driver.switchTo().frame(loginFrame);
		driver.findElement(By.xpath("//input[@id='mobileNoInp']")).sendKeys("21323434");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//i[@class='icon-close']")).click();		
		driver.findElement(By.linkText("redRail")).click();
	}
	@Test
    public void bookTicket() throws InterruptedException
	{
        driver.findElement(By.xpath("//input[@id = 'src']")).sendKeys("BAREILLY");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//input[@id = 'dest'] ")).sendKeys("DELHI");
        action.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
        Thread.sleep(2000);       
        driver.findElement(By.xpath("//table//tr//td[text()='29']")).click();
        //driver.findElement(By.xpath("//button[@id = 'search_btn' and @class = 'we day']")).click();  

    }
	@Test    // read row num and column num as inputs - 4,2
	public void webTable() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
        Thread.sleep(2000);
        WebElement myCalander = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']"));
        List<WebElement> myRows = myCalander.findElements(By.tagName("tr"));
        int rowCount = myRows.size();
        System.out.println("My Row Count :" + rowCount);
        WebElement secondRow = myRows.get(1);
        List<WebElement> myColumns = secondRow.findElements(By.tagName("th"));
        System.out.println("My Column Count :" + myColumns.size());
        List<WebElement> row3 = myRows.get(2).findElements(By.tagName("td"));
        row3.get(0).getText();  // 3,0
        //get cell data row = 4  col = 2
        String val42 = myRows.get(4).findElements(By.tagName("td")).get(2).getText();
        System.out.println("Cell Data at 4,2 :" + val42);
	}

}
