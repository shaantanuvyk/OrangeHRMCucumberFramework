@NewCandidate
Feature: Creating a new candidate

@SmokeTest
Scenario Outline: Create a new candidate in the system
	Given User navigates on "Recruitment" page
  When User creates a new user in system as "<FirstName>" "<MiddleName>" "<LastName>" "<Email>" 
  Then New user is created in system
  And The fetched records display "<FirstName>" "<MiddleName>" "<LastName>" 

Examples:
|FirstName|MiddleName|LastName	|Email					|
|Veena		|Vijay		 |Hundalekar|veenav@acc.com	|