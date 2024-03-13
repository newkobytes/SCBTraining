package com.SCBDigitalTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestApplication {
	
	public static void main(String[] args)
	{

	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demo.automationtesting.in/Register.html");
    driver.manage().window().maximize();
    
    WebElement firstname= driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    firstname.sendKeys("Sharmila");
    WebElement lastname= driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
    lastname.sendKeys("Ganesan");
    WebElement address = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
    address.sendKeys("Chennai");
  
    WebElement mail = driver.findElement(By.xpath("//input[@type='email']"));
    mail.sendKeys("abc@gmail.com");
   
    WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
    phone.sendKeys("1234567890");
    WebElement gender = driver.findElement(By.xpath("//input[@value='FeMale']"));
    gender.click();
    WebElement hobbies = driver.findElement(By.xpath("//input[@value='Cricket']"));
    hobbies.click();
    WebElement countries = driver.findElement(By.id("countries"));
    countries.click();
    
    
   // WebElement country = driver.findElement(By.xpath("//span[@class='select2-selection__arrow']"));
    //Select select = new Select(country);
    //select.selectByVisibleText("India");
  
   /* 
    WebElement year = driver.findElement(By.xpath("//select[@placeholder='Year']"));
    Select select = new Select(year);
    select.selectByVisibleText("1997");
    
    WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
    Select select1 = new Select(month);
    select1.selectByVisibleText("January");
    
    WebElement day = driver.findElement(By.xpath("//select[@placeholder='Day']"));
    Select select2 = new Select(day);
    select2.selectByVisibleText("2");
    //driver.close();
    */
    
    WebElement country=driver.findElement(By.id("country"));
    
    SelectOptionFromDropDown(country,"Australia");
   WebElement year = driver.findElement(By.xpath("//select[@placeholder='Year']"));
    SelectOptionFromDropDown(year,"1997");
    WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
    SelectOptionFromDropDown(month,"January");
    WebElement day = driver.findElement(By.xpath("//select[@placeholder='Day']"));
    SelectOptionFromDropDown(day,"29");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", day);
   
  
    WebElement submit = driver.findElement(By.id("submitbtn"));
    submit.click();
    
 
    /*WebElement element = driver.findElement(By.xpath("//select[@placeholder='Day']"));
    Select select = new Select(element);
    select.selectByVisibleText("28");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
    */
	}

	private static void SelectOptionFromDropDown(WebElement ele , String value) {
		Select select = new Select(ele);
		
		List<WebElement> alloptions= select.getOptions();
		for(WebElement option:alloptions)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
		
	}
  
  

	
	}
