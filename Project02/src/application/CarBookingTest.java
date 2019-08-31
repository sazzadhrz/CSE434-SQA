package application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarBookingTest {
	WebDriver driver;
	JavascriptExecutor js;
	
	public void scrollUntilFindElement(WebElement WebElement_Path) {
		js.executeScript("arguments[0].scrollIntoView(true);", WebElement_Path);
	}
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.navigate().to("https://www.phptravels.net/m-cars"); 
		js = (JavascriptExecutor)driver;
	}
	
	@BeforeMethod
	public void setup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void searchCarTest() throws InterruptedException {
		WebElement pickUp = driver.findElement(By.xpath("//*[@id='s2id_carlocations']/a/span[1]"));
		
		System.out.println(pickUp.getText());
		pickUp.click();
		Thread.sleep(1500);
		pickUp.sendKeys("sharjah");
		Thread.sleep(1000);
		pickUp.sendKeys(Keys.ENTER);

	/*	WebElement pickupDate = driver.findElement(By.xpath("//*[@id='departcar']"));
		pickupDate.clear();
		pickupDate.click();
		pickupDate.sendKeys("04/09/2019");
//		pickupDate.sendKeys(Keys.ENTER);
		
		WebElement dropoffDate = driver.findElement(By.xpath("//*[@id='departcar']"));
		dropoffDate.clear();
		dropoffDate.click();
		dropoffDate.sendKeys("07/09/2019");
		dropoffDate.sendKeys(Keys.ENTER);  */

	}

}
