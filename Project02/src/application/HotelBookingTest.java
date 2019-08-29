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

public class HotelBookingTest {
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.navigate().to("https://www.phptravels.net/"); //*[@id="s2id_location"]/a
	}
	
	@BeforeMethod
	public void setup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void searchHotel() throws InterruptedException {
		//driver.findElement(By.xpath("//*[@id='body-section']/section/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='s2id_location']/a"));
		
		System.out.println(searchbox.getText());
		searchbox.click();
		searchbox.sendKeys("dhaka");
		Thread.sleep(1000);
		searchbox.sendKeys(Keys.ENTER);

		WebElement dateFrom = driver.findElement(By.xpath("//*[@id='dpd1']/div/input"));
		dateFrom.click();
		dateFrom.sendKeys("04/09/2019");
		dateFrom.sendKeys(Keys.ENTER);
		
		WebElement dateTo = driver.findElement(By.xpath("//*[@id='dpd2']/div/input"));
		dateTo.click();
		dateTo.sendKeys("07/09/2019");
		dateTo.sendKeys(Keys.ENTER);

	}
	
	@Test (priority = 1)
	public void selectHotel() throws InterruptedException {
		Thread.sleep(1000);
		WebElement hotel = driver.findElement(By.xpath("//*[@id='listing']/tbody/tr[1]/td/div[2]/div/h4/a"));
		System.out.println(hotel.getText());
		hotel.click();
	}
	
	@Test (priority = 2)
	public void bookHotel() throws InterruptedException {
		Thread.sleep(1000);
		
		js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 300);");
		
		Thread.sleep(500);
		
		WebElement checkIn = driver.findElement(By.xpath("//*[@id='rooms']/div[2]/div/div/form/div/div[1]/input"));
		WebElement checkOut = driver.findElement(By.xpath("//*[@id='rooms']/div[2]/div/div/form/div/div[2]/input"));
		
		checkIn.clear();
		checkOut.clear();
		
		checkIn.click();
		checkIn.sendKeys("2019-09-04");
		
		checkOut.click();
		checkOut.sendKeys("2019-09-07");
		
		driver.findElement(By.xpath("//*[@id='rooms']/div[2]/div/div/form/div/div[5]/button")).click();
	}
	
	
}
