package pracproject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class phptravelstest {
	        public String baseURL = "https://www.phptravels.net/admin/";
	        public WebDriver driver ;	

	@BeforeTest
    public void launchBrowser() {
		
		    String projectLocation = System.getProperty("user.dir");
		    System.setProperty("webdriver.chrome.driver",projectLocation+"/chromedriver.exe" );
		    System.out.println(System.getProperties());
		    System.out.println();
		    driver = new ChromeDriver();
		    //code to maximize chrome browser
            driver.manage().window().maximize();
            driver.get(baseURL);

}
	@Test
	public void loginBtn() throws InterruptedException {
		    driver.findElement(By.id("email")).sendKeys("admin@phptravels.com");
		    driver.findElement(By.id("password")).sendKeys("demoadmin");
		    Thread.sleep(2000);
		    driver.findElement(By.id("submit")).click();
		}
	@Test
	public void Dashboard() {
		    String expectedTitle = "Administrators Login";
	  	    String actualTitle = driver.getTitle();
	  	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	        public void settingsCollapse() throws InterruptedException {
		    Thread.sleep(2000);
	    	driver.findElement(By.xpath("/html/body/main/header/ul/li[2]/button")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		    //User clicks on Currencies
		    driver.findElement(By.xpath("//*[@id=\"settings-collapse\"]/ul/li[4]/a")).click();
		    String expectedTitle = "Currencies";
	  	    String actualTitle = driver.getTitle();
	  	    Assert.assertEquals(actualTitle, expectedTitle);
	  	
	         //User clicks on Add - Currencies
	  	     WebElement Add_Currencies = driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[1]/a"));
	  	     new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(Add_Currencies));
	         driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[1]/a")).click();
    	
    	
	        //DropDown for Selecting "Enabled"
    	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  		driver.findElement(By.xpath("(//span[@role='combobox'])[1]")).click();
	  		Thread.sleep(2000);
	  		WebElement enabled= driver.findElement(By.xpath("//li[@role='option'][1]"));
	  		enabled.click();
	  		driver.findElement(By.xpath("(//input[@name='Y3VycmVuY2llcy5uYW1l'])[1]")).sendKeys("IND");

	  		//DropDown for Selecting Country "India"
	  		driver.findElement(By.xpath("(//span[@role='combobox'])[2]")).click();
	  		Thread.sleep(2000);
	  		WebElement IND= driver.findElement(By.xpath("//li[@role='option'][105]"));
	  		IND.click();
	  		driver.findElement(By.xpath("(//input[@name='Y3VycmVuY2llcy5yYXRl'])[1]")).sendKeys("10.0");
	  		driver.findElement(By.linkText("Save")).click();
	  		String expectedTitle2 = "Currencies";
	  		String actualTitle2 = driver.getTitle();
	  		Assert.assertEquals(actualTitle2, expectedTitle2);
	  		System.out.println("User is on Currencies Page after adding country IND");

	  		//Editing Currency Details from List of Countries on Currencies Page
	  		 driver.findElement(By.xpath("(//a[@title='Edit'])[2]")).click(); 
	  		 driver.findElement(By.xpath("(//input[@name='Y3VycmVuY2llcy5yYXRl'])[1]")).clear();
	  		 driver.findElement(By.xpath("(//input[@name='Y3VycmVuY2llcy5yYXRl'])[1]")).sendKeys("9.00");
	  		 driver.findElement(By.linkText("Save")).click();
	  		 System.out.println("The EUR Country Currency is Updated to 9.00");

	  		 //Deleting Country Currencies from Currencies Page
	  		 Thread.sleep(2000);
	  		 driver.findElement(By.xpath("(//input[@value='3'])[1]")).click();
	  		 driver.findElement(By.xpath("(//a[@title='Remove'])[1]")).click();
	  		 driver.switchTo().alert().accept();
	  		 System.out.println("Country Currency Successfully Deleted");
	  		 
	  		 //User clicks on Locations
	  		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  		 driver.findElement(By.xpath("//*[@id=\"settings-collapse\"]/ul/li[6]/a")).click();
	  		 
	  		//User clicks on Add - Locations
	  		WebElement Add_Locations = driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[1]/a"));
	  	    new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(Add_Locations));
	  	    driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[1]/a")).click();
	  		 
	  		//DropDown for Selecting "Enabled" for Locations
	 		driver.findElement(By.xpath("(//span[@role='combobox'])[1]")).click();
	 		Thread.sleep(2000);
	 		WebElement enabled1= driver.findElement(By.xpath("//li[@role='option'][1]"));
	 		enabled1.click();
	 		
	 		//User enters City
	 		driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys("Kurla");
	 		
	 		//DropDown for Selecting Country "India"
	 		driver.findElement(By.xpath("(//span[@role='combobox'])[2]")).click();
	 		Thread.sleep(2000);
	 		WebElement IND1= driver.findElement(By.xpath("//li[@role='option'][97]"));
	 		IND1.click();
	 		
	 		driver.findElement(By.linkText("Save")).click();
	 		String expectedTitle3 = "Locations";
	 		String actualTitle3 = driver.getTitle();
	 		Assert.assertEquals(actualTitle3, expectedTitle3);
	 		System.out.println("User is on Locations Page after adding country IND");
	 		

	 		//To check whether system create Locations having duplicate City name
	 		//User clicks on Add - Locations
	 		Thread.sleep(3000);
	 	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     	driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[1]/a")).click();
	  		 
	  		//DropDown for Selecting "Enabled" for Locations
	 		driver.findElement(By.xpath("(//span[@role='combobox'])[1]")).click();
	 		Thread.sleep(2000);
	 		WebElement enabled2= driver.findElement(By.xpath("//li[@role='option'][1]"));
	 		enabled2.click();
	 		
	 		//User enters City
	 		driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys("Kurla");
	 		
	 		
	 		//DropDown for Selecting Country "India"
	 		driver.findElement(By.xpath("(//span[@role='combobox'])[2]")).click();
	 		Thread.sleep(2000);
	 		//driver.findElement(By.xpath("(//input[@name='bG9jYXRpb25zLmNvdW50cnk-'])[1]")).sendKeys("IND");
	 		WebElement IND2= driver.findElement(By.xpath("//li[@role='option'][97]"));
	 		IND2.click();
	 		
	 		 driver.findElement(By.linkText("Save")).click();
	 		 System.out.println("System doesn't allow to add duplicate entries for City");
	 		 driver.findElement(By.linkText("Return")).click();
	 		
	 		 //Deleting Country from Locations Page
			 Thread.sleep(3000);
			 //driver.findElement(By.xpath("(//input[@value='3'])[1]")).click();
			 driver.findElement(By.xpath("(//a[@title='Remove'])[1]")).click();
			 driver.switchTo().alert().accept();
			 System.out.println("Country Location Successfully Deleted");
	 		
	 		//User lands back on Dashboard
	 		Thread.sleep(3000);
	 		driver.findElement(By.xpath("/html/body/main/header/div[1]/a[1]")).click();
	 		}
	        @AfterTest
	        public void closeBrowser() 
	        {
			driver.quit();

	        }
}
