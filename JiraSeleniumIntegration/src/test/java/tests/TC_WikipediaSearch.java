package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import metaData.MetaData;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners(listeners.TestListener.class)
public class TC_WikipediaSearch {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/ipolidora/WebDrivers/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://en.wikipedia.org/wiki/Main_Page";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@MetaData(ready=true)
	@Test
	public void testCase() throws Exception {
		driver.get(baseUrl);
		
		driver.findElement(By.id("searchInput")).sendKeys("Penn State");
		driver.findElement(By.id("searchButton")).click();
		String heading = driver.findElement(By.id("firstHeading")).getText();
		
		AssertJUnit.assertEquals(heading, "Selenium");
		driver.quit();
	}
	
	@AfterMethod
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
