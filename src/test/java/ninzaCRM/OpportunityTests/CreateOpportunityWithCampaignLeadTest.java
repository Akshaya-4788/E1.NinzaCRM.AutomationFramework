package ninzaCRM.OpportunityTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.CreateOpportunityPage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.OpportunityPage;

public class CreateOpportunityWithCampaignLeadTest extends BaseClass {
	
	@Test
	public void createOppWithCampaignLead() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		//Read data from excel utility
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration test cases", 31, 2)+jUtil.getRandomNumber();
		String TARGETSIZE = eUtil.readDataFromExcel("Integration test cases", 31, 3);
		
		String LEADNAME = eUtil.readDataFromExcel("Integration test cases", 31, 4);
		String COMPANY = eUtil.readDataFromExcel("Integration test cases", 31, 5);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration test cases", 31, 6);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration test cases", 31, 9);
		String INDUSTRY = eUtil.readDataFromExcel("Integration test cases", 31, 7);
		String RATING = eUtil.readDataFromExcel("Integration test cases", 31,10);
		String PHONE = eUtil.readDataFromExcel("Integration test cases", 31, 8);
		
		String OPPORTUNITYNAME = eUtil.readDataFromExcel("Integration test cases", 31, 11);
		String AMOUNT = eUtil.readDataFromExcel("Integration test cases", 31, 12);
		String BUSINESSTYPE = eUtil.readDataFromExcel("Integration test cases", 31, 13);
		String NEXTSTEP = eUtil.readDataFromExcel("Integration test cases", 31, 14);
		String SALESSTAGE = eUtil.readDataFromExcel("Integration test cases", 31,15);
		
		
		//Click on create campaign button 
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn(driver);
		//create campaign with mandatory fields
		CreateCampaignPage ccp= new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		Thread.sleep(8000);
		
		//Navigate to Leads link
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
		
		//Navigate to Opportunities link
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
		
	}
	
	

}
