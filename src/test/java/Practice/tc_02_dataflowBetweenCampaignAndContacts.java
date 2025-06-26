package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class tc_02_dataflowBetweenCampaignAndContacts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
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
		driver.findElement(By.name("campaignName")).sendKeys("AdvertisementTest");
		driver.findElement(By.name("targetSize")).clear();
		driver.findElement(By.name("targetSize")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		//Verify the confirmation message stating campaign is added
		String ConfMsg=driver.findElement(By.xpath("//div[text()=\"Campaign ddd Successfully Added\"]")).getText();
		if(ConfMsg.contains("ddd"))
		{
			System.out.println("Campaign addedd successfully");
		}
		
		else
		{
			System.out.println("Campaign not added successfully");
		}
		
		driver.quit();
		
		
		
		
		

	}

}
