package week2.Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activities2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Complete all the 4 activities in Button Page: http://leafground.com/pages/Button.html
		
		System.out.println("The position of the button in X and Y is "+driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation());
		System.out.println("The color of the button is "+driver.findElement(By.id("color")).getCssValue("background-color"));
		System.out.println("The Size of the button in width and height is "+driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize());
		driver.findElement(By.id("home")).click();
	}

}
