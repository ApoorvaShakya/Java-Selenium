package pageObjects;

import org.openqa.selenium.WebDriver;

import appUtilities.ApplicationUtilities;
import gUtilities.GeneralUtility;
import gUtilities.ReadProperties;
import testBatches.TestBatches;

public class Home
{
	WebDriver driver;
	ReadProperties data;
	ApplicationUtilities appUtils;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		data= new ReadProperties("TestData/" +TestBatches.env+ "Data.properties");
		appUtils = new ApplicationUtilities(driver);
	}
	public void navigateToHome()
	{
		System.out.println("RC: Navigate to home");
		appUtils.getElement("//a[@title='Home']").click();
	}
	public void bookTicket()   //call all the functions for booking a ticket
	{
		System.out.println("RC: Book Ticket");
		appUtils.getElement("//input[@name='source']").sendKeys(data.readData("FromCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		appUtils.getElement("//input[@name='destination']").sendKeys(data.readData("ToCity"));
		GeneralUtility.fixedWait(1);
		appUtils.clickEnter();
		appUtils.getElement("//input[@name='txtJourneyDate']").click();
		appUtils.getElement("//a[text()='"+data.readData("JDate")+"']").click();
		appUtils.getElement("//input[@name='searchBtn']").click();
		GeneralUtility.fixedWait(1);
		appUtils.getElement("//a[@title='Home']");
	}
	public void printTicket()
	{
		System.out.println("RC: Print TicketS");
	}
}















