package assessment;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass 
{
	WebDriver driver;
	Assessment ass;
	public TestClass()
	{
		System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver\\chromedriver.exe"); 
		driver = new ChromeDriver();
		ass = new Assessment(driver);
		driver.get("file:///D:/eclipse/new1.html");
	}
	@Test
	public void Tests()
	{
		ass.NavigationToHome();
		ass.assertInputAndLogin();
		ass.list();
	}
}

