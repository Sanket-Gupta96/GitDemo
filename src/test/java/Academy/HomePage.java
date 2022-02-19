package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void browserStart() throws IOException
	{
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		//here we calling initialize driver method which is defined in base file
		//for accessing that method we use extends keyword to access class and then method
		
		LandingPage lp = new LandingPage(driver);
		
		lp.getLogin().click();
		
		
		LoginPage lpa = new LoginPage(driver);
		
		lpa.getEmail().sendKeys(Username);
		lpa.getPassword().sendKeys(Password);
		lpa.submit().click();
		log.info("Login failure");
		log.info(text);
		//here we hardcoded the value of username and pwd
		//but if we want pass it without hardcoding we will use Test Ng dataprovider annotation
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//for this we can create mutidimensional array
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "sanketagupta@gmail.com";
		data[0][1] = "Abc123";
		data[0][2] = "Valid user";
		
		data[1][0] = "nehaagupta@gmail.com";
		data[1][1] = "Abc13";
		data[1][2] = "InValid user";
		
		
		return data;
		
		
	}
	
	@AfterTest
	public void browserCloser()
	{
		driver.close();
	}



}
