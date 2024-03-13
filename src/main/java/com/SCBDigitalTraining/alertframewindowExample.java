package com.SCBDigitalTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertframewindowExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.shoppersstop.com/");
	    driver.manage().window().maximize();
	    driver.switchTo().newWindow(WindowType.TAB);
	   
	    //switch to window
	   /* String parentid= driver.getWindowHandle();
	    driver.manage().window().maximize();
	   driver.get("https://www.shoppersstop.com/women/c-A20");
	   String childid= driver.getWindowHandle();
	   driver.get("https://www.shoppersstop.com/lp-watches");
	   driver.switchTo().window(childid);
	   System.out.println(driver.getTitle());
	   driver.switchTo().window(parentid);
	   System.out.println(driver.getTitle());
	   */
	    //navigate
	    //driver.navigate().back();
	   
	    //list of windowhandles
	   /* 
	    driver.get("https://www.shoppersstop.com/women/c-A20");
	    driver.getWindowHandle();
	    driver.get("https://www.amazon.com");
	    driver.switchTo().newWindow(WindowType.TAB);
	    driver.getWindowHandle();
	    List<String> windowids= new ArrayList(driver.getWindowHandles());
	    for(String windowid : windowids)
	    {
	    	System.out.println(windowid);
	    	String title= driver.switchTo().window(windowid).getTitle();
	    	System.out.println(title);
	    	
	    }
	    */
	    
	    driver.get("https://en.wikipedia.org/wiki/Milk");
	    List<String> windowids= new ArrayList(driver.getWindowHandles());
	    for(String windowid : windowids)
	    {
	    	System.out.println(windowid);
	    	String title= driver.switchTo().window(windowid).getTitle();
	    	System.out.println(title);
	    	if(title.contains("Milk"))
	    		driver.close();
	    }
	  
	   /* Set<String> windowids= driver.getWindowHandles();
	    List<String> windowidlist= new ArrayList(windowids);
	    
	    String parent= windowidlist.get(0);
	    String child= windowidlist.get(1);
	    System.out.println(parent);
	    System.out.println(child);
	    
	    */
	    
	    
	    /*for(String windowid: windowidlist)
	    {
	    	//String parent= "" +windowid.charAt(0);
	    	String parent= windowid.get(0);
	    	System.out.println(parent);
	    }
	    */
	}

}
