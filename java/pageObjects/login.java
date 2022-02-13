package pageObjects;

import org.openqa.selenium.WebDriver;

import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class login
{
	WebDriver driver;
	ReadProperties data;
	public login(WebDriver driver)
	{
		this.driver=driver;
		data= new ReadProperties("TestData/" +TestBatches.env+ "Data.properties");
	}
	public void launchApplication()
	{
		System.out.println("RC: Launch Application");
		driver.get(data.readData("URL"));
	}
	public void loginToApplication()
	{
		System.out.println("RC: Login To Application");
	}
	public void closeApplication()
	{
		System.out.println("RC: close Application");
	}
	public void logoutFromApplication()
	{
		System.out.println("RC: Logout from  Application");
	}
}
