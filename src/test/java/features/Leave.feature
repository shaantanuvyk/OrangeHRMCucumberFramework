@EmployeeLeave
Feature: Verify Employee Leave feature is working when leave is applied
  
@ApplyLeave @SmokeTest 
Scenario: Verify Employee can apply for a leave
Given User is on the "Leave" page
And user navigates to the "Assign Leave" sub-tab
When User enters Employee name
And Enter Leave type as "US - Vacation"
And Sets start date as 27 month as "March" and year as 2025
And Partial Days as "All Days"
And Duration as "Specific Time" From "02" Hours "15" minutes "PM" to "10" Hours "25" minutes "PM"
Then Save the details by assigning the leave

@SearchAppliedLeave
Scenario: Verify searching the employee
Given user navigates to the "Leave List" sub-tab
When enter employee name, select leave status, and leave type
And user clicks on the Search button