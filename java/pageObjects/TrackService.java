package pageObjects;

import org.openqa.selenium.WebDriver;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class TrackService 
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	public TrackService(WebDriver driver)
	{
		this.driver=driver;
		data= new ReadProperties("TestData/" +TestBatches.env+ "Data.properties");
		appUtils = new ApplicationUtilities(driver);
	}
	public void TrackTicketServiceStatus()
	{
		System.out.println("RC: Track Ticket Service Status");
		appUtils.getElement("//input[@name='serviceCode']").sendKeys(data.readData("ServiceNumber"));
	}

	public void navigateToTrackService() 
	{
		
		System.out.println("RC: Navigate to Track Service");
		appUtils.getElement("//a[@title='Track Service']").click();
	}
}
