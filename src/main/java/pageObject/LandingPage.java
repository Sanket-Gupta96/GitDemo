package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	
	By title = By.cssSelector("div[class='text-center'] h2");
	
	By navbar = By.xpath("//nav[@class='navbar-collapse collapse']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement title()
	{
		return driver.findElement(title);
	}
		
	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
	}
	

}
