package assessment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appUtilities.ApplicationUtilities;
import gUtilities.ReadProperties;
import org.junit.Assert;

public class Assessment 
{
	WebDriver driver;
	ApplicationUtilities appUtils;
	ReadProperties prop;
	public Assessment( WebDriver driver) { this.driver = driver;
	appUtils = new ApplicationUtilities(driver);
	prop = new ReadProperties("TestData/Data1.properties");
}
public void NavigationToHome()
{
	appUtils.getElement("//a[@class = 'nav-link' and @href = '#']").click();
}
public void assertInputAndLogin()
{
	WebElement email = appUtils.getElement("//input[@placeholder='Email address']");
	WebElement password = appUtils.getElement("//input[@placeholder='Password']");
	if(email.isEnabled() && password.isEnabled()) 
	{
		System.out.println("email and password inputs are available");
	}
	else 
	{
		System.out.println("not available");
	}
	email.sendKeys(prop.readData("Email"));
	password.sendKeys(prop.readData("Password"));
	appUtils.getElement("//button[text()='Sign in']").click();
}
public void list()
{
	int ExpectedListSize = 3;
	String ExpectedString = "List Item 2 6";
	List<WebElement> list = driver.findElements(By.xpath("//ul[@class='list-group']//li"));
	Assert.assertEquals(ExpectedListSize, list.size());
	System.out.println("list size is correct");
	String ActualString = appUtils.getElement("//ul[@class='list-group']//li[2]").getText();
	System.out.println(ActualString);
	Assert.assertEquals(ExpectedString,ActualString);
	System.out.println("Strings are equal");
}
}

