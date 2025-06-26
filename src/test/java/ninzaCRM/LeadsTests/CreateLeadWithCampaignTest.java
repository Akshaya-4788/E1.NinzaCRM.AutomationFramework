package ninzaCRM.LeadsTests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadWithCampaignTest {
	@Test
	public void tc_01_createLeadWithCampaign() throws InterruptedException
	{
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Navigate to Ninza CRM
		driver.get("http://49.249.28.218:8098/");
		
		//Enter Username and pwd
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		//Click on Sign in
		driver.findElement(By.xpath("//button[text()='Sign In' ]")).click();	
		
		//Click on Campaign link
		driver.findElement(By.linkText("Campaigns")).click();		
		Thread.sleep(1000);	
		
		//Click on create campaign button
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		// Fill in all mandatory details to create a campaign
		driver.findElement(By.name("campaignName")).sendKeys("Digital Media12345678912");
		driver.findElement(By.name("targetSize")).clear();
		driver.findElement(By.name("targetSize")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		/*
		//Verify the confirmation message stating campaign is added
		
		String ConfMsg=driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(ConfMsg.contains("Digital Media123456789"))
		{
				System.out.println("Campaign addedd successfully");
		}
				
		else
		{
				System.out.println("Campaign not added successfully");
		}
		*/
		Thread.sleep(7000);
		//Navigate to Leads module
		driver.findElement(By.linkText("Leads")).click();
			
		//click on create lead button
		driver.findElement(By.xpath("//span[.='Create Lead']")).click();
		
		//create lead with campaign details
		driver.findElement(By.name("name")).sendKeys("Ak");
			driver.findElement(By.name("company")).sendKeys("TCS");
			driver.findElement(By.name("leadSource")).sendKeys("Marketing");
			driver.findElement(By.name("industry")).sendKeys("IT");
			driver.findElement(By.name("leadStatus")).sendKeys("Accepted");
			driver.findElement(By.name("phone")).sendKeys("9999742321");
			driver.findElement(By.name("rating")).sendKeys("3");
			
			//navigate to campaign page
			driver.findElement(By.xpath("//*[local-name()='svg']/parent::button")).click();
			
			//Handle window popup
			String mainWindID = driver.getWindowHandle();
			System.out.println(mainWindID);
			
			Set<String> allWinIds = driver.getWindowHandles();
			for(String winID:allWinIds)
			{
				if(!winID.equals(mainWindID))
				{
					driver.switchTo().window(winID);
					System.out.println(winID);
					break;
				}
			}
			
			System.out.println("Swicth from parent to child successful");
			
			//search for campaign in child window
			WebElement selDropdown = driver.findElement(By.id("search-criteria"));
			Select s = new Select(selDropdown);
			s.selectByVisibleText("Campaign Name");
			
			driver.findElement(By.id("search-input")).sendKeys("Digital Media12345678912");
			driver.findElement(By.xpath("//td[.='Digital Media123456789']/following-sibling::td/child::button")).click();
			
			//switch the window control to main
			driver.switchTo().window(mainWindID);
			
			//Click on create lead
			driver.findElement(By.xpath("//button[.='Create Lead']")).click();
			
			//Validation
			List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]"));
		    for(WebElement ele:list)
		    {
		    	String leadInfo = ele.getText();
		    	System.out.println(leadInfo);   		 
		    	if(leadInfo.equalsIgnoreCase("Ak"))
		    	{
		    		System.out.println(leadInfo);
		    		System.out.println("Lead added successfully");
		    		break;
		    	}
		    }
		    
		    Thread.sleep(8000);
		    //Logout 
		    WebElement ele = driver.findElement(By.xpath("//div[@class='user-icon']"));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
			System.out.println("Logout successful");
		    
	}

	}
