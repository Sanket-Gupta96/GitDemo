package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.id("user_email");
	
	By password = By.xpath("//input[@type=\"password\"]");
	
	By login = By.xpath("//input[@type=\"submit\"]");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement submit()
	{
		return driver.findElement(login);
	}
	
	

}
