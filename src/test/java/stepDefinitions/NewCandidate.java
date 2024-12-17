package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.NewCandidatePage;
import utilis.TestContextSetup;

public class NewCandidate 
{
	TestContextSetup testcontextsetup;
	NewCandidatePage newcandidatepage;
	public String firstname; 
	
	public NewCandidate(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup = testcontextsetup;
		newcandidatepage = testcontextsetup.pageObjectManager.getNewCandidatePage();
	}
	
	@Given("User navigates on {string} page")
	public void user_navigates_on_page(String moduleName) 
	{
		testcontextsetup.pageObjectManager.getAddUserPage().menuOption(moduleName);	
		newcandidatepage.CandidateAddButton();
	}

	@When("User creates a new user in system as {string} {string} {string} {string}")
	public void user_creates_a_new_user_in_system_as(String firstName, String middleName, String lastname, String email) throws InterruptedException 
	{
		this.firstname= firstName;
		newcandidatepage.CandidateFirstName(firstName);
		newcandidatepage.CandidateMiddleName(middleName);
		newcandidatepage.CandidateLastName(lastname);
		newcandidatepage.CandidateEmail(email);
		Thread.sleep(7000);
	}

	@Then("New user is created in system")
	public void new_user_is_created_in_system() 
	{
		newcandidatepage.SaveCandidiateDetails();
		newcandidatepage.ClickingOnCandidateSubTab();
		
	}

	@Then("The fetched records display {string} {string} {string}")
	public void the_fetched_records_display(String string, String string2, String string3) throws InterruptedException 
	{
		newcandidatepage.SearchByCandidiateName(firstname+" ");
		newcandidatepage.CandidateSearchResult();
	}
}
