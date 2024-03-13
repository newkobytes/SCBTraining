package com.SCBDigitalTraining;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertExample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://demo.automationtesting.in/Alerts.html");
	    driver.manage().window().maximize();
	    WebElement ele1= driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
	    WebElement ele2= driver.findElement(By.xpath("//a[text()='Alerts']"));
	    Actions action = new Actions(driver);
	    action.moveToElement(ele1).moveToElement(ele2).click().perform();
	    WebElement ele3= driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
	    Thread.sleep(2000);
	    ele3.click();
	    WebElement ele4 = driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
	    ele4.click();
	    Alert alert = driver.switchTo().alert();
alert.sendKeys("sharmila");
alert.accept();
WebElement ele5= driver.findElement(By.xpath("//p[@id='demo1']"));
ele5.getText();
System.out.println(ele5);

	}

}
