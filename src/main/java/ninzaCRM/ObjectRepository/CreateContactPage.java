package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateContactPage extends SeleniumUtility {
	
	@FindBy(xpath = "//input[@name = 'organizationName']")
	private WebElement organization;
	
	@FindBy(xpath = "//input[@name = 'title']")
	private WebElement title;
	
	@FindBy(xpath = "//input[@name = 'contactName']")
	private WebElement contactName;
	
	@FindBy(xpath = "//input[@name = 'mobile']")
	private WebElement mobile;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selDropDown;

	@FindBy(id = "search-input")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//button[.='Create Contact']")
	private WebElement createContactBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}

	public WebElement getSelDropDown() {
		return selDropDown;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getCreateLeadBtn() {
		return createContactBtn;
	}
	
	// Business Library
	/**
	 * This method creates contact with mandatory information
	 * @param driver
	 * @param Org
	 * @param Title
	 * @param CN
	 * @param mob
	 * @param CampaignName
	 * @throws InterruptedException
	 */
	
	public void clickOnCreateContactbtn(WebDriver driver, String Org, String Title, String CN, String mob, String CampaignName) throws InterruptedException
	{
		organization.sendKeys(Org);
		title.sendKeys(Title);
		contactName.sendKeys(CN);
		mobile.sendKeys(mob);
		
		selectCampaignBtn.click();
		switchToWindow(driver, "Campaign");
		Thread.sleep(3000);
		handleDropdown("Campaign Name", selDropDown );
		searchTxt.sendKeys(CampaignName);
        Thread.sleep(3000);	
		driver.findElement(By.xpath("//td[.='"+CampaignName+"']/following-sibling::td/child::button")).click();	
		Thread.sleep(2000);		
		switchToWindow(driver, "Ninza");
		Thread.sleep(1000);
		createContactBtn.click();
		
	
		
		
		
	}
	

}
