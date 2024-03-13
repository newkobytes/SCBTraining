package DataProvider;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class ExcelExample 
{
	WebDriver driver;
	@BeforeClass
	public void initializeResources()
	{
		//System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		//driver = new ChromeDriver();
		driver = new EdgeDriver();
	}
	@BeforeMethod
	public void loadUrl()
	{
		driver.get("https://www.facebook.com/");
	}
	@Test(dataProvider = "testdata")
	public void demoClass(String username, String password) throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		//Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Facebook"));
		System.out.println("Login successful");
	}
 
	
 
	@AfterClass
	public void deInitializeResources()
	{
		driver.quit();
		driver=null;
	}
	@DataProvider(name = "testdata")
	public Object[][] testDataExample() {
		ReadExcelFile config = new ReadExcelFile("C:\\SeleniumWebDriver\\employees.xlsx");
		int rows = config.getRowCount("userInfo");
		Object[][] signin_credentials = new Object[rows][2];
 
		for (int i = 0; i < rows; i++) {
			signin_credentials[i][0] = config.getData("userInfo", i,0);
			signin_credentials[i][1] = config.getData("userInfo", i, 1);
		}
		return signin_credentials;
	}
}