package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PurchaseOrderPage {
	
	@FindBy(xpath = "//span[.='Create Order']")
	private WebElement createOrderBtn;
	
	@FindBy(xpath="//table[@class = 'table table-striped table-hover']/tbody/tr/td[2]")
	private List<WebElement> subjectTxt; 
	
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	public List<WebElement> getSubjectTxt() {
		return subjectTxt;
	}
	
	//Business Library
	/**
	 * This method clicks on create order button
	 */
	
	public void clickOnCreateOrder()
	{
		createOrderBtn.click();
	}
	
	/**
	 * This method will capture all PO subject names and compare with required subject name 
	 * @param ReqSubjectName
	 */
	public void validateSubjectOrder(String ReqSubjectName)
	{
		for(WebElement so:subjectTxt)
		{
			String ActualSubjectName = so.getText();
			Assert.assertEquals(ActualSubjectName, ReqSubjectName);
			System.out.println("Purchase order with subject" + " "+ ActualSubjectName+ " created successfully");
			break;
		}
	}
	

}
