package testScenarios;

import pageObjects.CancelTicket;
import pageObjects.Home;
import pageObjects.TicketStatus;
import pageObjects.TrackService;
import pageObjects.login;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCases
{
	WebDriver driver;
	login login;
	Home home;
	TicketStatus ticketStatus;
	TrackService trackService;
	CancelTicket cancelTicket;
	public testCases()
	{
		System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		login=new login(driver);
		home=new Home(driver);
		ticketStatus=new TicketStatus(driver);
		trackService= new TrackService(driver);
		cancelTicket= new CancelTicket(driver);
	}
	@Test
   public void bookBusTicketAndPrint()
   {
	   System.out.println("Test Case: bookBusTicketAndPrint");
	   login.launchApplication();
	   login.loginToApplication();
       home.navigateToHome();
       home.bookTicket();
       home.printTicket();
       login.logoutFromApplication();
       login.closeApplication();
   }
	@Test
   public void bookBusTicketAndCheckStatus()
   {
	   System.out.println("Test Case: BookBusTicketAndCheckStatus");
	   login.launchApplication();
	   login.loginToApplication();
       home.navigateToHome();
       home.bookTicket();
       ticketStatus.navigateToTicketStatus();
       ticketStatus.checkTicketStatus();
       login.logoutFromApplication();
       login.closeApplication();
   }
	@Test
   public void bookBusTicketAndTrackService()
   {
	   System.out.println("Test Case: bookBusTicketAndTrackService");
	   login.launchApplication();
	   login.loginToApplication();
       home.navigateToHome();
       home.bookTicket();
       trackService.navigateToTrackService();
       trackService.TrackTicketServiceStatus();
       login.logoutFromApplication();
       login.closeApplication();
   }
	@Test
   public void bookBusTicketAndCancel()
   {
	   System.out.println("Test Case: bookBusTicketAndCancel");
	   login.launchApplication();
	   login.loginToApplication();
       home.navigateToHome();
       home.bookTicket();
       cancelTicket.navigateToCancelTicket();
       cancelTicket.CancelTheTicket();
       login.logoutFromApplication();
       login.closeApplication();
   }
	@Test
   public void bookBusTicketPrintAndTrackServices()
	   {
		   System.out.println("Test Case: bookBusTicketPrintAndTrackServices");
		   login.launchApplication();
		   login.loginToApplication();
	       home.navigateToHome();
	       home.bookTicket();
	       home.printTicket();
	       trackService.navigateToTrackService();
	       trackService.TrackTicketServiceStatus();
	       login.logoutFromApplication();
	       login.closeApplication();
	   }
}
