package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class validationAssertion extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void browserStart() throws IOException
	{
		driver = initializeDriver();
		
		log.info("Browser is started");
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to Homepage");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		//here we calling initialize driver method which is defined in base file
		//for accessing that method we use extends keyword to access class and then method
		
		LandingPage lp = new LandingPage(driver);
		
		String titleName = lp.title().getText();
		
		Assert.assertEquals(titleName, "FEATURED COU123RSES");
		
		log.info("Navigated to Homepage");
		
		Assert.assertTrue(lp.getNavbar().isDisplayed());		
		
	}
	
	@AfterTest
	public void browserCloser()
	{
		driver.close();
	}
	

		
	}


