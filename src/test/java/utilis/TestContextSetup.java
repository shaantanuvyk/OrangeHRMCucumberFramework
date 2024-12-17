package utilis;

import java.io.IOException;
import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.AddUser;
import stepDefinitions.Hooks;
import stepDefinitions.OrangeHRMLogin;



public class TestContextSetup 
{
	//This class holds the variables that needs are shared by multiple stepDefinition classes and PageObjects class
	
	//local WebDriver variable
	public WebDriver driver;
	
	//TestBase class variable
	public TestBase testbase;
	
	//PageObjectManager class variable
	public PageObjectManager pageObjectManager;
	public Hooks hooks;
	
	//Global variable that is needed by different stepDefinition class
	public String dashboardPage;
	

	
	
	//TestContext constructor
	public TestContextSetup() throws IOException
	{
		testbase = new TestBase();
		pageObjectManager = new PageObjectManager(testbase.WebDrivermanager());
	}
}
