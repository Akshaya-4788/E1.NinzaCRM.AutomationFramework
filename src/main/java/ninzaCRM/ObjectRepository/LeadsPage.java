package ninzaCRM.ObjectRepository;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	@FindBy(xpath = "//span[.='Create Lead']")
	private WebElement createLead;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> LeadNamesTxt;
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLead() {
		return createLead;
	}
	
	public List<WebElement> getLeadNamesTxt() {
		return LeadNamesTxt;
	}

	/*public void setLeadNamesTxt(List<WebElement> leadNamesTxt) {
		LeadNamesTxt = leadNamesTxt;
	}*/

	/**
	 * This method will click on  create lead option
	 */
	public void createLead()
	{
		createLead.click();
	}
	
	/**
	 * This method will capture all lead names and compare with required lead name
	 * @param RequiredLeadName
	 */
	
	public void captureLeadNamesAndCompare(String RequiredLeadName)
	{
		for (WebElement element : LeadNamesTxt) {
			 
			String LeadName = element.getText();
			if(LeadName.equals(RequiredLeadName))
			{
				System.out.println("Lead Created");
				break;
			}
		}
	}

}
