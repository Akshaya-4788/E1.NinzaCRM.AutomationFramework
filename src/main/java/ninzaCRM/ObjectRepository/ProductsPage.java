package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath = "//span[.=\"Add Product\"]")
	private WebElement addProdBtn;
	
	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement selDropdown;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search by')]")
	private WebElement prodSearchTxt;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddProdBtn() {
		return addProdBtn;
	}

	public WebElement getSelDropdown() {
		return selDropdown;
	}

	public WebElement getProdSearchTxt() {
		return prodSearchTxt;
	}
	
	//Business Library
	
	/**
	 * This will click on add product button	
	 */
	
	public void AddProduct()
	{
		addProdBtn.click();
	}
	
	

}
