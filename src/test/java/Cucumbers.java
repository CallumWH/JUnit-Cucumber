import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class Cucumbers
{
	public WebDriver driver = null;
	public static ExtentReports report;
	public static ExtentTest test;
	static int runs = 0;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		if(runs < 1)
		{
			report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Selenium Reports\\TeaWebsiteTest.html", true);
		}
		runs++;
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable
	{
		driver.get("http://www.practiceselenium.com/welcome.html");
		test = report.startTest("Accessing website landing page");
		test.log(LogStatus.INFO, "Opening website");
		
		if(driver.getCurrentUrl().equals("http://www.practiceselenium.com/welcome.html"))
		{
			test.log(LogStatus.PASS, "Correct domain loaded");
		}
		else
		{
			test.log(LogStatus.FAIL, "Incorrect Domain Loaded");
		}
		report.endTest(test);
		
		assertEquals("http://www.practiceselenium.com/welcome.html", driver.getCurrentUrl());
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable
	{
		Navigator n = PageFactory.initElements(driver, Navigator.class);
		
		test = report.startTest("Navigating to Menu");
		test.log(LogStatus.INFO, "Clicking Menu");
		
		if(n.NavigateToMenu(driver).equals("http://www.practiceselenium.com/menu.html"))
		{
			test.log(LogStatus.PASS, "Correct domain loaded");
		}
		else
		{
			test.log(LogStatus.FAIL, "Incorrect Domain Loaded");
		}
		report.endTest(test);
		
		assertEquals("http://www.practiceselenium.com/menu.html", n.NavigateToMenu(driver));
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable
	{
		Finder f = PageFactory.initElements(driver, Finder.class);
		assertEquals(true, f.FindMenuItems());
		report.flush();
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
		
	}

}
