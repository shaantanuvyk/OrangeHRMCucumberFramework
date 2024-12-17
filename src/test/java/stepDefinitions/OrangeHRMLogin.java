package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OrangeHRMLoginPage;
import utilis.TestBase;
import utilis.TestContextSetup;

public class OrangeHRMLogin extends TestBase
{
	TestContextSetup testcontextsetup;
	public OrangeHRMLoginPage loginPage;
	
	public OrangeHRMLogin(TestContextSetup testcontextsetup)
	{
			this.testcontextsetup = testcontextsetup;
			System.out.println("System user directory is: " +System.getProperty("user.dir"));
	}
	
	@Given("User is on the Login page")
	public void user_is_on_the_login_page() throws IOException 
	{
		loginPage = testcontextsetup.pageObjectManager.getloginPage();
		System.out.println("loginPage.loginPageText(): " +loginPage.loginPageText());
	}
	
	@When("User is trying to login with blank credentials using {string} and {string}")
	public void user_is_trying_to_login_with_blank_credentials_using_and(String username, String password) 
	{
		loginPage = testcontextsetup.pageObjectManager.getloginPage();
		loginPage.userName("");
		loginPage.userPassword("");
		loginPage.loginButtonClick();
	}
	
	@Then("Error message displays as {string} under username and password textboxes")
	public void error_message_displays_as_under_username_and_password_textboxes(String errorMessage) 
	{
		assertTrue(loginPage.userNameErrorMessageDisplay());
	    assertTrue(loginPage.userPasswordErrorMessageDisplay());	
	}
	
	@When("User is trying to login with invalid credentials using {string} and {string}")
	public void user_is_trying_to_login_with_invalid_credentials_using_and(String username, String password) 
	{
		loginPage = testcontextsetup.pageObjectManager.getloginPage();
		loginPage.userName(username);
		loginPage.userPassword(password);
		loginPage.loginButtonClick();
	}
	
	@Then("Error message displays as {string}")
	public void error_message_displays_as(String errorMessage) 
	{
		assertTrue(loginPage.userInvalidCredentialsErrorDisplays());
		assertEquals(loginPage.userInvalidCredentialsErrorMessage(), errorMessage);
	}
	
	@When("User is trying to login with valid credentials using {string} and {string}")
	public void user_is_trying_to_login_with_valid_credentials_using_and(String username, String password) throws IOException 
	{
		loginPage = testcontextsetup.pageObjectManager.getloginPage();
		loginPage.userName(getPropties("username"));
		loginPage.userPassword(getPropties("password"));
		loginPage.loginButtonClick();
	}
	
	@Then("User gets login successfully on {string} page")
	public void user_gets_login_successfully_on_page(String successMessage) 
	{
		testcontextsetup.dashboardPage= testcontextsetup.pageObjectManager.getloginPage().loginSuccessMessage();
		assertEquals(testcontextsetup.dashboardPage, successMessage);
	}
}
