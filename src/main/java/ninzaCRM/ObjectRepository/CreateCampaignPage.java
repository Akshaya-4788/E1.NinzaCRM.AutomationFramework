package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	@FindBy(name="campaignName")
	private WebElement CampaignName;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	
	}

	public WebElement getCampaignName() {
		return CampaignName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	//Business Library
	/**
	 * This method will create campaign with mandatory details 
	 * @param CN
	 * @param TS
	 */
	
	public void createCampaign(String CN, String TS)
	{
		CampaignName.sendKeys(CN);
		targetSize.sendKeys(TS);
		createCampaignBtn.click();
	}
}
