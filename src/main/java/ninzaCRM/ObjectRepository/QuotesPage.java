package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class QuotesPage {
	
	@FindBy(xpath = "//span[.='Create Quote']")
	private WebElement createQuoteBtn;
	
	@FindBy(xpath="//table[@class = 'table table-striped table-hover']/tbody/tr/td[2]")
	private List<WebElement> QuoteSubjectTxt; 
	
	public QuotesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateQuoteBtn() {
		return createQuoteBtn;
	}

	public List<WebElement> getQuoteSubjectTxt() {
		return QuoteSubjectTxt;
	}
	
	//Business Library
	
	/**
	 * This method will click on create quote button
	 */
	
	public void clickOnCreateQuoteBtn()
	{
		createQuoteBtn.click();
	}
	
	/**
	 * This method will capture all Quote subject names and compare with required subject name
	 * @param ReqQuoteName
	 */
	
	public void validateQuote(String ReqQuoteName)
	{
		for(WebElement ele: QuoteSubjectTxt)
		{
			String ActualQuoteName = ele.getText();
			Assert.assertEquals(ActualQuoteName, ReqQuoteName);
			System.out.println("Quote create successfully");
			break;
		}
	}

}
