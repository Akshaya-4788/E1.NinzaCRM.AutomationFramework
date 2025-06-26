package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpportunityPage {
	
	@FindBy(xpath = "//span[text()=\"Create Opportunity\"]")
	private WebElement createOpportunity;
	
	@FindBy (xpath = "//table[@class=\"table table-striped table-hover\"]//tbody/tr/td[2]")
	private List<WebElement> OpportunityNamesTxt;
	
	public OpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}

	public List<WebElement> getOpportunityNamesTxt() {
		return OpportunityNamesTxt;
	}
	
	// Business Library
	/**
	 * This method will click on create opportunity button
	 */
	public void clickOnCreateOpportunity()
	{
		createOpportunity.click();
	}
	
	/**
	 * This method will capture all opportunity names and compare with required opportunity name 
	 * @param ReqOpName
	 */
	
	public void validateOpportunity(String ReqOpName)
	{
		for(WebElement op:OpportunityNamesTxt)
		{
			String ActualOpName = op.getText();
			Assert.assertEquals(ActualOpName, ReqOpName);
			System.out.println("Oportunity created succssessfully"+ActualOpName);
			break;
			}
				
			
		}
		
	}


