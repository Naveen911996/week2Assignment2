package week2.Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Testing");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		String title = driver.getTitle();
		System.out.println("The title of the  Page is " + "'" + title + "'" );
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		String newCompanyName = "TestingNewUpdate";
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newCompanyName);
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String[] split = companyName.split(" ");
		if(newCompanyName.equals(split[0]))
		{
			System.out.println("Company name Updated successfully");
			
		}
		else
		{
			System.out.println("Company name not Updated successfully");
		}
		driver.close();
	}

}
