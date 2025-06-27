package ninzaCRM.PurchaseOrderTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;
import ninzaCRM.ObjectRepository.CreateProductPage;
import ninzaCRM.ObjectRepository.CreatePurchaseOrderPage;
import ninzaCRM.ObjectRepository.ProductsPage;
import ninzaCRM.ObjectRepository.PurchaseOrderPage;

public class CreatePurchaseOrderWithContactProductTest extends BaseClass {
	
	@Test
	public void CreatePurchaseOrder() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// Read data from Excel File		
		String PRODUCTNAME = eUtil.readDataFromExcel("Integration test cases", 34, 2)+jUtil.getRandomNumber();
		String CATEGORY = eUtil.readDataFromExcel("Integration test cases", 34, 3);
		String QUANTITY = eUtil.readDataFromExcel("Integration test cases", 34, 4);
		String PRICEPERUNIT = eUtil.readDataFromExcel("Integration test cases", 34, 5);
		String VENDOR = eUtil.readDataFromExcel("Integration test cases", 34, 6);
		
		String SUBJECTNAME = eUtil.readDataFromExcel("Integration test cases", 34, 7)+jUtil.getRandomNumber();
		String DUEDATE = eUtil.readDataFromExcel("Integration test cases", 34, 8);
		String BILLINGADDRESS = eUtil.readDataFromExcel("Integration test cases", 34, 9);
		String SHIPPINGADDRESS = eUtil.readDataFromExcel("Integration test cases", 34, 10);
		String BILLINGPOBOX = eUtil.readDataFromExcel("Integration test cases", 34, 11);
		String SHIPPINGPOBOX = eUtil.readDataFromExcel("Integration test cases", 34, 12);
		String BILLINGCITY = eUtil.readDataFromExcel("Integration test cases", 34, 13);
		String CITY = eUtil.readDataFromExcel("Integration test cases", 34, 14);
		String BILLINGSTATE = eUtil.readDataFromExcel("Integration test cases", 34, 15);
		String STATE = eUtil.readDataFromExcel("Integration test cases", 34, 16);
		String BILLINGPOSTALCODE = eUtil.readDataFromExcel("Integration test cases", 34, 17);
		String POSTALCODE = eUtil.readDataFromExcel("Integration test cases", 34, 18);
		String BILLINGCOUNTRY = eUtil.readDataFromExcel("Integration test cases", 34, 19);
		String COUNTRY = eUtil.readDataFromExcel("Integration test cases", 34, 20);
		
		
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration test cases", 34, 21)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration test cases", 34, 22);
		
		String ORGANIZATION = eUtil.readDataFromExcel("Integration test cases", 34, 23);
		String TITLE = eUtil.readDataFromExcel("Integration test cases", 34, 24);
		String CONTACTNAME = eUtil.readDataFromExcel("Integration test cases", 34, 25) +jUtil.getRandomNumber();
		String MOBILE = eUtil.readDataFromExcel("Integration test cases", 34, 26);
		
		// click on create campaign 
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn(driver);		
		// create campaign with mandatory fields
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		Thread.sleep(8000);
				
		//Click on contacts link
		cp.clickOnContactsLink();
		//Click on create contact button
		ContactsPage cp1 = new ContactsPage(driver);
		cp1.clickOnCreateContactBtn();
		//Create contact with mandatory fields
		CreateContactPage ccp1 = new CreateContactPage(driver);
		ccp1.clickOnCreateContactbtn(driver, ORGANIZATION, TITLE, CONTACTNAME, MOBILE, CAMPAIGNNAME);
		//validate contact 
		cp1.validateContact(CONTACTNAME);
		Thread.sleep(8000);
			
		//Click on products link
		cp.clickOnProductsLink();			
		//click on add product button
		ProductsPage pp = new ProductsPage(driver);
		pp.AddProduct();		
		//Create products with mandatory information
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(PRODUCTNAME, CATEGORY, QUANTITY, PRICEPERUNIT, VENDOR);
		Thread.sleep(8000);
		
		//Click on purchase order link
		cp.clickOnPurchaseOrderLink();
		//click on create order button
		PurchaseOrderPage po = new PurchaseOrderPage(driver);
		po.clickOnCreateOrder();
		//create purchase order with mandatory information
		CreatePurchaseOrderPage cpo = new CreatePurchaseOrderPage(driver);
		cpo.createPurchaseOrderWithContactProduct(driver, SUBJECTNAME,DUEDATE, CONTACTNAME, BILLINGADDRESS,SHIPPINGADDRESS , BILLINGPOBOX, SHIPPINGPOBOX ,BILLINGCITY,CITY,BILLINGSTATE,STATE,BILLINGPOSTALCODE, POSTALCODE, BILLINGCOUNTRY, COUNTRY, PRODUCTNAME);
		//validate for purchase order
		po.validateSubjectOrder(SUBJECTNAME);
		System.out.println(SUBJECTNAME);
		Thread.sleep(8000);
		
		
	}

}
