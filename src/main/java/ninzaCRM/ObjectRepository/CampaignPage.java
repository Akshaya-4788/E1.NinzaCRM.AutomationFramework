package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CampaignPage extends SeleniumUtility {
	
	@FindBy(xpath = "//span[.='Create Campaign']")
	private WebElement createCampaign;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy (linkText = "Products")
	private WebElement ProductsLink;
	
	@FindBy (linkText = "Quotes")
	private WebElement QuotesLink;
	
	@FindBy (linkText = "Purchase Order")
	private WebElement PurchaseOderLink;
	
	@FindBy (linkText = "Sales Order")
	private WebElement SalesOrderLink;
	
	@FindBy (linkText = "Invoice")
	private WebElement InvoiceLink;
	
	@FindBy (xpath = "//div[@class='user-icon']")
	private WebElement userIcon;
	
	@FindBy (xpath = "//div[@class='dropdown-item logout']")
	private WebElement logout;
	
	
	
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCamaignBtn() {
		return createCampaign;
	}
	
	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getQuotesLink() {
		return QuotesLink;
	}

	public WebElement getPurchaseOderLink() {
		return PurchaseOderLink;
	}

	public WebElement getSalesOrderLink() {
		return SalesOrderLink;
	}

	public WebElement getInvoiceLink() {
		return InvoiceLink;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogout() {
		return logout;
	}

	//Business Libraries
	/**
	 * This method will click on create campaign button
	 */
	public void clickOnCreateCampaignBtn(WebDriver driver)
	{
		
		waitForElementToBeClickable(driver, createCampaign);
		createCampaign.click();
		
	}
	
	/**
	 * This method will click on Leads link
	 */
	public void clickOnLeadsLink()
	{
		LeadsLink.click();
	}
	
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink()
	{
		ContactsLink.click();
	}
	
	/**
	 * This method will click on Opportunities link
	 */
	public void clickOnOpportunitiesLink()
	{
		OpportunitiesLink.click();
	}
	
	/**
	 * This method will click on Products link
	 */
	public void clickOnProductsLink()
	{
		ProductsLink.click();
	}
	
	
	/**
	 * This method will click on Quotes link
	 */
	public void clickOnQuotesLink()
	{
		QuotesLink.click();
	}
	
	/**
	 * This method will click on Purchase Order link
	 */
	public void clickOnPurchaseOrderLink()
	{
		PurchaseOderLink.click();
	}
	
	
	/**
	 * This method will click on Sales Order link
	 */
	public void clickOnSalesOrderLink()
	{
		SalesOrderLink.click();
	}
	
	/**
	 * This method will click on Invoice link
	 */
	public void clickOnInvoiceLink()
	{
		InvoiceLink.click();
	}
	
	/**
	 * This method will logout of the application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutofApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, userIcon);
		Thread.sleep(4000);
		logout.click();
	}
	

}
