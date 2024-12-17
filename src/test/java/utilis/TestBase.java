package utilis;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.plugin.event.Node.Scenario;

public class TestBase 
{
	public WebDriver driver; 
	public Scenario scenarioName;
	String localbrowser;
	String globalbrowser; 
	FileReader filereader;
	Properties prop;
	
	public WebDriver WebDrivermanager() throws IOException
	{
		
		localbrowser= getPropties("browser");
		globalbrowser=System.getProperty("browser");
		String browser= globalbrowser!=null ? globalbrowser : localbrowser;
	
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("Chrome")||browser.equalsIgnoreCase("Google Chrome"))	
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resource\\chromedriver.exe");
				driver= new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("Firefox")||browser.equalsIgnoreCase("Fire fox")||browser.equalsIgnoreCase("FF"))
			{ 
				System.setProperty("webdriver.firefox.driver", "C:\\Users\\ACER\\Desktop\\Shantanu Karambalkar\\geckodriver-v0.35.0-win-aarch64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if(browser.equalsIgnoreCase("Edge")||browser.equalsIgnoreCase("Microsoft Edge"))
			{
				System.setProperty("webdriver.edge.driver", "C:\\Users\\ACER\\Desktop\\Shantanu Karambalkar\\edgedriver_win64\\msedgedriver.exe");
				driver= new EdgeDriver();

			}
			driver.get(prop.getProperty("OrangeHRMURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		return driver;
	}
	
	public String getPropties(String value) throws IOException
	{
		filereader= new FileReader(System.getProperty("user.dir")+"\\src\\test\\resource\\Global.properties");
		prop = new Properties();
		prop.load(filereader);
		return prop.getProperty(value);
	}
	
	/*
	 * public String getBrowser() throws IOException { prop.load(filereader);
	 * return prop.getProperty("browser"); 
	 * }
	 */
}
