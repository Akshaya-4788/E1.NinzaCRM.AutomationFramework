package ninzaCRM.OpportunityTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.CreateOpportunityPage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.OpportunityPage;

public class CreateOpportunityTest extends BaseClass {
	@Test
	public void createOpportunity() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// Read Test data from excel
		
		String LEADNAME = eUtil.readDataFromExcel("Integration test cases", 7, 2)+jUtil.getRandomNumber();
		String COMPANY = eUtil.readDataFromExcel("Integration test cases", 7, 3);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration test cases", 7, 4);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration test cases", 7, 7);
		String INDUSTRY = eUtil.readDataFromExcel("Integration test cases", 7, 5);
		String RATING = eUtil.readDataFromExcel("Integration test cases", 7,14);
		String PHONE = eUtil.readDataFromExcel("Integration test cases", 7, 6);
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration test cases", 7, 8);
		
		String OPPORTUNITYNAME = eUtil.readDataFromExcel("Integration test cases", 7, 9);
		String AMOUNT = eUtil.readDataFromExcel("Integration test cases", 7, 10);
		String BUSINESSTYPE = eUtil.readDataFromExcel("Integration test cases", 7, 11);
		String NEXTSTEP = eUtil.readDataFromExcel("Integration test cases", 7, 12);
		String SALESSTAGE = eUtil.readDataFromExcel("Integration test cases", 7,13);
		
		//Navigate to leads page
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnLeadsLink();
		
		//Click on create lead button
		LeadsPage lp = new LeadsPage(driver);
		lp.createLead();
	
		//Create new lead with mandatory fields
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.createLeadWithCampaign(driver, LEADNAME,COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS, RATING, CAMPAIGNNAME);
		Thread.sleep(8000);
		
		// Click on Opportunity link
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
