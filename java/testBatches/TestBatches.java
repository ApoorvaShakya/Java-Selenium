package testBatches;

import org.junit.Test;

import gUtilities.ReadProperties;
import testScenarios.testCases;

public class TestBatches
{
	testCases TestCases;
	ReadProperties config;
	public static String env;
	public TestBatches()
	{
		config= new ReadProperties("TestData/Config.properties");
		env=config.readData("Environment");
		TestCases= new testCases();
	}
	
	@Test
	public void runUserChoice()
	{
		System.out.println("************* Execution Summary ****************");
		System.out.println("Testing Type" +config.readData("TestingType").toUpperCase());
		System.out.println("Environment / Server" +config.readData("Environment").toUpperCase());
		System.out.println("*************************************************");
		if(config.readData("TestingType").equalsIgnoreCase("SMOKE"))
		{
			smokeSuite();
		}
		else if(config.readData("TestingType").equalsIgnoreCase("REGRESSION"))
		{
			regressionSuite();
		}
		else
		{
			System.out.println("Testing type is not Supported: " +config.readData("TestingType"));
		}
	}
	
	@Test
	public void smokeSuite()
	{
		System.out.println("Test Suite: Smoke");
		TestCases.bookBusTicketAndCancel();
		TestCases.bookBusTicketAndPrint();
		TestCases.bookBusTicketAndTrackService();
	}
	@Test
	public void regressionSuite()
	{
		System.out.println("Test Suite: Regression");
		TestCases.bookBusTicketAndCancel();
		TestCases.bookBusTicketAndPrint();
		TestCases.bookBusTicketAndTrackService();
		TestCases.bookBusTicketPrintAndTrackServices();
		TestCases.bookBusTicketAndCheckStatus();
	}
}
