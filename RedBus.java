package week2.Assignment2;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai (All Locations)");
		driver.findElement(By.xpath("//li[@data-no='1']")).click();
		
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//li[@data-no='1']")).click();
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[text()='22']")).click();
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='close']")).click();
		String totalBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total buses : "+totalBus);
		
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		Thread.sleep(5000);
		String sleeperBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total Sleeper buses : "+sleeperBus);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[@for='bt_AC']")).click();
		
	}
	

}
