package stepDefinitions;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddUserPage;
import utilis.TestContextSetup;


public class AddUser
{
	TestContextSetup testcontextsetup;
	public AddUserPage adduserpage; 
	public String firstName;
	
	public AddUser(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup= testcontextsetup;
		adduserpage = testcontextsetup.pageObjectManager.getAddUserPage();
	}
	
	@Given("User is on the {string} page")
	public void user_is_on_the_page(String menuOptionName) 
	{
		adduserpage.menuOption(menuOptionName);
	}

	@When("Enter user {string}, {string}, {string}")
	public void enter_user(String fname, String mname, String lname) 
	{
		adduserpage.addUserButton();
		firstName = fname;
		adduserpage.addFirstName(fname);
		adduserpage.addMiddleName(mname);
		adduserpage.addLastName(lname);
		
	}

	@When("Saving the Details")
	public void saving_the_details() 
	{
		adduserpage.saveUserButton(); 
	}

	@Then("User gets added to the system with {string}, {string}, {string}")
	public void user_gets_added_to_the_system_with(String fname, String mname, String lname) 
	{
		adduserpage.saveUserDetails();
	}

	@Then("On searching user gets fetched")
	public void on_searching_user_gets_fetched() throws InterruptedException 
	{
		adduserpage.menuOption("PIM");
		adduserpage.fetchName(firstName+" ");
	}

}
