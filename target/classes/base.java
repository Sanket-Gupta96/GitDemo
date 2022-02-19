package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {
	
	public static  WebDriver driver;
	
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		/*here we are creating one new properties file and we put our data globally there so we dont 
		 need to declare browser details in each testcases >>we have created one data property file >>and created  
		 properties class object >>and also used fileinput stream class for getting file data
		 To get more info refer Section 19*/
		prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\sashokgu\\OneDrive - Capgemini\\Documents\\Testing\\Selenium\\Selenium_Workspace\\E2E_Framework\\src\\main\\java\\resources\\data.properties");
		
//		to integrate both the file we use following code
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sashokgu\\OneDrive - Capgemini\\Documents\\PDATA\\Testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			
			System.setProperty("webdriver. gecko. driver", "C:\\Users\\sashokgu\\OneDrive - Capgemini\\Documents\\PDATA\\Testing\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("Edge"))
		{
			
			System.setProperty("webdriver.edge.driver", "C:\\Users\\sashokgu\\OneDrive - Capgemini\\Documents\\PDATA\\Testing\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;

	}
	
//	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException
//	{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source  = ts.getScreenshotAs(OutputType.FILE);
//		
//		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName + ".png";
//		
//		FileUtils.copyFile(source, new File(destinationFile));
//	}
	
	public String getScreenShotPath() throws IOException
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		//String png= System.currentTimeMillis()+ ".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+formater.format(calendar.getTime())+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
