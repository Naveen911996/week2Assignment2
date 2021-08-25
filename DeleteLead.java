package week2.Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("191");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("135");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9885757013");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String linkText = driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		System.out.println("lead ID of First Resulting lead is " + linkText);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(linkText);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		String text2 = "No records to display";
		if(text.equals(text2))
		{
			System.out.println("message confirms the successful deletion");
		}
		else
		{
			System.out.println("message confirms the not successful deletion");
		}
		driver.close();
	}

}
