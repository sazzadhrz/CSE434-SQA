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
		driver.findElement(By.xpath("//*[@id='body-section']/section/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='s2id_location']/a"));
		
		System.out.println(searchbox.getText());
		searchbox.click();
		searchbox.sendKeys("dhaka");
		Thread.sleep(1000);
		searchbox.sendKeys(Keys.ENTER);

		WebElement dateFrom = driver.findElement(By.xpath("//*[@id='dpd1']/div/input"));
		dateFrom.click();
		dateFrom.sendKeys("31/08/2019");
		dateFrom.sendKeys(Keys.ENTER);
		
		WebElement dateTo = driver.findElement(By.xpath("//*[@id='dpd2']/div/input"));
		dateTo.click();
		dateTo.sendKeys("01/09/2019");
		dateTo.sendKeys(Keys.ENTER);

	}
	
	@Test (priority = 1)
	public void selectHotel() throws InterruptedException {
		Thread.sleep(1000);
		WebElement hotelSarina = driver.findElement(By.xpath("//*[@id='listing']/tbody/tr[1]/td/div[2]/div/h4/a"));
		System.out.println(hotelSarina.getText());
		hotelSarina.click();
	}
	
	
	
	
}
