package com.SCBDigitalTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestApplication2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://demo.automationtesting.in/Register.html");
	    driver.manage().window().maximize();
	    
	    WebElement firstname= driver.findElement(By.xpath("//input[@placeholder='First Name']"));
	    firstname.sendKeys("Sharmila");
	    WebElement lastname= driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
	    lastname.sendKeys("Ganesan");
	     

	}

}
