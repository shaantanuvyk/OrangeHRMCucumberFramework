package pageObjects;

import org.apache.pdfbox.contentstream.operator.state.Save;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NewCandidatePage 
{
	
	private WebDriver driver;
	
	public NewCandidatePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	private By adduserbutton = By.xpath("//button[text()=' Add ']");
	private By firstnametxtbox = By.cssSelector("input[name='firstName']");
	private By middlenametxtbox = By.cssSelector("input[name='middleName']");
	private By lastnametxtbox = By.cssSelector("input[name='lastName']");
	private By emailtxtbox = By.xpath("//div[@class='orangehrm-card-container']//form/div[3]//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input");
	private By savebutton = By.xpath("//button[text()=' Save ']");
	private By pagesubtab = By.xpath("//ul['data-v-5327b38a']//a[@class='oxd-topbar-body-nav-tab-item']");
	private By candidatenametxtbox = By.xpath("//div[@class='oxd-table-filter']//div[@class='oxd-table-filter-area']/form/div[2]/div/div[1]//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input");
	private By searchcandidiatebutton = By.xpath("//button[text()=' Search ']");
	
	
	public void CandidateAddButton()
	{
		WebElement AddUserButton = driver.findElement(adduserbutton);
		AddUserButton.click();
	}
	
	public void CandidateFirstName(String fname)
	{
		WebElement CandidiateFirstName = driver.findElement(firstnametxtbox);
		CandidiateFirstName.sendKeys(fname);
	}
	
	public void CandidateMiddleName(String mname)
	{
		WebElement CandidateMiddlename = driver.findElement(middlenametxtbox);
		CandidateMiddlename.sendKeys(mname);
	}
	
	
	public void CandidateLastName(String lname)
	{
		WebElement CandidateLastName = driver.findElement(lastnametxtbox);
		CandidateLastName.sendKeys(lname);
	}
	

	public void CandidateEmail(String email)
	{
		WebElement CandidateEmail = driver.findElement(emailtxtbox);
		CandidateEmail.sendKeys(email);
	}
	
	public void SaveCandidiateDetails()
	{
		WebElement SaveCandidateDetails = driver.findElement(savebutton);
		SaveCandidateDetails.click();
	}
	
	
	public void ClickingOnCandidateSubTab()
	{
		int count = driver.findElements(pagesubtab).size();
		
		for(int i=1;i<=count;i++)
		{
			String tabText= driver.findElement(pagesubtab).getText();
			if(tabText.equalsIgnoreCase("Candidates"))
			{
				driver.findElement(pagesubtab).click();
			}
		}
	}
		
	public void SearchByCandidiateName(String name) throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement SearchingByCandiateName = driver.findElement(candidatenametxtbox);
		SearchingByCandiateName.sendKeys("Veena ");
		Thread.sleep(5000);
		action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		
		driver.findElement(searchcandidiatebutton).click();
	}
	
	public void CandidateSearchResult()
	{
		WebElement SearchCandidate = driver.findElement(searchcandidiatebutton);
		SearchCandidate.click();
	}
}
