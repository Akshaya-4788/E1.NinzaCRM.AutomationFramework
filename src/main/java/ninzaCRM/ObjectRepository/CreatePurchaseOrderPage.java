package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreatePurchaseOrderPage extends SeleniumUtility{
	
	@FindBy(xpath = "//input[@name = 'subject']")
	private WebElement subjectName;
	
	@FindBy(xpath = "//input[@name = 'dueDate']")
	private WebElement dueDate;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[1]")
	private WebElement selectContactBtn;
	
	@FindBy(id = "search-criteria")
	private WebElement selDropDownContact;

	@FindBy(id = "search-input")
	private WebElement searchContactTxt;
	
	@FindBy(xpath = "(//textarea[@name='address'])[1]")
	private WebElement billingAddress;
	
	@FindBy(xpath = "(//textarea[@name='address'])[2]")
	private WebElement shippingAddress;
	
	@FindBy(xpath = "(//input[@name='poBox'])[1]" )
	private WebElement billingPObox;
	
	@FindBy(xpath = "(//input[@name='poBox'])[2]" )
	private WebElement shippingPObox;
	
	@FindBy(xpath = "(//input[@name='city'])[1]")
	private WebElement billingCity;
	
	@FindBy(xpath = "(//input[@name='city'])[2]")
	private WebElement city;
	
	@FindBy (xpath = "(//input[@name='state'])[1]")
	private WebElement billingState;
	
	@FindBy (xpath = "(//input[@name='state'])[2]")
	private WebElement state;
	
	@FindBy (xpath = "(//input[@name='postalCode'])[1]")
	private WebElement billingPostalCode;
	
	@FindBy (xpath = "(//input[@name='postalCode'])[2]")
	private WebElement postalCode;
	
	@FindBy (xpath = "(//input[@name='country'])[1]")
	private WebElement billingCountry;
	
	@FindBy (xpath = "(//input[@name='country'])[2]")
	private WebElement country;
	
	@FindBy(xpath = "(//*[local-name()='svg']/parent::button)[2]")
	private WebElement addPoductBtn;
	
	@FindBy(xpath = "//button[.='Create Purchase Order']")
	private WebElement createPurchaseOrder;
	
	public CreatePurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjectName() {
		return subjectName;
	}

	public WebElement getDueDate() {
		return dueDate;
	}

	public WebElement getSelectContactBtn() {
		return selectContactBtn;
	}

	public WebElement getSelDropDownContact() {
		return selDropDownContact;
	}

	public WebElement getSearchContactTxt() {
		return searchContactTxt;
	}

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	public WebElement getShippingAddress() {
		return shippingAddress;
	}

	public WebElement getBillingPObox() {
		return billingPObox;
	}

	public WebElement getShippingPObox() {
		return shippingPObox;
	}

	public WebElement getBillingCity() {
		return billingCity;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getBillingState() {
		return billingState;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getBillingPostalCode() {
		return billingPostalCode;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getBillingCountry() {
		return billingCountry;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getAddPoductBtn() {
		return addPoductBtn;
	}

	public WebElement getCreatePurchaseOrder() {
		return createPurchaseOrder;
	}
	
	//Business Library 
	/**
	 * This method creates purchase order with contact and product
	 * @param driver
	 * @param subject
	 * @param dd
	 * @param contact
	 * @param BillAd
	 * @param ShipAd
	 * @param BillPO
	 * @param ShipPO
	 * @param BillCity
	 * @param City
	 * @param BillState
	 * @param State
	 * @param billPostal
	 * @param Postal
	 * @param BillCountry
	 * @param Country
	 * @param Pname
	 * @throws InterruptedException
	 */
	
	public void createPurchaseOrderWithContactProduct(WebDriver driver, String subject, String dd, String contact, String BillAd, String ShipAd, String BillPO, String ShipPO, String BillCity, String City, String BillState, String State, String billPostal, String Postal, String BillCountry, String Country, String Pname) throws InterruptedException
	{
		subjectName.sendKeys(subject);
		dueDate.sendKeys(dd);
		//Select contact
		selectContactBtn.click();
		switchToWindow(driver, "Contact");
		Thread.sleep(3000);	
		handleDropdown("Contact Name", selDropDownContact);
		searchContactTxt.sendKeys(contact);	
        Thread.sleep(3000);		
		driver.findElement(By.xpath("//td[.='"+contact+"']/following-sibling::td/child::button")).click();		
		Thread.sleep(2000);		
		switchToWindow(driver, "Ninza");
		Thread.sleep(1000);
		billingAddress.sendKeys(BillAd);
		shippingAddress.sendKeys(ShipAd);
		billingPObox.sendKeys(BillPO);
		shippingPObox.sendKeys(ShipPO);
		billingCity.sendKeys(BillCity);
		city.sendKeys(City);
		billingState.sendKeys(BillState);
		state.sendKeys(State);
		billingPostalCode.sendKeys(billPostal);
		postalCode.sendKeys(Postal);
		billingCountry.sendKeys(BillCountry);
		country.sendKeys(Country);
		//select product
		addPoductBtn.click();
		switchToWindow(driver, "Product");
		Thread.sleep(3000);
		handleDropdown("Product Name", selDropDownContact);
		searchContactTxt.sendKeys(Pname);
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//td[.='"+Pname+"']/following-sibling::td/child::button")).click();		
		Thread.sleep(2000);		
		switchToWindow(driver, "Ninza");
		Thread.sleep(1000);
		createPurchaseOrder.click();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

}
