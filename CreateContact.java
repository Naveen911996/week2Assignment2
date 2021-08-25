package week2.Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Test");
		driver.findElement(By.id("lastNameField")).sendKeys("Leaf");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Test");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Lesf");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createContactForm_description")).sendKeys("selenium");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testleaf@gmail.com");
		WebElement drpDown2 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select drpDow2 = new Select(drpDown2);
		drpDow2.selectByValue("NY");
		
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//textarea[text()='selenium']")).clear();
		driver.findElement(By.xpath("//textarea[@name=\"importantNote\"]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//input[@type=\"submit\"])[1]")).click();
		
		String title = driver.getTitle();
		System.out.println("The title of the resulting Page is " + "'" + title + "'" );

	}

}
