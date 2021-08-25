package week2.Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("testing@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String firstResLead = driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String title1 = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		
		String title2 = "Duplicate Lead";
		if(title1.equals(title2))
		{
			System.out.println("Title is same and title in page is " + title1);
		}
		else
		{
			System.out.println("Title is Different and title in page is " + title1);
		}
		driver.findElement(By.className("smallSubmit")).click();
		
		String duplicateResLead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(firstResLead.equals(duplicateResLead))
		{
			
			System.out.println("duplicated lead name is same as captured name");
		}
		else
		{
			System.out.println("duplicated lead name is different as captured name");
		}
		driver.close();
	}

}
