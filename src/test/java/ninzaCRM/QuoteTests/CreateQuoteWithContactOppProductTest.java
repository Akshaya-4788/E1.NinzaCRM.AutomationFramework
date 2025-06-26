package ninzaCRM.QuoteTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.CreateOpportunityPage;
import ninzaCRM.ObjectRepository.CreateProductPage;
import ninzaCRM.ObjectRepository.CreateQuotePage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.OpportunityPage;
import ninzaCRM.ObjectRepository.ProductsPage;
import ninzaCRM.ObjectRepository.QuotesPage;

public class CreateQuoteWithContactOppProductTest extends BaseClass {
	
	@Test
	public void createQuote() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// Read data from excel file 
		// Read data from Excel File		
				String PRODUCTNAME = eUtil.readDataFromExcel("Integration test cases", 37, 2)+jUtil.getRandomNumber();
				String CATEGORY = eUtil.readDataFromExcel("Integration test cases", 37, 3);
				String QUANTITY = eUtil.readDataFromExcel("Integration test cases", 37, 4);
				String PRICEPERUNIT = eUtil.readDataFromExcel("Integration test cases", 37, 5);
				String VENDOR = eUtil.readDataFromExcel("Integration test cases", 37, 6);
				
				String SUBJECTNAME = eUtil.readDataFromExcel("Integration test cases", 37, 7)+jUtil.getRandomNumber();
				String VALIDTILL = eUtil.readDataFromExcel("Integration test cases", 37, 8);
				String BILLINGADDRESS = eUtil.readDataFromExcel("Integration test cases", 37, 9);
				String SHIPPINGADDRESS = eUtil.readDataFromExcel("Integration test cases", 37, 10);
				String BILLINGPOBOX = eUtil.readDataFromExcel("Integration test cases", 37, 11);
				String SHIPPINGPOBOX = eUtil.readDataFromExcel("Integration test cases", 37, 12);
				String BILLINGCITY = eUtil.readDataFromExcel("Integration test cases", 37, 13);
				String CITY = eUtil.readDataFromExcel("Integration test cases", 37, 14);
				String BILLINGSTATE = eUtil.readDataFromExcel("Integration test cases", 37, 15);
				String STATE = eUtil.readDataFromExcel("Integration test cases", 37, 16);
				String BILLINGPOSTALCODE = eUtil.readDataFromExcel("Integration test cases", 37, 17);
				String POSTALCODE = eUtil.readDataFromExcel("Integration test cases", 37, 18);
				String BILLINGCOUNTRY = eUtil.readDataFromExcel("Integration test cases", 37, 19);
				String COUNTRY = eUtil.readDataFromExcel("Integration test cases", 37, 20);
				String QUOTESTAGE = eUtil.readDataFromExcel("Integration test cases", 37, 21);
							
				String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration test cases", 37, 22)+jUtil.getRandomNumber();
				String TARGETSIZE = eUtil.readDataFromExcel("Integration test cases", 37, 23);
				
				String ORGANIZATION = eUtil.readDataFromExcel("Integration test cases", 37, 24);
				String TITLE = eUtil.readDataFromExcel("Integration test cases", 37, 25);
				String CONTACTNAME = eUtil.readDataFromExcel("Integration test cases", 37, 26) +jUtil.getRandomNumber();
				String MOBILE = eUtil.readDataFromExcel("Integration test cases", 37, 27);
				
				String LEADNAME = eUtil.readDataFromExcel("Integration test cases", 37, 28);
				String COMPANY = eUtil.readDataFromExcel("Integration test cases", 37, 29);
				String LEADSOURCE = eUtil.readDataFromExcel("Integration test cases", 37, 30);
				String LEADSTATUS = eUtil.readDataFromExcel("Integration test cases", 37, 33);
				String INDUSTRY = eUtil.readDataFromExcel("Integration test cases", 37, 31);
				String RATING = eUtil.readDataFromExcel("Integration test cases", 37,34);
				String PHONE = eUtil.readDataFromExcel("Integration test cases", 37, 32);
				
				String OPPORTUNITYNAME = eUtil.readDataFromExcel("Integration test cases", 37, 35);
				String AMOUNT = eUtil.readDataFromExcel("Integration test cases", 37, 36);
				String BUSINESSTYPE = eUtil.readDataFromExcel("Integration test cases", 37, 37);
				String NEXTSTEP = eUtil.readDataFromExcel("Integration test cases", 37, 38);
				String SALESSTAGE = eUtil.readDataFromExcel("Integration test cases", 37,39);
				
				// click on create campaign 
				CampaignPage cp = new CampaignPage(driver);
				cp.clickOnCreateCampaignBtn();		
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
				
				//Click on Leads link
				cp.clickOnLeadsLink();
				//click on create new lead button
				LeadsPage lp = new LeadsPage(driver);
				lp.createLead();
				//Create lead with mandatory fields
				CreateLeadPage clp = new CreateLeadPage(driver);
				clp.createLeadWithCampaign(driver, LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS, RATING, CAMPAIGNNAME);
				// validate for lead 
				lp.captureLeadNamesAndCompare(LEADNAME);
				System.out.println(LEADNAME);		
				Thread.sleep(8000);
				
				//Click on Opportunities link
				cp.clickOnOpportunitiesLink();
				//Click on create opportunity button
				OpportunityPage op = new OpportunityPage(driver);
				op.clickOnCreateOpportunity();				
				// Create Opportunity with mandatory fields
				CreateOpportunityPage cop = new CreateOpportunityPage(driver);
				cop.createOpportunityWithLead(driver, OPPORTUNITYNAME, AMOUNT, BUSINESSTYPE, NEXTSTEP, SALESSTAGE, LEADNAME);		
				//Validate for opportunity
				op.validateOpportunity(OPPORTUNITYNAME);
				System.out.println(OPPORTUNITYNAME);
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
				
				//Click on Quote link
				cp.clickOnQuotesLink();
				//click on create quote button
				QuotesPage qp = new QuotesPage(driver);
				qp.clickOnCreateQuoteBtn();
				//Create Quote with mandatory information
				CreateQuotePage cqp = new CreateQuotePage(driver);
				cqp.createQuote(driver, SUBJECTNAME,VALIDTILL, QUOTESTAGE,OPPORTUNITYNAME,CONTACTNAME,BILLINGADDRESS,SHIPPINGADDRESS , BILLINGPOBOX, SHIPPINGPOBOX ,BILLINGCITY,CITY,BILLINGSTATE,STATE,BILLINGPOSTALCODE, POSTALCODE, BILLINGCOUNTRY, COUNTRY, PRODUCTNAME);
				//validate for quote
				qp.validateQuote(SUBJECTNAME);
				System.out.println(SUBJECTNAME);
				Thread.sleep(8000);
				
				
		
	}

}
