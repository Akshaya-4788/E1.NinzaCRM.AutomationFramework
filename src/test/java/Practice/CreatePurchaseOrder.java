package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreatePurchaseOrder {

	public static void main(String[] args) {
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
		
		// Go to purchase order link
		driver.findElement(By.linkText("Purchase Order")).click();			
		
		//Click on add new order link
		driver.findElement(By.xpath("//span[.='Create Order']")).click();	
		//Fill in mandatory subjects
		driver.findElement(By.xpath("//input[@name = 'subject']")).sendKeys("Subjectorder123");
		driver.findElement(By.xpath("//input[@name = 'dueDate']")).sendKeys("06/20/2021");
		//Navigate to contact page
		driver.findElement(By.xpath("(//*[local-name()='svg']/parent::button)[1]")).click();
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
		s.selectByVisibleText("Contact Name");
		driver.findElement(By.id("search-input")).sendKeys("Shivang");
		driver.findElement(By.xpath("//td[.='Shivang']/following-sibling::td/child::button")).click();
		
		//switch the window control to main
		driver.switchTo().window(mainWindID);
		
		driver.findElement(By.xpath("(//textarea[@name='address'])[1]")).sendKeys("Bangalore");
		

	}

}
