package ninzaCRM.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateProductPage;
import ninzaCRM.ObjectRepository.ProductsPage;

public class CreateProductTest extends BaseClass{
	
	@Test
	public void createProduct() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// Read data from excel file
		String PRODUCTNAME = eUtil.readDataFromExcel("Integration test cases", 19, 2);
		String CATEGORY = eUtil.readDataFromExcel("Integration test cases", 19, 3);
		String QUANTITY = eUtil.readDataFromExcel("Integration test cases", 19, 4);
		String PRICEPERUNIT = eUtil.readDataFromExcel("Integration test cases", 19, 5);
		String VENDOR = eUtil.readDataFromExcel("Integration test cases", 19, 6);
		
		//Click on products link
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnProductsLink();
		
		//click on add product button
		ProductsPage pp = new ProductsPage(driver);
		pp.AddProduct();
		
		//Create products with mandatory information
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(PRODUCTNAME, CATEGORY, QUANTITY, PRICEPERUNIT, VENDOR);
		Thread.sleep(8000);
		
	}

}
