package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactsPage {
	
	@FindBy (xpath = "//span[.='Create Contact']")
	private WebElement createContactBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> contactNamesTxt;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public List<WebElement> getContactNamesTxt() {
		return contactNamesTxt;
	}
	
	// Business Library
	
	/**
	 * This method will click on create contact button
	 */
	
	public void clickOnCreateContactBtn()
	{
		createContactBtn.click();
	}
	
	/**
	 * This method will capture all contact names and compare with required contact name 
	 * @param ReqContactName
	 */
	public void validateContact(String ReqContactName)
	{
		for(WebElement ele:contactNamesTxt)
		{
			String ActualContactName = ele.getText();
			Assert.assertEquals(ReqContactName, ActualContactName);
			System.out.println("Purchase order with contact" + " "+ ActualContactName + " created successfully");
			break;
		}
	}
	
		
	}


