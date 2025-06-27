package ninzaCRM.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
	@FindBy(id="username")
	private WebElement userName;

	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign In' ]")
	private WebElement SignIn;
	
	WebDriver driver;
	
	
	
	//Rule 3 - Initialization	
	public LoginPage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);
	}
	
	//Rule 4 - Utilisation
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignIn() {
		return SignIn;
	}
	
	//Business Library
	
	/**
	 * This method will perform the login operation
	 * @param un
	 * @param pwd
	 */
	
	public void login(String un, String pwd)
	{
		userName.sendKeys(un);
		password.sendKeys(pwd);
		SignIn.click();
		
	}
	
	
	
	
}
