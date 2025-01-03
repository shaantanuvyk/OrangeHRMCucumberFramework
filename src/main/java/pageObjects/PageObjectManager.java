package pageObjects;
import org.openqa.selenium.WebDriver;



public class PageObjectManager 
{
	//Created OrangeHRMLoginPage variable
	public OrangeHRMLoginPage loginpage;
	public AddUserPage adduserpage; 
	public NewCandidatePage newcandidatepage;
	
	//Created local WebDriver
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)	
	{
		this.driver= driver;
	}
	
	public OrangeHRMLoginPage getloginPage()
	{
		loginpage = new OrangeHRMLoginPage(driver);
		return loginpage;
	}
	
	public AddUserPage getAddUserPage()
	{
		adduserpage = new AddUserPage(driver);
		return adduserpage;
	}
	
	public NewCandidatePage getNewCandidatePage()
	{
		newcandidatepage = new NewCandidatePage(driver);
		return newcandidatepage;
	}
	
	
}
