package week2.Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activities {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Complete all the 5 activities in Edit Page: http://leafground.com/pages/Edit.html
		driver.findElement(By.id("email")).sendKeys("naveenkumarbalusamy@gmail.com");
		String text = driver.findElement(By.xpath("//input[@value='Append ']")).getAttribute("value");
		 driver.findElement(By.xpath("//input[@value='Append ']")).clear();
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("TestLeaf" + text);
		String text1 = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println("The default value in the textbox is : "+ text1);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		System.out.println("The field is enable : " + driver.findElement(By.xpath("(//input[@type='text'])[5]")).isEnabled());
	}

}
