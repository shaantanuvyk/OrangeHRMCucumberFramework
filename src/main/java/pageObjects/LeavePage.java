package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LeavePage 
{
	public WebDriver driver;
	public Actions actions;
	
	public LeavePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By assignleavesubtabs = By.cssSelector("nav[role='navigation'][aria-label='Topbar Menu'] li a");
	private By employeename = By.cssSelector("div[class='oxd-autocomplete-wrapper'] input");
	private By leavetypedropdownicon = By.cssSelector("div[class='oxd-select-text-input']");
	private By leavetypedropdownoptions = By.cssSelector("div[role='listbox'] div[role='option']");
	private By partialdaysdropdownicon = By.cssSelector("div[class='oxd-form-row']:nth-child(4) i[class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
	private By partialdaysdropdownoptions = By.cssSelector("div[class='oxd-form-row']:nth-child(4) div[role='listbox'] div");
	private By fromdatedropdownicon = By.cssSelector("div[class='oxd-form-row']:nth-child(3) div[class='oxd-grid-4 orangehrm-full-width-grid'] div i");
	private By todatedropdownicon = By.cssSelector("div[class='oxd-form-row']:nth-child(3) div[class='oxd-grid-4 orangehrm-full-width-grid'] div[class='oxd-grid-item oxd-grid-item--gutters']:nth-child(2) i");
	private By calendarmonthdropdownicon = By.cssSelector("div[class='oxd-date-input-calendar'] div div ul li:nth-child(1) div i");
	private By optionsinmonthsdropdown = By.xpath("//div[@class='oxd-date-input-calendar']/div/div//li[1]/ul/li");
	private By calendaryeardropdownicon = By.cssSelector("div[class='oxd-date-input-calendar'] div div ul li:nth-child(2) div i");
	private By optionsinyeardropdown = By.xpath("//div[@class='oxd-date-input-calendar']/div/div//li[2]/ul/li");
	private By calendardayselect = By.xpath("//div[@class='oxd-calendar-dates-grid']/div");
	
	public void calendarSelection(int day, String month, int year)
	{		
		//for Month Selection
		driver.findElement(fromdatedropdownicon).click(); 
		driver.findElement(calendarmonthdropdownicon).click();
		List<WebElement> months = driver.findElements(optionsinmonthsdropdown);
		int monthsoptioncount = months.size();
		System.out.println("Months options count is: " +monthsoptioncount);
		
		String tempmonthName=null;
		for(int i=0; i<monthsoptioncount; i++)
		{ 
			tempmonthName = months.get(i).getText(); 
			if(tempmonthName.equals(month))
			{
				months.get(i).click(); 
				break;
			} 
		}
		
		System.out.println("Month Selected: " +tempmonthName);
		
		//for Year Selection
		driver.findElement(calendaryeardropdownicon).click();
		List<WebElement> yearlist = driver.findElements(optionsinyeardropdown);
		int yearoptioncount = yearlist.size();
		int tempyearnumber=0;
		for(int j=0; j<yearoptioncount; j++)
		{
			String tempyear =  yearlist.get(j).getText();
			tempyearnumber= Integer.parseInt(tempyear);
			if(tempyearnumber==year)
			{
				yearlist.get(j).click();
				break;
			}
		}
		 
		System.out.println("Year selected: " +tempyearnumber);
		
		//for Day Selection

		List<WebElement> days = driver.findElements(calendardayselect);
		int countDays = days.size();
		int date=0;
		for(int i=1; i<=countDays; i++)
		{
			String tempDate= days.get(i).getText(); 
			date=Integer.parseInt(tempDate);
			if(date==day)
			{
				days.get(i).click();
				break;
			}
			System.out.println("Selected Date is: :" +date);
		}
	} 	
	
	public void enteremployeename() throws InterruptedException
	{
		WebElement empname = driver.findElement(employeename);
		empname.sendKeys("Amelia ");
		Thread.sleep(5000);
		actions = new Actions(driver);
		actions.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	}
	
	public void navigatingtoassignleave(String tabName) 
	{
		List<WebElement> assignleavesubtab = driver.findElements(assignleavesubtabs);
		
		int subtabcount = assignleavesubtab.size();
		
		for(int i=0;i<subtabcount;i++)
		{
			if(assignleavesubtab.get(i).getText().equalsIgnoreCase("Assign Leave"))
			{
				assignleavesubtab.get(i).click();
			}
		}
	}
	
	public void clickonleavetypedropdownicon()
	{
		WebElement dropdownicon=driver.findElement(leavetypedropdownicon);
		dropdownicon.click();
	}
	
	public void leavetypedropdownoptions(String leavetype) throws InterruptedException

	{
		List<WebElement> dropdownoptions = driver.findElements(leavetypedropdownoptions);
		int count = dropdownoptions.size();
		System.out.println("Count is: " +count);
		for(int i=0; i<count; i++)
		{
			String leaveOption = dropdownoptions.get(i).getText();
			if(leaveOption.equalsIgnoreCase(leavetype))
			{
				dropdownoptions.get(i).click();
			}
		}
	}
	
	public void partialdaydropdowniconclick()
	{
		driver.findElement(partialdaysdropdownicon).click();
	}
	
	public void partialdaydropdownoptionsselection(String leaveDuration)
	{
		List<WebElement> dropdownoptions = driver.findElements(partialdaysdropdownoptions);
		int optioncount = dropdownoptions.size();
		for(int i=1; i<=optioncount; i++)
		{
			if(dropdownoptions.get(i).getText().equalsIgnoreCase(leaveDuration))
			{
				dropdownoptions.get(i).click();
			}
		}
	}
	
	
}
