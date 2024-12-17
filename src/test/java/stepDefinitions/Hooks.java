package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
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
	
	@Before("@AddUser")
	public void beforeTest() throws IOException
	{
		//testcontextsetup.loginStepDefinition.user_is_trying_to_login_with_valid_credentials_using_and("Admin", "testingWITH");
		//loginPage = 
		testcontextsetup.pageObjectManager.getloginPage().userName(testcontextsetup.testbase.getPropties("username"));
		testcontextsetup.pageObjectManager.getloginPage().userPassword(testcontextsetup.testbase.getPropties("password"));
		testcontextsetup.pageObjectManager.getloginPage().loginButtonClick();
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
