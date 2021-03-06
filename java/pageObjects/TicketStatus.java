package pageObjects;

import org.openqa.selenium.WebDriver;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class TicketStatus
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	public TicketStatus(WebDriver driver)
	{
		this.driver=driver;
		data= new ReadProperties("TestData/" +TestBatches.env+ "Data.properties");
		appUtils = new ApplicationUtilities(driver);
	}
	public void checkTicketStatus()
	{
		System.out.println("RC: Check Ticket Status");
		appUtils.getElement("//input[@name='id' and @class='searchTktCancel']").sendKeys(data.readData("TicketNumber"));
	}

	public void navigateToTicketStatus() 
	{
		
		System.out.println("RC: Navigate to Ticket status");
		appUtils.getElement("//a[@title='Ticket Status']").click();
	}
	
	
}
