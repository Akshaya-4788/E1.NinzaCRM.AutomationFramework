package ninzaCRM.LeadsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.LeadsPage;

public class CreateLeadTest extends BaseClass {
	
	@Test
	public void createLead() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// Read Test Data from Excel Utility
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration test cases", 1, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration test cases", 1, 3);
		
		String LEADNAME = eUtil.readDataFromExcel("Integration test cases", 1, 4);
		String COMPANY = eUtil.readDataFromExcel("Integration test cases", 1, 5);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration test cases", 1, 6);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration test cases", 1, 9);
		String INDUSTRY = eUtil.readDataFromExcel("Integration test cases", 1, 7);
		String RATING = eUtil.readDataFromExcel("Integration test cases", 1,10);
		String PHONE = eUtil.readDataFromExcel("Integration test cases", 1, 8);
		
		// click on create campaign 
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		// create campaign with mandatory fields
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		Thread.sleep(8000);
		
		// click on leads link
		cp.clickOnLeadsLink();
		
		// click on create lead button
		LeadsPage lp = new LeadsPage(driver);
		lp.createLead();
		
		// create lead with mandatory information	
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.createLeadWithCampaign(driver, LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS, RATING, CAMPAIGNNAME);
		
		// validate for lead 
		lp.captureLeadNamesAndCompare(LEADNAME);
		System.out.println(LEADNAME);
		
		Thread.sleep(8000);
		
	}

}
