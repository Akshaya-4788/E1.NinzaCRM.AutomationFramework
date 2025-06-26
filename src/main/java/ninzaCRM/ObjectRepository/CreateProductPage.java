package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateProductPage extends SeleniumUtility {
	
	@FindBy(xpath="//input[@name='productName']")
	private WebElement productName;
	
	@FindBy(xpath = "//select[@name='productCategory']")
	private WebElement selDropdownCategory;
	
	@FindBy(xpath = "//input[@name='quantity']")
	private WebElement quantity;
	
	@FindBy(xpath = "//input[@name='price']")
	private WebElement pricePerUnit;
	
	@FindBy (xpath = "//select[@name='vendorId']")
	private WebElement selDropdownVendor;
	
	@FindBy (xpath = "//button[.='Add']")
	private WebElement addBtn;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSelDropdownCategory() {
		return selDropdownCategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPricePerUnit() {
		return pricePerUnit;
	}

	public WebElement getSelDropdownVendor() {
		return selDropdownVendor;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	
	//Business Library
	/**
	 * This method will create product with mandatory details 
	 * @param PN
	 * @param Qty
	 * @param ctgy
	 * @param PP
	 * @param ven
	 */
	public void createProduct(String PN, String ctgy, String Qty, String PP, String ven)
	{
		productName.sendKeys(PN);
		handleDropdown(ctgy, selDropdownCategory);
		quantity.sendKeys(Qty);
		pricePerUnit.sendKeys(PP);
		handleDropdown(ven, selDropdownVendor);
		addBtn.click();
		
		
	}
	
	

}
