package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewCandidiate 
{
	
	
	@Given("User navigates on {string} page")
	public void user_navigates_on_page(String moduleName) 
	{
	    
	}

	@When("User creates a new user in system as {string} {string} {string}")
	public void user_creates_a_new_user_in_system_as(String firstName, String middleName, String lastname) 
	{
	    
	}

	@Then("New user is created in system")
	public void new_user_is_created_in_system() 
	{
	
	}

	@Then("The fetched records display {string} {string} {string}")
	public void the_fetched_records_display(String string, String string2, String string3) 
	{
	
	}
}
