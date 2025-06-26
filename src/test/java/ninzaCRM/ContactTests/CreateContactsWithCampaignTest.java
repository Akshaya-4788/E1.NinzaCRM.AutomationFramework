package ninzaCRM.ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;

public class CreateContactsWithCampaignTest extends BaseClass {
	
	@Test
	public void createContactsWithCampaign() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read data from excel
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration test cases", 4, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration test cases", 4, 3);
		
		String ORGANIZATION = eUtil.readDataFromExcel("Integration test cases", 4, 4);
		String TITLE = eUtil.readDataFromExcel("Integration test cases", 4, 5);
		String CONTACTNAME = eUtil.readDataFromExcel("Integration test cases", 4, 6);
		String MOBILE = eUtil.readDataFromExcel("Integration test cases", 4, 7);
		
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
	}

}
