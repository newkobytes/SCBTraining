package com.SCBDigitalTraining;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class screenShotExample {

		WebDriver driver;
		public screenShotExample()
		{
			//System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		public void loadUrl()
		{
			driver.get("https://www.google.com/");
			System.out.println("Title of the page:" + driver.getTitle());
			//System.out.println("Source of the page:" + driver.getPageSource());
			System.out.println("urrent URL of the page:" + driver.getCurrentUrl());
		}
		public void takeScreenShot() throws IOException
		{
			TakesScreenshot sc = (TakesScreenshot)driver;
			File scrFile = sc.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./newimage1.png"));
		}
		public void takeScreenShotOfElement() throws IOException
		{
			WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20L));
			WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/img")));
			File scrFile = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./ElementScreenShot3.png"));
		}
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			screenShotExample s = new screenShotExample();
			s.loadUrl();
			//s.takeScreenShot();
			s.takeScreenShotOfElement();
		}
	 
	}


