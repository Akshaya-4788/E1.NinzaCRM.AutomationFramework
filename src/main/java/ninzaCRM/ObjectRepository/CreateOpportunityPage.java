package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateOpportunityPage extends SeleniumUtility {
	
	@FindBy(name = "opportunityName")
	private WebElement opportunityName;
	
	@FindBy(name = "amount" )
	private WebElement amount;
	
	@FindBy(name = "businessType")
	private WebElement businessType;
	
	@FindBy(name = "nextStep" )
	private WebElement nextStep;
	
	@FindBy(name = "salesStage")
	private WebElement salesStage;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectLeadBtn;
	
	@FindBy(id ="search-criteria")
	private WebElement selDropdown;
	
	@FindBy(id = "search-input")
	private WebElement searchInput;
	
	@FindBy (xpath = "//button[.='Create Opportunity']")
	private WebElement createOpportunity;
	
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityName() {
		return opportunityName;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getBusinessType() {
		return businessType;
	}

	public WebElement getNextStep() {
		return nextStep;
	}

	public WebElement getSalesStage() {
		return salesStage;
	}

	public WebElement getSelectLeadBtn() {
		return selectLeadBtn;
	}

	public WebElement getSelDropdown() {
		return selDropdown;
	}

	public WebElement getSearchInput() {
		return searchInput;
	}

	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}
	
	// Business Library
	
	public void createOpportunityWithLead(WebDriver driver, String OppName, String Amt, String BusType, String NxtStp, String SalesStage, String LeadName) throws InterruptedException
	{
		opportunityName.sendKeys(OppName);
		amount.sendKeys(Amt);
		businessType.sendKeys(BusType);
		nextStep.sendKeys(NxtStp);
		salesStage.sendKeys(SalesStage);
		
		selectLeadBtn.click();
		
		switchToWindow(driver, "Lead");
		Thread.sleep(3000);
		
		handleDropdown("Lead Name", selDropdown);
		searchInput.sendKeys(LeadName);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//td[.='"+LeadName+"']/following-sibling::td/child::button")).click();
		
		Thread.sleep(2000);
		
		switchToWindow(driver, "Ninza");
		Thread.sleep(1000);
		
		createOpportunity.click();
		
	}
	
	
	
	
	

}
