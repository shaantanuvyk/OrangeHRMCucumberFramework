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
	
	public WebDriver WebDrivermanager() throws IOException
	{
		if(driver==null)
		{
			if(getPropties("browser").equalsIgnoreCase("Chrome")||getPropties("browser").equalsIgnoreCase("Google Chrome"))	
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resource\\chromedriver.exe");
				driver= new ChromeDriver();
				driver.get(getPropties("OrangeHRMURL"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
			if(getPropties("browser").equalsIgnoreCase("Edge"))
			{ 
				System.setProperty("webdriver.edge.driver", "");
				driver= new EdgeDriver();
			}
			if(getPropties("browser").equalsIgnoreCase("FF")||getPropties("browser").equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.firefox.driver", "");
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	public String getPropties(String value) throws IOException
	{
		FileReader fir = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resource\\Global.properties");
		//String systemPropertyName = ;
		Properties prop = new Properties();
		prop.load(fir);
		
		return prop.getProperty(value);
		
	}
}
