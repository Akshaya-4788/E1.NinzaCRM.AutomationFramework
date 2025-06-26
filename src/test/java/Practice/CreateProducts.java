package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProducts {
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
		
		// Go to products link
		driver.findElement(By.linkText("Products")).click();			
		
		//Click on add new product link
		driver.findElement(By.xpath("//span[.=\"Add Product\"]")).click();	
		
		// Create product with all mandatory details
		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys("LenovoProBook");
		WebElement CatdropDown = driver.findElement(By.xpath("//select[@name='productCategory']"));
		Select s = new Select(CatdropDown);
		s.selectByVisibleText("Electronics");
	}
		
		
	}


