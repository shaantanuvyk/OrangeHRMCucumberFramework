package pageObjects;
import org.openqa.selenium.WebDriver;

import stepDefinitions.Hooks;



public class PageObjectManager 
{
	//Created OrangeHRMLoginPage variable
	public OrangeHRMLoginPage loginpage;
	
	//Created local WebDriver
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)	
	{
		this.driver= driver;
	}
	
	public OrangeHRMLoginPage getLloginPage()
	{
		loginpage = new OrangeHRMLoginPage(driver);
		return loginpage;
	}
	
}
