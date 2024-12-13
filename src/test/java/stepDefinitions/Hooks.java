package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import pageObjects.PageObjectManager;
import utilis.TestContextSetup;

public class Hooks 
{
	public TestContextSetup testcontextsetup;
	public WebDriver driver;
	public PageObjectManager pom;
	
	public Hooks(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup = testcontextsetup;
	}
	
	@After
	public void closeBrowser() throws IOException
	{
		testcontextsetup.testbase.WebDrivermanager().quit();
	}
	
	@AfterStep()
	public void screenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			driver=testcontextsetup.testbase.WebDrivermanager();
			File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File("C:\\Users\\ACER\\Desktop\\Screenshots\\"+scenario.getName()+".jpg"));
		}
		
	}
}
