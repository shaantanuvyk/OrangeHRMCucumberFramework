package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LeavePage;
import utilis.TestContextSetup;

public class Leave 
{
	TestContextSetup testcontextsetup;
	public String employeeFirstName;
	public LeavePage leavepage; 
	
	public Leave(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup = testcontextsetup;
		leavepage = testcontextsetup.pageObjectManager.getLeavePage();
	}
	
	
	@Given("user navigates to the {string} sub-tab")
	public void user_navigates_to_the_sub_tab(String tabName) 
	{
		testcontextsetup.pageObjectManager.adduserpage.menuOption(tabName);
		leavepage.navigatingtoassignleave(tabName);
	}

	@When("User enters Employee name")
	public void user_enters_employee_name() throws InterruptedException 
	{
		
		leavepage.enteremployeename();
	}

	@When("Enter Leave type as {string}")
	public void enter_leave_type_as(String leavetype) throws InterruptedException 
	{
		leavepage.clickonleavetypedropdownicon();
		Thread.sleep(7000);;
		leavepage.leavetypedropdownoptions(leavetype);
	}

	@When("Sets start date as {int} month as {string} and year as {int}")
	public void sets_start_date_as_month_as_and_year_as(int day, String month, int year) 
	{ 
		leavepage.calendarSelection(day, month, year);
	}

	@When("Partial Days as {string}")
	public void partial_days_as(String string) 
	{ 
		 
	/*	leavepage.partialdaydropdowniconclick();
		leavepage.partialdaydropdownoptionsselection(string);
		*/
	}

	@When("Duration as {string} From {string} Hours {string} minutes {string} to {string} Hours {string} minutes {string}")
	public void duration_as_from_hours_minutes_to_hours_minutes(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
	    
	}

	@Then("Save the details by assigning the leave")
	public void save_the_details_by_assigning_the_leave() {
	    
	}

	@When("enter employee name, select leave status, and leave type")
	public void enter_employee_name_select_leave_status_and_leave_type() {
	   
	}

	@When("user clicks on the Search button")
	public void user_clicks_on_the_search_button() {
	    
	}

}
